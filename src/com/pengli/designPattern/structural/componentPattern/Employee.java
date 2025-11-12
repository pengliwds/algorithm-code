package com.pengli.designPattern.structural.componentPattern;

public class Employee implements OrganizationComponent {

    private String name;
    private String role;
    private double salary;


    public Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void showDetail(String indent) {
        System.out.println(indent + "Employee: " + name + ", Role: " + role + ", Salary: " + salary);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        // do nothing
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        // do nothing
    }

    @Override
    public double getCost() {
        return salary;
    }
}
