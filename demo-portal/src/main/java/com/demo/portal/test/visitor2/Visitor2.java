package com.demo.portal.test.visitor2;


/**
 * 访问者实现
 */
public class Visitor2 implements IVisitor {


    @Override
    public String visit(DungeonMaster dungeonMaster) {
        System.out.println("Visitor2.visit.dungeonMaster");
        String dungeonMasterInfo = getDungeonMasterInfo(dungeonMaster);
        return dungeonMasterInfo;
    }

    @Override
    public String visit(PingjiaBoy pingjiaBoy) {
        System.out.println("Visitor2.visit.pingjiaBoy");
        String pingjiaBoyInfo = getPingjiaBoyInfo(pingjiaBoy);
        return pingjiaBoyInfo;
    }

    /**
     * 组装演员的基本信息
     *
     * @param actor 演员对象
     * @return 演员对象的基本信息
     */
    public String getBaseInfo(Actor actor) {
        String info = "姓名：" + actor.getName() + "\t";
        info += "身份：" + (actor.getPosition() == Actor.SLAVE_POSITION ? "平家boy" : "Dungeon Master") + "\t";
        info += "权力：" + actor.getPower() + "\t";
        return info;
    }

    /**
     * 组装master的信息
     *
     * @param dungeonMaster master对象
     * @return master的信息
     */
    public String getDungeonMasterInfo(DungeonMaster dungeonMaster) {
        String baseInfo = getBaseInfo(dungeonMaster);
        return baseInfo + "职责：" + dungeonMaster.getPerformance() + "\t";
    }

    /**
     * 组装平家boy的信息
     *
     * @param pingjiaBoy 平家boy对象
     * @return 平家boy的信息
     */
    public String getPingjiaBoyInfo(PingjiaBoy pingjiaBoy) {
        String baseInfo = getBaseInfo(pingjiaBoy);
        return baseInfo + "工作：" + pingjiaBoy.getJob() + "\t";
    }
}
