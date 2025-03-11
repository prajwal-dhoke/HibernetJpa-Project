package entityrelationship;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

    @Column(name = "Stud_name", nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rollNo;

    /*    @GeneratedValue(strategy = GenerationType.AUTO)
      This is used to give auto incrementation to any primary key */
    // @OneToOne(fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.LAZY)
    private StudentIdCard card;

    /* private StudentIdCard card;  this card type will not known to SQL 
     * Hance it will throw an exception  
     * hanc we have @OneToOne   annotation  to add a foreign key to any table
     */

 /*If we dont call for the details of the card and only ask for the Student info  then also it will give us all the info of the card 
         * 
         * this problem is because when we ware adding the foreign key using @OneToOne annotation   the default fetch type was EGER
         * 
         * To stop it we have to make it LAZY
     */
    @OneToMany(mappedBy = "student")
    private List<Course> courseList;

    public StudentIdCard getCard() {
        return this.card;
    }

    public void setCard(StudentIdCard card) {
        this.card = card;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public List<Course> getCourseList() {
        return this.courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}
