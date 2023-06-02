package iBit.week3;

import java.util.Map;

/*
Given an integer A.

        Compute and return the square root of A.

        If A is not a perfect square, return floor(sqrt(A)).

        DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.

        NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.



        Problem Constraints
        0 <= A <= INTMAX


        Input Format
        The first and only argument given is the integer A.



        Output Format
        Return floor(sqrt(A))
*/
public class SqrtofInteger {

    public static void main(String[] args) {

        System.out.println(sqrt(2147483647));

    }

    public static int sqrt(int A) {
        return A<=1 ? A : (int) Math.floor(searchSqrt(A,1));
    }

    // Incorrect approach
    public static double searchSqrt(int A,double k) {

        int sqr = (int) Math.floor(k*k);

        if (sqr == A) {
            return k;
        } else if (sqr < A) {
            k++;
        } else {
            k--;
        }

        System.out.println(k);

        return searchSqrt(A,k);

    }


}
