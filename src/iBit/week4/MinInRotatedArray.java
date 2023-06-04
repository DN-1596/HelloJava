package iBit.week4;


/*
Problem Description



        Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

        (i.e., 1 2 4 5 6 7 might become 4 5 6 7 1 2).

        Find the minimum element.

        The array will not contain duplicates.

        Note:- Use the circular rotated property of the array to solve the problem.


        Problem Constraints
        1 <= len(A) <= 105
        1 <= A[i] <= 109
*/


import java.util.List;

public class MinInRotatedArray {



    public static void main(String[] args) {
        System.out.println(findMin(List.of(7,8,9,10,11,1,2,3,4)));
    }

    public static int findMin(final List<Integer> a) {
        return findMinInRange(a,0,a.size()-1);
    }

    public static int findMinInRange(final List<Integer> a,int i,int j) {

        if (i>j) return -1;

        int midIndex = (i+j)/2;
        int mid = a.get(midIndex);

        if (i==j) return mid;

        if (j-i+1 == 2) {
            return Math.min(a.get(i),a.get(j));
        }

        int prev = a.get(midIndex-1);
        int next = a.get(midIndex+1);

        boolean isStrictlyIncreasing = prev<mid && mid<next;

        if (a.get(i) < mid && a.get(j) < mid) {
            return findMinInRange(a,midIndex+1,j);
        } else if (isStrictlyIncreasing) {
            return findMinInRange(a,i,midIndex-1);
        } else {
            return mid;
        }



    }





}
