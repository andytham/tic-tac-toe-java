package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoPlayers {
    Scanner twoPlayersReader = new Scanner(System.in);
    public void runGame(){
        String currentPlayer = "X";
        boolean gameRunning = true;
        Board board = new Board();
        Solution solution = new Solution();
        while(gameRunning){
            System.out.println(currentPlayer + "'s turn: ");
            placePiece(twoPlayersReader, currentPlayer, board);
            board.show();
            if(isWinner(solution, board)) {
                gameRunning = false;
                System.out.println(currentPlayer + " wins!");
            }
            if (currentPlayer.equals("X")){
                currentPlayer = "O";
            } else if (currentPlayer.equals("O")){
                currentPlayer = "X";
            }
        }
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

    public static boolean isWinner(Solution solution, Board board){
        for(int i = 0; i < solution.size(); i++){
            if(board.get(solution.get(i)[0]) != " " && board.get(solution.get(i)[0]) == board.get(solution.get(i)[1]) && board.get(solution.get(i)[1]) == board.get(solution.get(i)[2])){
//                System.out.println(board);
                return true;
            }
        }
        return false;
    }
}
