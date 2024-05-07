package com.demo.portal.test.visitor2;

/**
 * 我们都是演员 抽象类
 * 抽象元素
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

    /**
     * 拼装其他演员的信息
     */
    protected abstract String accept(IVisitor visitor);

}
