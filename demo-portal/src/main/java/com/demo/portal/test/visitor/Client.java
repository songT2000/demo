package com.demo.portal.test.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Client.mockActors();
    }

    public static void mockActors() {
        List<Actor> actors = new ArrayList<>();
        // 马凯
        PingjiaBoy makai = new PingjiaBoy();
        makai.setName("马凯");
        makai.setPosition(Actor.SLAVE_POSITION);
        makai.setPower(0);
        makai.setJob("Show~ Yes Sir");
        // 吾作
        PingjiaBoy wuzuo = new PingjiaBoy();
        wuzuo.setName("吾作");
        wuzuo.setPosition(Actor.SLAVE_POSITION);
        wuzuo.setPower(0);
        wuzuo.setJob("Show~ Yes Sir");
        // 地牢统治者
        DungeonMaster van = new DungeonMaster();
        van.setName("Van");
        van.setPosition(Actor.MASTER_POSITION);
        van.setPower(10000);
        van.setPerformance("Take it boy");
        actors.add(van);
        actors.add(makai);
        actors.add(wuzuo);

        for (Actor actor : actors) {
            actor.report();
        }
    }

}
