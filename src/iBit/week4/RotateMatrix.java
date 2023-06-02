package iBit.week4;


/*
Problem Description

        You are given a N x N 2D matrix A representing an image.

        Rotate the image by 90 degrees (clockwise).

        You need to do this in place. Update the given matrix A.

        Note: If you end up using an additional array, you will only receive a partial score.

        Problem Constraints
        1 <= N <= 1000

        Input Format
        First argument is a 2D matrix A of integers

        Output Format
        Rotate the given 2D matrix A.
*/

import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(List.of(1,2,3)));
        a.add(new ArrayList<>(List.of(4,5,6)));
        a.add(new ArrayList<>(List.of(7,8,9)));

        rotate(a);

        a.forEach(row -> {
            System.out.println(row);
        });

    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        reverseMatrix(a);
        transpose(a);
    }

    // step1 - reverse the matrix horizontally
    public static void reverseMatrix(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();

        for (int col=0;col<N;col++) {
            for (int row=0;row<N/2;row++) {
                swap(a,row,col,N-row-1,col);
            }
        }
    }

    // step2 - transpose the matrix
    public static void transpose(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();
        for (int row = 0;row<N;row++) {
            int i = row;
            int j = row;

            while (i<N) {
                swap(a,i,j,j,i);
                i++;
            }

        }
    }

    public static void swap(ArrayList<ArrayList<Integer>> a,int ai,int aj,int bi,int bj) {
        int temp = a.get(ai).get(aj);
        a.get(ai).set(aj,a.get(bi).get(bj));
        a.get(bi).set(bj,temp);
    }

}
