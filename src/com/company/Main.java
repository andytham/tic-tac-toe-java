package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Board board = new Board();
        System.out.println("TIC TAC TOE");
        System.out.println("Select an integer to place\n");
        System.out.println("1|2|3");
        System.out.println("-|-|-");
        System.out.println("4|5|6");
        System.out.println("-|-|-");
        System.out.println("7|8|9\n");


        Scanner reader = new Scanner(System.in);
        boolean gameRunning = true;
        String currentPlayer = "X";
        TwoPlayers two = new TwoPlayers();
        two.runGame();
//        while(gameRunning){
//            System.out.println(currentPlayer + "'s turn: ");
//            placePiece(reader, currentPlayer, board);
//            board.show();
//            if(isWinner(solution, board)) {
//                gameRunning = false;
//                System.out.println(currentPlayer + " wins!");
//            }
//            if (currentPlayer.equals("X")){
//                currentPlayer = "O";
//            } else if (currentPlayer.equals("O")){
//                currentPlayer = "X";
//            }
//        }
    }

    public static boolean isWinner(ArrayList<int[]> solution, Board board){
        for(int i = 0; i < solution.size(); i++){
            if(board.get(solution.get(i)[0]) != " " && board.get(solution.get(i)[0]) == board.get(solution.get(i)[1]) && board.get(solution.get(i)[1]) == board.get(solution.get(i)[2])){
//                System.out.println(board);
                return true;
            }
        }
        return false;
    }

    public static void placePiece(Scanner reader, String currentPlayer, Board board){
        boolean success = false;
        do {
            try {
                int input = reader.nextInt();

                if (board.get(input) != " ") {
                    System.out.println("Spot unavailable.");
                    placePiece(reader, currentPlayer, board);
                } else {
                    board.put(input, currentPlayer);
                    success = true;
                }
            } catch (InputMismatchException exc) {
                System.out.println("Need an integer, 1-9");
                reader.nextLine();
            }
        }
        while(!success);

    }
}
