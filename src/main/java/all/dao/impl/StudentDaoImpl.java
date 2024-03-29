package all.dao.impl;

import all.dao.GroupsDao;
import all.dao.StudentDao;
import all.model.Groups;
import all.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private GroupsDao groupsDao;

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Student p", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id=:studentId").setParameter("studentId", id).executeUpdate();
    }

    @Override
    public void updateStudent(int id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = findById(id);
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        session.merge(student1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student").executeUpdate();
    }

    @Override
    public List<Student> showAllRelationsOfStudent(int id) {
        List<Student> students = new ArrayList<>();
        List<Groups> groups = groupsDao.showAllRelationsOfGroup(id);
        for (Groups groups1 : groups) {
            for (Student student : findAll()) {
                Student student1 = findById(student.getId());
                if (student.getGroup().getId() == groups1.getId())
                    students.add(student1);
            }
        }
        return students;
    }
}