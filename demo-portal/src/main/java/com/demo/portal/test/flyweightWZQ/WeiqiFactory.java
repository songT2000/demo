package com.demo.portal.test.flyweightWZQ;

import java.util.ArrayList;

public class WeiqiFactory {

    private ArrayList<ChessPieces> qz;

    public WeiqiFactory() {
        qz = new ArrayList<>();
        WhitePieces whitePieces = new WhitePieces();
        qz.add(whitePieces);
        BlackPieces blackPieces = new BlackPieces();
        qz.add(blackPieces);
    }

    public ChessPieces getChessPieces(String type) {
        if ("w".equalsIgnoreCase(type)) {
            return qz.get(0);
        } else if ("b".equalsIgnoreCase(type)) {
            return qz.get(1);
        } else {
            return null;
        }
    }
}
