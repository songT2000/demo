package com.demo.portal.test.iterator;

import java.util.List;

/**
 * 信息学院迭代器
 */
public class InfoCollegeIterator implements Iterator {

    private List<Department> departments;

    //索引
    int index = 0;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (departments != null && departments.size() > 0 && index < departments.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Department department = departments.get(index);
        index++;
        return department;
    }

    @Override
    public void remove(Object o) {

    }
}
