package com.pengli.designPattern.structural.componentPattern;

public class ComponentPatternTest {

    public static void main(String[] args) {

        Employee employee = new Employee("John", "Java Developer", 50000);
        Employee employee1 = new Employee("Jane", "Manager", 60000);
        Employee employee2 = new Employee("Tom", "CEO", 80000);
        Employee employee3 = new Employee("Mike", "Marketing", 40000);
        Employee employee4 = new Employee("Lisa", "HR", 30000);

        OrganizationComponent root = new Department("Company");
        OrganizationComponent devops = new Department("DevOps");
        OrganizationComponent java = new Department("Java");
        OrganizationComponent manager = new Department("行政管理");


        root.add(devops);
        root.add(manager);
        devops.add(java);
        devops.add(employee2);
        java.add(employee);
        java.add(employee1);
        manager.add(employee3);
        manager.add(employee4);


        root.showDetail("");


        System.out.println("Total cost: " + root.getCost());

        System.out.println("DevOps cost: " + devops.getCost());

        System.out.println("Java cost: " + java.getCost());

        System.out.println("Manager cost: " + manager.getCost());
    }

}
