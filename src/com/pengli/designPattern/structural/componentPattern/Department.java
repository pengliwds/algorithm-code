package com.pengli.designPattern.structural.componentPattern;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {

    private String name;
    private List<OrganizationComponent> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return "Department";
    }

    @Override
    public void showDetail(String indent) {
        System.out.println(indent + "Department: " + name);
        for (OrganizationComponent member : members) {
            member.showDetail("--" + indent);
        }
    }

    @Override
    public double getCost() {
        double cost = 0;
        for (OrganizationComponent member : members) {
            cost += member.getCost();
        }
        return cost;
    }

    @Override
    public void add(OrganizationComponent member) {
        members.add(member);
    }
    @Override
    public void remove(OrganizationComponent member) {
        members.remove(member);
    }

    public int getMemberCount() {
        int count = 0;
        for (OrganizationComponent member : members) {
            if (member instanceof Department) {
                count += ((Department) member).getMemberCount();
            } else if (member instanceof Employee) {
                count++;
            }
        }

        return count;
    }


}
