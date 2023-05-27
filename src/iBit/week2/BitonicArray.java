package iBit.week2;

/*
Problem Description



        Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic
        sequence in O(logN) time.

        NOTE:

        A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly
        decreasing.


        Problem Constraints
        3 <= N <= 105

        1 <= A[i], B <= 108

        Given array always contain a bitonic point.

        Array A always contain distinct elements.



        Input Format
        First argument is an integer array A denoting the bitonic sequence.

        Second argument is an integer B.



        Output Format
        Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't
        exist in A return -1.



        Example Input
        Input 1:

        A = [3, 9, 10, 20, 17, 5, 1]
        B = 20
        Input 2:

        A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
        B = 30


        Example Output
        Output 1:

        3
        Output 2:

        -1


        Example Explanation
        Explanation 1:

        B = 20 present in A at index 3
        Explanation 2:

        B = 30 is not present in A
*/

import java.util.ArrayList;
import java.util.List;

public class BitonicArray {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(3, 9, 10, 20, 17, 5, 1)),10));
    }

    public static int peakIndex = -1;

    public static int solve(ArrayList<Integer> A, int B) {

        getPeakIndex(A,0,A.size()-1);

        // System.out.println("PEAK - " + peakIndex);

        int peak = A.get(peakIndex);

        if (B  == peak) {
            return peakIndex;
        }

        int bi = findB(A,B,0,peakIndex-1,true);

        if (bi == -1) {
            return findB(A,B,peakIndex+1,A.size()-1,false);
        }

        return bi;

    }

    public static void getPeakIndex(ArrayList<Integer> A,int i,int j) {

        if (i>j) return;

        int n = (int) Math.floor((i+j)/2);

        // System.out.println("PEAK SUSPECT - " + n);

        if (n == 0 || n == A.size()-1) {
            return;
        }

        int prev = A.get(n-1);
        int peak = A.get(n);
        int next = A.get(n+1);

        // System.out.println(": prev - " + prev + ": peak - " + peak  + ": next - " + next );


        if (prev < peak && peak > next) {
            peakIndex = n;
            return;
        }

        if (prev < peak && peak < next) {
            getPeakIndex(A,n+1,j);
            return;
        }

        if (prev > peak && peak > next) {
            getPeakIndex(A,i,n-1);
            return;
        }

    }

    public static int findB(ArrayList<Integer> A, int B, int i, int j, boolean isIncreasingSeq) {
        if (i>j) return -1;

        int n = (int) Math.floor((i+j)/2);

        if (A.get(n) == B) {
            return n;
        } else if (A.get(n) > B) {
            return isIncreasingSeq ? findB(A,B,i,n-1,isIncreasingSeq) : findB(A,B,n+1,j,isIncreasingSeq);
        } else {
            return isIncreasingSeq ? findB(A,B,n+1,j,isIncreasingSeq) : findB(A,B,i,n-1,isIncreasingSeq);
        }

    }

}
