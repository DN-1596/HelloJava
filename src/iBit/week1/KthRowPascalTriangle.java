package iBit.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem Description
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Input : k = 3
 *
 *
 * Return : [1,3,3,1]
 *
 * Note: k is 0 based. k = 0, corresponds to the row [1].
 *
 * Note: Could you optimize your algorithm to use only O(k) extra space?*/

public class KthRowPascalTriangle {


    public static void main(String[] args) {

        Arrays.stream(getRow(25)).forEach(value -> System.out.println(value));

    }

    /**
     * This approach does not work for A > 20
     * because factorial values overflow in calculations
     * */
//    public static int[] getRow(int A) {
//        long[] factorials = new long[A+1];
//        fillFactorials(A,0,factorials);
//        int[] kThRowPascalTriangle = new int[A+1];
//
//        for (int i=0;i<=A;i++) {
//            long res1 = factorials[A] /factorials[A-i];
//            long res2 = res1 / factorials[i];
//            kThRowPascalTriangle[i] = (int) res2;
//        }
//
//        return kThRowPascalTriangle;
//
//
//    }
//
//    public static void fillFactorials(int A, int index,long[] factorials) {
//        if (index > A) {
//            return;
//        }
//
//        if (index == 0) {
//            factorials[index] = 1;
//        } else {
//            factorials[index] = index*factorials[index-1];
//        }
//        fillFactorials(A,index+1,factorials);
//
//    }

    /**
     * Let us make a pascal triangle in the true
     * sense of the word.
     * In this case just maintain  1 row
     * prior to the current
     */

    public static int[] getRow(int A) {
        List<Integer> rowPrev = new ArrayList<>();
        rowPrev.add(1);
        if (A == 0 ) return rowPrev.stream().mapToInt(Integer::intValue).toArray();

        List<Integer> rowCurr =  new ArrayList<>();
        rowCurr.addAll(Arrays.asList(1,1));
        if (A == 1) return rowCurr.stream().mapToInt(Integer::intValue).toArray();

        for (int row = 2;row<=A;row++) {
            rowPrev = rowCurr;
            rowCurr = new ArrayList<>();
            rowCurr.add(1);
            for (int i = 0;i <rowPrev.size()-1;i++) {
                rowCurr.add(rowPrev.get(i)+rowPrev.get(i+1));
            }
            rowCurr.add(1);
        }

        int[] result = new int[rowCurr.size()];

        int i=0;
        for (int a:rowCurr) {
            result[i++] = a;
        }

        return  result;

    }


}
