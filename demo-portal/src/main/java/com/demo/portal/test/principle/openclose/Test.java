package com.demo.portal.test.principle.openclose;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.eat();
        student.sleep();
        student.study();

        HighSchoolStudent schoolStudent = new HighSchoolStudent();
        schoolStudent.eat();
        schoolStudent.sleep();
        schoolStudent.study();
        schoolStudent.doSomething();
    }
}
