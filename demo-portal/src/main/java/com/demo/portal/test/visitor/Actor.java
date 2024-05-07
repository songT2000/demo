package com.demo.portal.test.visitor;

/**
 * 角色类
 */
public abstract class Actor {

    //主人
    public static final int MASTER_POSITION = 1;
    //奴隶
    public static final int SLAVE_POSITION = 0;

    //姓名
    private String name;
    //身份
    private int position;
    //权力
    private int power;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void report() {
        String info = "姓名：" + this.name + "\t";
        info += "身份：" + (this.position == SLAVE_POSITION ? "平家boy" : "Dungeon Master") + "\t";
        info += "权力：" + this.power + "\t";
        info += this.getOtherInfo();
        System.out.println(info);
    }

    protected abstract String getOtherInfo();

}
