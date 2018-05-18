package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    ArrayList<int[]> solution = new ArrayList<>();

        int[] sol1 = {1, 2, 3};
        int[] sol2 = {4, 5, 6};
        int[] sol3 = {7, 8, 9};
        int[] sol4 = {1, 4, 7};
        int[] sol5 = {2, 5, 8};
        int[] sol6 = {3, 6, 9};
        int[] sol7 = {1, 5, 9};
        int[] sol8 = {3, 5, 7};
        solution.add(sol1);
        solution.add(sol2);
        solution.add(sol3);
        solution.add(sol4);
        solution.add(sol5);
        solution.add(sol6);
        solution.add(sol7);
        solution.add(sol8);

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
        while(gameRunning){
            System.out.println(currentPlayer + "'s turn: ");

            placePiece(reader, currentPlayer, board);

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
        int input = reader.nextInt();
        if (board.get(input) != " "){
            System.out.println("Spot taken");
            placePiece(reader, currentPlayer, board);
        } else {
            board.put(input, currentPlayer);
        }
    }
}
