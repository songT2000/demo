package com.demo.portal.test.principle.demeter;

public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Project javaProject = new JAVAProject("java");
        Project pythonProject = new PythonProject("python");
        ProjectLeader projectLeader = new ProjectLeader();
        projectLeader.addProgrammer(new JAVAProgrammer());
        projectLeader.addProgrammer(new PythonProgrammer());
        projectLeader.addProgrammer(new JAVAProgrammer());
        projectLeader.addProgrammer(new PythonProgrammer());
        projectLeader.addProgrammer(new JAVAProgrammer());
        boss.setProjectLeader(projectLeader);
        boss.meet(pythonProject);

    }
}
