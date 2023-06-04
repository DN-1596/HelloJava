package iBit.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

Problem Description

        Given an integer array A of size N consisting of unique integers from 1 to N. You can swap any two integers atmost B times.

        Return the largest lexicographical value array that can be created by executing atmost B swaps.



        Problem Constraints
        1 <= N <= 10e6

        1 <= B <= 10e9



        Input Format
        First argument is an integer array A of size N.

        Second argument is an integer B.



        Output Format
        Return an integer array denoting the largest lexicographical value array that can be created by executing atmost B swaps.



        Example Input
        Input 1:

        A = [1, 2, 3, 4]
        B = 1
        Input 2:

        A = [3, 2, 1]
        B = 2


        Example Output
        Output 1:

        [4, 2, 3, 1]
        Output 2:

        [3, 2, 1]
*/
public class LargestPermutation {

    public static void main(String[] args) {
//        System.out.println(solve(new ArrayList<>(List.of(2,5,1,3,4)),2));
//        System.out.println(solve(new ArrayList<>(List.of(8, 2, 7, 4, 5, 6, 3, 1 )),2));
        System.out.println(solve(new ArrayList<>(List.of(3, 2, 4, 1, 5)),3));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        int N = A.size();

        int[] IT = new int[N+1]; // index table

        for (int i=0;i<N;i++) {
            IT[A.get(i)] = i;
        }

        int ti = 0; // targetIndex
        int tv = N; // targetValue


        while (B > 0 && ti < N) {

            if (A.get(ti) != tv) {
                int x = IT[tv];
                IT[tv] = ti;
                IT[A.get(ti)] = x;

                Collections.swap(A,ti,x);
                B--;
            }


            ti++;
            tv--;

        }

        return  A;

    }

}
