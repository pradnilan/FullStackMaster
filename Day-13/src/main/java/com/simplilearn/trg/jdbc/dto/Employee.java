package com.simplilearn.trg.jdbc.dto;

public class Employee {

    private int empID;
    private String empName;
    private String empDesignation;

    public Employee() {
    }

    public Employee(int empID, String empName, String empDesignation) {
        this.empID = empID;
        this.empName = empName;
        this.empDesignation = empDesignation;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDessignation) {
        this.empDesignation = empDessignation;
    }
}
