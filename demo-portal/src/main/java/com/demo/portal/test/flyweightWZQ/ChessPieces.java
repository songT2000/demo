package com.demo.portal.test.flyweightWZQ;

import java.awt.*;

/**
 * 抽象享元角色：棋子
 */
public interface ChessPieces {

    public void downPieces(Graphics g, Point pt);

    public void showPoint(Point pt);

}
