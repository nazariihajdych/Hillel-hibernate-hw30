package ua.ithillel.hibernatehw;

import org.hibernate.SessionFactory;
import ua.ithillel.hibernatehw.config.HibernateSession;
import ua.ithillel.hibernatehw.model.entity.Student;
import ua.ithillel.hibernatehw.repo.StudentRepo;
import ua.ithillel.hibernatehw.repo.StudentRepoDefault;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        StudentRepo studentRepo = new StudentRepoDefault(sessionFactory);

        Student student1 = new Student();
        student1.setName("Alice");
        student1.setEmail("alice@mail.com");

        Student student2 = new Student();
        student2.setName("Bob");
        student2.setEmail("bob@mail.com");

        Student student3 = new Student();
        student3.setName("Stanley");
        student3.setEmail("stanley@s.com");

        Student student4 = new Student();
        student4.setName("Rob");
        student4.setEmail("rob@mail.com");

        System.out.println("Saving students in DB");
        System.out.println(studentRepo.save(student1));
        System.out.println(studentRepo.save(student2));
        System.out.println(studentRepo.save(student3));
        System.out.println(studentRepo.save(student4));
        System.out.println("************************");

        System.out.println("Get all students from DB");
        System.out.println(studentRepo.getAllStudents());
        System.out.println("************************");

        System.out.println("Get one student from DB by id");
        System.out.println(studentRepo.getStudentByID(9l));
        System.out.println("************************");

        System.out.println("Delete student from DB");
        studentRepo.delete(student1);
        System.out.println(studentRepo.getAllStudents());
        System.out.println("************************");

        System.out.println("Update student");
        System.out.println(studentRepo.getStudentByID(10l));
        student2.setEmail("newStudent2email@mail.com");
        System.out.println(studentRepo.update(student2));
        System.out.println("************************");

        System.out.println("Delete student by id");
        studentRepo.delete(Student.class, 11l);
        System.out.println(studentRepo.getAllStudents());
        System.out.println("************************");

    }
}