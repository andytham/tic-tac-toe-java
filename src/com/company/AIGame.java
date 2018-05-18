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
        int startingPlayer = reader.nextInt();

        if (startingPlayer == 2){
            computerStart(difficultySetting);
        }
    }

    public void computerStart(int difficultySetting){
        Scanner reader = new Scanner(System.in);
        boolean gameRunning = true;
        if (difficultySetting == 1){

            while(gameRunning){

            }


        }
    }
    public int newRandom(){
        Random rnd = new Random();
        return rnd.nextInt(9) + 1;
    }

    public int placeRandom(){
    return 1;
    }
    public void placeAI(Board board){
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

        board.put(spot, "X");
    }
    //adjacency list//graph
}
