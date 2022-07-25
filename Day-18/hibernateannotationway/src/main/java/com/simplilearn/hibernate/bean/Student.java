package com.simplilearn.hibernate.bean;

import javax.persistence.*;

@Entity
@Table(name = "studentdata2")
public class Student {

    @Id @Column(name = "roll_no",nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    public int rollNo; //this will play a roll of primary key
    @Column(name = "first_name")
    public String firstName;
    @Column(name="last_name")
    public String lastName;
    @Column(name = "standard")
    public int std;
    @Column(name = "grade")
    public String grade;

    public Student() {
    }

    public Student(String firstName, String lastName, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", std=" + std +
                ", grade='" + grade + '\'' +
                '}';
    }
}
