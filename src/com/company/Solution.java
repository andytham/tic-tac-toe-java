package com.company;

import java.util.ArrayList;

public class Solution {
    private ArrayList<int[]>solution = new ArrayList<>();
    public Solution(){
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
    }

    public int size(){
        return solution.size();
    }
    public int[] get(int input){
        return solution.get(input);
    }
}
