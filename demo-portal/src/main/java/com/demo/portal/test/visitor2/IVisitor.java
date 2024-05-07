package com.demo.portal.test.visitor2;

/**
 * 观众老爷 访问者接口
 *
 * 访问者模式抽象访问者
 */
public interface IVisitor {

    /**
     * 定义可以访问的master
     */
    public String visit(DungeonMaster dungeonMaster);
    /**
     * 定义可以访问的平家boy
     */
    public String visit(PingjiaBoy pingjiaBoy);
}
