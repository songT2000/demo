package com.demo.portal.test.flyweightWZQ;

import java.awt.*;

public class BlackPieces implements ChessPieces {
    @Override
    public void downPieces(Graphics g, Point pt) {
        g.setColor(Color.BLACK);
        g.fillOval(pt.x, pt.y, 30, 30);
    }

    @Override
    public void showPoint(Point pt) {
        System.out.println("黑棋下点：" + pt);
    }
}
