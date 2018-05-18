package com.company;

import java.util.HashMap;

public class Board {
    private HashMap<Integer, String> board = new HashMap<>();

    public Board(){
        board.put(1," ");
        board.put(2," ");
        board.put(3," ");
        board.put(4," ");
        board.put(5," ");
        board.put(6," ");
        board.put(7," ");
        board.put(8," ");
        board.put(9," ");
    }

    public void put(int input, String currentPlayer) {
        board.put(input, currentPlayer);
    }
    public String get(int input) {
        return board.get(input);
    }
    public void show(){
        System.out.println("\n");
        System.out.println("Current");
        System.out.println(" " + board.get(1) + "|" + board.get(2) + "|" + board.get(3) + "   1|2|3");
        System.out.println(" -|-|-   -|-|-");
        System.out.println(" " + board.get(4) + "|" + board.get(5) + "|" + board.get(6) + "   4|5|6");
        System.out.println(" -|-|-   -|-|-");
        System.out.println(" " + board.get(7) + "|" + board.get(8) + "|" + board.get(9) + "   7|8|9" + "\n");
        }
    }

