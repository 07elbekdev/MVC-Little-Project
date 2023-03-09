package all.dao;

import all.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> findAll();

    Teacher findById(int id);

    void save(Teacher teacher);

    void deleteById(int id);

    void updateTeacher(int id, Teacher teacher);

    void clear();
}