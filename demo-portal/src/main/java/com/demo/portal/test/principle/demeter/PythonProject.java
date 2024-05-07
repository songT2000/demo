package com.demo.portal.test.principle.demeter;

public class PythonProject implements Project{

    private String type;

    public PythonProject(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
