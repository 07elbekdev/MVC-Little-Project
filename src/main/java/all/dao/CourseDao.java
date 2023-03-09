package all.dao;

import all.model.Course;

import java.util.List;

public interface CourseDao {
    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void deleteById(int id);

    void updateCourse(int id, Course course);

    void clear();
}