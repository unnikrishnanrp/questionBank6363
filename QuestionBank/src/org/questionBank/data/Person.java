package org.questionBank.data;
// Generated Nov 28, 2016 9:15:21 PM by Hibernate Tools 5.2.0.Beta1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name="person"
    ,catalog="questionbank"
)
public class Person  implements java.io.Serializable {


     private Integer id;
     private String firstName;
     private String lastName;
     private String userName;
     private String password;
     private boolean admin;
     private Set<Course> courses = new HashSet<Course>(0);

    public Person() {
    }

	
    public Person(boolean admin) {
        this.admin = admin;
    }
    public Person(String firstName, String lastName, String userName, String password, boolean admin, Set<Course> courses) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.userName = userName;
       this.password = password;
       this.admin = admin;
       this.courses = courses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="first_name", length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="user_name", length=20)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="password", length=20)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="admin", nullable=false)
    public boolean isAdmin() {
        return this.admin;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="teaches", catalog="questionbank", joinColumns = { 
        @JoinColumn(name="person_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="course_id", nullable=false, updatable=false) })
    public Set<Course> getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }




}


