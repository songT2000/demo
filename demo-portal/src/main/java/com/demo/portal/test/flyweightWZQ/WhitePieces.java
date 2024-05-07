package com.demo.portal.test.flyweightWZQ;

import java.awt.*;

/**
 * 具体享元角色：白子
 */
public class WhitePieces implements ChessPieces{
    @Override
    public void downPieces(Graphics g, Point pt) {
        g.setColor(Color.WHITE);
        g.fillOval(pt.x, pt.y, 30, 30);
    }

    @Override
    public void showPoint(Point pt) {
        System.out.println("白棋下点：" + pt);
    }
}
