package com.demo.portal.test.visitor;

/**
 * 地牢统治者
 */
public class DungeonMaster extends Actor{

    //职责
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    protected String getOtherInfo() {
        return "职责：" + this.getPerformance();
    }
}
