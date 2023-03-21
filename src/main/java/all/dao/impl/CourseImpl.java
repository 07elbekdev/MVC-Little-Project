package all.dao.impl;

import all.dao.CompanyDao;
import all.dao.CourseDao;
import all.model.Company;
import all.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CourseImpl implements CourseDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Course p", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course where id=:courseId").setParameter("courseId", id).executeUpdate();
    }

    @Override
    public void updateCourse(int id, Course course) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = findById(id);
        course1.setName(course.getName());
        course1.setDuration(course.getDuration());
        session.merge(course1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course").executeUpdate();
    }

    @Override
    public List<Course> showAllTheRelationsOfCourse(int id) {
        List<Course> courses = new ArrayList<>();
        Company company = companyDao.findById(id);
        for (Course course : findAll()) {
            Course course1 = findById(course.getId());
            if (course1.getCompany().getId() == company.getId()) {
                courses.add(course1);
            }
        }
        return courses;
    }
}