package com.demo.portal.test.principle.demeter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectLeader implements Manager {

    private List<Programmer> programmers = new ArrayList<>();

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }

    public List<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(List<Programmer> programmers) {
        this.programmers = programmers;
    }

    @Override
    public void meet(Project project) {
        System.out.println("项目经理开会，分发任务");
        if (project instanceof JAVAProject) {
            List<Programmer> collect = programmers.stream().filter(t -> t.getClass().equals(JAVAProgrammer.class)).collect(Collectors.toList());
            collect.stream().forEach(t -> {
                JAVAProgrammer javaProgrammer = (JAVAProgrammer) t;
                javaProgrammer.work();
            });
        }else {
            List<Programmer> collect = programmers.stream().filter(t -> t.getClass().equals(PythonProgrammer.class)).collect(Collectors.toList());
            collect.stream().forEach(t -> {
                PythonProgrammer pythonProgrammer = (PythonProgrammer) t;
                pythonProgrammer.work();
            });
        }
    }
}
