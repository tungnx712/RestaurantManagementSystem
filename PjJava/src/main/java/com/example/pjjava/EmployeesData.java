package com.example.pjjava;

public class EmployeesData {

    private Integer emp_ID;
    private String emp_name;
    private String position;
    private String department;
    private Double salary;
    private String image;

    public EmployeesData() {
    }

    public EmployeesData(Integer emp_ID, String emp_name, String position, String department, Double salary, String image) {
        this.emp_ID = emp_ID;
        this.emp_name = emp_name;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.image = image;
    }

    public Integer getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(Integer emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
