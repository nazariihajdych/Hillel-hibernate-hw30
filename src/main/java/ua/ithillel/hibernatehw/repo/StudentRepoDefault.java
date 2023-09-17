package ua.ithillel.hibernatehw.repo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import ua.ithillel.hibernatehw.model.entity.Student;

import java.util.List;

@RequiredArgsConstructor
public class StudentRepoDefault implements StudentRepo {

    private final SessionFactory sessionFactory;

    @Override
    public Student save(Student student) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(student);
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public void delete(Student student) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.remove(student);
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean delete(Class<?> type, Long id){
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Student student = (Student) entityManager.find(type, id);
            if (student != null){
                entityManager.remove(student);
                entityManager.flush();
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public Student update(Student student) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.merge(student);
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        return entityManager.createQuery("SELECT s FROM student s", Student.class).getResultList();
    }

    @Override
    public Student getStudentByID(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Student student = entityManager.find(Student.class, id);

            entityManager.getTransaction().commit();

            return student;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
