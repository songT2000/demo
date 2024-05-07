package com.demo.portal.test.principle.singleresponsibility;

public class Test {
    public static void main(String[] args) {
        HighSchoolStudent student = new HighSchoolStudent();
        student.eat();
        student.sleep();
        student.study();
        student.play();
        PrimarySchoolTeacher teacher = new PrimarySchoolTeacher();
        teacher.eat();
        teacher.sleep();
        teacher.teacher();
        teacher.study();
        teacher.play();
    }

}
