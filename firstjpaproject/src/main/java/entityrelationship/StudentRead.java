package entityrelationship;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentRead {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Prajwal");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student s1 = entityManager.find(Student.class, 2);

        System.out.println(s1.getName() +" "+ s1.getRollNo()+" "+ s1.getCard().getCardNo() +" "+ s1.getCard().getSoftwareVersion());

        System.out.println(s1.getName());

        for (Course c : s1.getCourseList()) {

            System.out.println(c.getCourseName());
            
        }
        /*For these two statements two saperate queries will be run by jpa while using @OneToOne(fetch = FetchType.LAZY) */

        // System.out.println(" "+ s1.getRollNo()+" "+ s1.getCard().getCardNo() +" "+ s1.getCard().getSoftwareVersion());


        /*If we dont call for the details of the card and only ask for the Student info  then also it will give us all the info of the card 
         * 
         * this problem is because when we ware adding the foreign key using @OneToOne annotation   the default fetch type was EGER
         * @OneToOne(fetch = FetchType.EGER)  -- Default
         * To stop it we have to make it LAZY
         * @OneToOne(fetch = FetchType.LAZY)  -- Change it
        */

        // StudentIdCard c1 = entityManager.find(StudentIdCard.class,3 );

        // System.out.println(c1.getStudent().getName() + " " +c1.getCardNo() +" "+c1.getSoftwareVersion());


        /*1- Student s1 = entityManager.find(Student.class, 1);
         * 2- StudentIdCard c1 = entityManager.find(StudentIdCard.class,3 );
         * 
         * Executing both at a time will lead to a formation of a complex query because it takes both the mapping as different 
         * 
         * 
         */

        //  Course cc1 = entityManager.find(Course.class, 5);

        //  System.out.println(cc1.getCourseName()+" "+cc1.getStudent().getName());
    }
}
