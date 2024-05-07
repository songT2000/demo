package com.demo.portal.test.flyweightWZQ;

import java.awt.*;

public class WzqGame {
    public static void main(String[] args) {
//        new ChessBoard();
        WeiqiFactory weiqiFactory = new WeiqiFactory();
        ChessPieces w = weiqiFactory.getChessPieces("w");
        w.showPoint(new Point());
        ChessPieces b = weiqiFactory.getChessPieces("b");
        b.showPoint(new Point(1, 1));
        ChessPieces w2 = weiqiFactory.getChessPieces("w");
        w2.showPoint(new Point(1, 2));
        ChessPieces b2 = weiqiFactory.getChessPieces("b");
        b2.showPoint(new Point(2, 1));

    }
}
