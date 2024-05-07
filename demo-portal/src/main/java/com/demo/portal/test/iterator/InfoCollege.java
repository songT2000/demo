package com.demo.portal.test.iterator;

import java.util.ArrayList;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departments = new ArrayList<>();

    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departments.add(new Department(name, desc));
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }
}
