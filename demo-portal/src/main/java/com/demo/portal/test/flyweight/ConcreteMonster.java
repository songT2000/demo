package com.demo.portal.test.flyweight;

/**
 * 具体享元类
 */
public class ConcreteMonster implements Monster{


    private String type;

    ConcreteMonster(String type){
        this.type = type;
    }


    @Override
    public void showBasicAttackAndDefense() {
        System.out.println("怪物类型："+ this.type + "攻击力：" + Constants.getAttack(type) + "，防御力：" + Constants.getDefense(type));
    }

    @Override
    public void concreteName(String name) {
        System.out.println("怪物名字：" + name + "\n怪物类型："+ this.type + "攻击力：" + Constants.getAttack(type) + "，防御力：" + Constants.getDefense(type));
    }


}
