package com.demo.portal.test.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        //获取学校学院集合
        List<College> collegeList = new ArrayList<>();
        ComputerCollege computerCollege = new ComputerCollege();
        computerCollege.addDepartment("Java专业", " Java专业 ");
        computerCollege.addDepartment("PHP专业", " PHP专业 ");
        computerCollege.addDepartment("大数据专业", " 大数据专业 ");
        collegeList.add(computerCollege);
        InfoCollege infoCollege = new InfoCollege();
        infoCollege.addDepartment("信息安全专业", " 信息安全专业 ");
        infoCollege.addDepartment("网络安全专业", " 网络安全专业 ");
        infoCollege.addDepartment("服务器安全专业", " 服务器安全专业 ");
        collegeList.add(infoCollege);

        Iterator<College> iterator = collegeList.iterator();
        while(iterator.hasNext()){
            College next = iterator.next();
            System.out.println("=== " + next.getName() + "=====");
            com.demo.portal.test.iterator.Iterator iterator1 = next.createIterator();
            while (iterator1.hasNext()){
                Object next1 = iterator1.next();
                Department department = (Department) next1;
                System.out.println(" " + department.getName() + " ");
            }

        }

    }
}
