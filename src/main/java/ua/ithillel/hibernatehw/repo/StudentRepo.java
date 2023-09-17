package ua.ithillel.hibernatehw.repo;

import ua.ithillel.hibernatehw.model.entity.Student;

import java.util.List;

public interface StudentRepo {
    Student save(Student student);

    void delete(Student student);

    boolean delete(Class<?> tClass, Long id);

    Student update(Student student);

    List<Student> getAllStudents();

    Student getStudentByID(Long id);
}
