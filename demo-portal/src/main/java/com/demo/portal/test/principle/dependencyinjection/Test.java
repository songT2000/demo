package com.demo.portal.test.principle.dependencyinjection;

public class Test {
    public static void main(String[] args) {

        Programmer programmer1 = new JavaProgrammer();
        Programmer programmer2 = new PHPProgrammer();
        programmer1.work();
        programmer2.work();

    }
}
