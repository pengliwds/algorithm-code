package com.pengli.designPattern.structural.componentPattern;

public interface OrganizationComponent {

    String getName();

    String getRole();

    void showDetail(String indent);

    void add(OrganizationComponent organizationComponent);

    void remove(OrganizationComponent organizationComponent);

    double getCost();
}
