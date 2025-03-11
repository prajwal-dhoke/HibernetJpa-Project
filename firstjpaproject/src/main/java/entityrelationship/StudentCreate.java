package entityrelationship;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentCreate {
    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.setName("Prajwal");

        Student s2 = new Student();
        s2.setName("Rohan");

        StudentIdCard c1 = new StudentIdCard();
        c1.setSoftwareVersion("1.0.1");
        c1.setStudent(s1);
        StudentIdCard c2 = new StudentIdCard();
        c2.setSoftwareVersion("1.0.2");
        c2.setStudent(s2);
        
        s1.setCard(c1);
        s2.setCard(c2);

        Course co1 = new Course();
        co1.setCourseName("C programing");
        Course co2 = new Course();
        co2.setCourseName("DBMS");

        co1.setStudent(s1);
        co2.setStudent(s2);

        List<Course> l1 = new ArrayList<>();
        l1.add(co1);
        l1.add(co2);

        List<Course> l2 = new ArrayList<>();
        l2.add(co2);

        s1.setCourseList(l1);
        s2.setCourseList(l2);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Prajwal2");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        entityManager.persist(s1);
        entityManager.persist(s2);
        entityManager.persist(c1);
        entityManager.persist(c2);

        entityManager.persist(co1);
        entityManager.persist(co2);

        entityTransaction.commit();


    }
}
