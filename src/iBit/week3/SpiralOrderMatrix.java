package iBit.week3;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description



        Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.



        Problem Constraints
        1 <= A <= 1000
*/


public class SpiralOrderMatrix {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> spiralMatrix = generateMatrix(5);

        spiralMatrix.forEach(row -> System.out.println(row));


    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int square = A*A;

        int[][] s = new int[A][A];

        int spiralStep = A;
        int ele = 1,i = 0, j=0 ;

        while (spiralStep >= 1) {

            for (int steps=0;steps<spiralStep;steps++,j++) {
                s[i][j] = ele++;
            }
            spiralStep--;
            j--;
            i++;

            for (int steps=0;steps<spiralStep;steps++,i++) {
                s[i][j] = ele++;
            }
            i--;
            j--;

            for (int steps=0;steps<spiralStep;steps++,j--) {
                s[i][j] = ele++;
            }
            spiralStep--;
            j++;
            i--;

            for (int steps=0;steps<spiralStep;steps++,i--) {
                s[i][j] = ele++;
            }
            i++;
            j++;

        }

        ArrayList<ArrayList<Integer>> S = new ArrayList<>();

        for ( i=0;i<A;i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (j=0;j<A;j++) {
                row.add(s[i][j]);
            }
            S.add(row);
        }

        return S;

    }




}
