package all.dao.impl;

import all.dao.CourseDao;
import all.dao.TeacherDao;
import all.model.Course;
import all.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Teacher p", Teacher.class).getResultList();
    }

    @Override
    public Teacher findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher where id=:teacherId").setParameter("teacherId", id).executeUpdate();
    }

    @Override
    public void updateTeacher(int id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findById(id);
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        session.merge(teacher1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher").executeUpdate();
    }

    @Override
    public List<Teacher> showAllRelationsOfTeacher(int id) {
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = courseDao.showAllTheRelationsOfCourse(id);
        for (Course course : courses) {
            for (Teacher teacher : findAll()) {
                Teacher teacher1 = findById(teacher.getId());
                if (teacher.getCourse().getId() == course.getId()) {
                    teachers.add(teacher1);
                }
            }
        }
        return teachers;
    }
}