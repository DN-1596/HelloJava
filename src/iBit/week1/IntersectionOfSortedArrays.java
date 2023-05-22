package iBit.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 *
 *
 *
 * Find the intersection of two sorted arrays OR in other words, given 2 sorted arrays,
 * find all the elements which occur in both arrays.
 *
 * NOTE: For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that
 * appear more than once in both arrays should be included multiple times in the final output.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 * 1 <= |B| <= 106
 *
 *
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer array B.
 *
 *
 * Output Format
 * Return an array of intersection of the two arrays.
 *
 *
 * Example Input
 * Input 1:
 * A: [1 2 3 3 4 5 6]
 * B: [3 3 5]
 *
 * Input 2:
 * A: [1 2 3 3 4 5 6]
 * B: [3 5]
 *
 *
 * Example Output
 * Output 1: [3 3 5]
 *
 * Output 2: [3 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 * 3, 3, 5 occurs in both the arrays A and B
 * Explanation 2:
 * Only 3 and 5 occurs in both the arrays A and B
 * */

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {

        int[] A = {3,5};
        int[] B = {3,3,5};
        System.out.println(Arrays.toString(intersect(A, B)));

    }
    public static int[] intersect(final int[] A, final int[] B) {
        int a = 0;
        int b = 0;

        List<Integer> result = new ArrayList<>();

        while (a<A.length && b<B.length) {

            if (A[a] == B[b]) {
                result.add(A[a]);
                a++;
                b++;

            } else if (A[a] < B[b]) {
                a++;
            } else {
                b++;
            }

        }

        int[] res = new int[result.size()];
        int i=0;
        for (int r:result) {
            res[i++] = r;
        }

        return res;
    }
}

