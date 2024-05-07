package com.demo.portal.test.iterator;

public class ComputerCollege implements College {

    Department[] departments = new Department[100];

    int numOfDepartment = 0;

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        this.departments[numOfDepartment] = new Department(name, desc);
        numOfDepartment++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
