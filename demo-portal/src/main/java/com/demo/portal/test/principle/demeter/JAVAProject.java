package com.demo.portal.test.principle.demeter;

public class JAVAProject implements Project{

    private String type;

    public JAVAProject(String type) {
        this.type = type;
    }

    public JAVAProject() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
