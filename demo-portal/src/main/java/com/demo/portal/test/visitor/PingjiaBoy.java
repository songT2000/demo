package com.demo.portal.test.visitor;

public class PingjiaBoy extends Actor {

    //工作
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    protected String getOtherInfo() {
        return "工作：" + this.getJob();
    }
}
