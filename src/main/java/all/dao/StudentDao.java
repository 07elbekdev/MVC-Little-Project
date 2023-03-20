package all.dao;

import all.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);

    void updateStudent(int id, Student student);

    void clear();

    List<Student> showAllRelationsOfStudent(int id);
}