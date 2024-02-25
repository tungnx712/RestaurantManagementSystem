package com.example.pjjava;

public class Employee {
    private Integer emp_ID;
    private String emp_name;
    private Double salary;
    private String position;

    public Employee() {
    }

    public Employee(Integer emp_ID, String emp_name, Double salary, String position) {
        this.emp_ID = emp_ID;
        this.emp_name = emp_name;
        this.salary = salary;
        this.position = position;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_ID=" + emp_ID +
                ", emp_name='" + emp_name + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}
