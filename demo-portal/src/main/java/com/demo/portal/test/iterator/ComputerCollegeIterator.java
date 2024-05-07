package com.demo.portal.test.iterator;


/**
 * 计算机学院迭代器
 */
public class ComputerCollegeIterator implements Iterator {

    private Department[] departments;

    //索引
    int index = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.length || departments[index] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[index];
        index++;
        return department;
    }

    @Override
    public void remove(Object o) {

    }
}
