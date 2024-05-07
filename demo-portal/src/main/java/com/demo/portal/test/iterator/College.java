package com.demo.portal.test.iterator;

/**
 * 学院接口
 */
public interface College {

    //名称
    public String getName();
    //添加系
    public void addDepartment(String name, String desc);
    //生成迭代器
    public Iterator createIterator();

}
