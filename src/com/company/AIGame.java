package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AIGame {
    public void runGame(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Difficulty?\n1. Easy\n2. Hard");
        int difficultySetting = reader.nextInt();
        System.out.println("Who starts?\n1. You\n2. Computer");
        int firstToMove = reader.nextInt();
        computerStart(difficultySetting, firstToMove);

    }

    public void computerStart(int difficultySetting, int firstToMove){
        Scanner reader = new Scanner(System.in);
        boolean gameRunning = true;
        Board board = new Board();
        Solution solution = new Solution();
        board.show();
        if (difficultySetting == 1){
            if (firstToMove == 2)
                while(gameRunning){
                    placeAI("X", board);
                    board.show();
                    if(isWinner(solution,board)){
                        gameRunning = false;
                        System.out.println("X" + " wins!");
                    }
                    placeHuman(reader,"O", board);
                    if(isWinner(solution,board) && gameRunning != false){
                        gameRunning = false;
                        System.out.println("O" + " wins!");
                    }
            } else if (firstToMove == 1){
                while(gameRunning){
                    placeHuman(reader,"X", board);
                    board.show();
                    if(isWinner(solution,board)){
                        gameRunning = false;
                        System.out.println("X" + " wins!");
                    }
                    placeAI("O", board);
                    board.show();
                    if(isWinner(solution,board)  && gameRunning != false){
                        gameRunning = false;
                        System.out.println("O" + " wins!");
                    }
                    isWinner(solution,board);
                }
            }



        }
    }
    public int newRandom(){
        Random rnd = new Random();
        return rnd.nextInt(9) + 1;
    }

    public void placeAI(String currentPlayer, Board board){
        boolean success = false;

        int spot = newRandom();
        boolean check = false;
        while(!check){
            if(board.get(spot) != " "){
                spot = newRandom();
            } else {
                check = true;
            }
        }
        board.put(spot, currentPlayer);
    }

    public void placeHuman(Scanner reader, String currentPlayer, Board board){
        boolean success = false;
        do {
            try {
                int input = reader.nextInt();

                if (board.get(input) != " ") {
                    System.out.println("Spot unavailable.");
                    reader.nextLine();
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

    public static boolean isWinner(Solution solution, Board board){
        for(int i = 0; i < solution.size(); i++){
            if(board.get(solution.get(i)[0]) != " " && board.get(solution.get(i)[0]) == board.get(solution.get(i)[1]) && board.get(solution.get(i)[1]) == board.get(solution.get(i)[2])){
//                System.out.println(board);
                return true;
            }
        }
        return false;
    }
    //adjacency list//graph
}
