package iBit.week2;

import java.util.*;


/*
Problem Description

        Given a sorted array A consisting of duplicate elements.

        Your task is to remove all the duplicates and return the length of the sorted array of distinct elements
        consisting of all distinct elements present in A.

        **Note: You need to update the elements of array A by removing all the duplicates


        Problem Constraints
        1 <= |A| <= 10^6
        1 <= Ai <= 2 * 10^9


        Input Format
        First and only argument containing the integer array A.

        Output Format
        Return a single integer, as per the problem given.

Example - A = [1, 2, 2, 3, 3]
Output - 3


Tricky input --- Your submission failed for the following input
A : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ]

The expected return value:
0 1 2 3
*/

public class RemoveDuplicatesFromSrtedArray {

    public static void main(String[] args) {


//        Integer[] arr = new Integer[] {1,2,3,3,4,4,4,5,6};
        Integer[] arr = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));

        System.out.println(removeDuplicates(a));
    }


    /**
     * This gives TLE for large inputs.
     * */
    public static int removeDuplicatesNaive(ArrayList<Integer> a) {

        if (a.size() <= 1) return a.size();

        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;


        while (i<a.size() && j<a.size()) {

            if (i==j) {
                result.add(a.get(i));
                j++;
            } else if (!Objects.equals(a.get(i), a.get(j))) {
                result.add(a.get(j));
                i=j;
                j++;
            } else {
                j++;
            }

        }

        i=0;
        for(int ele : result) {
            a.set(i,ele);
            i++;
        }

        while(a.size()>i) {
            a.remove(i);
        }

        return  result.size();

    }


    /**
     * !Objects.equals(a.get(i), a.get(j))
     * is very important for the input case [5000,5000,5000]
     * do test this out.
     * */

    /**
     * [removeDuplicatesNaive2] also gives TLE because removal takes O(n) time.
     * */

    public static int removeDuplicatesNaive2(ArrayList<Integer> a) {

        if (a.size() <= 1) return a.size();

        int i=0;
        int j=0;


        while (i<a.size() && j<a.size()) {

            if (i==j) {
                j++;
            } else if (!Objects.equals(a.get(i), a.get(j))) {
                i=j;
                j++;
            } else {
                a.remove(j);
            }

        }

        return  a.size();

    }


    /**
     * Swapping is O(1) operation
     * */
    public static int removeDuplicates(ArrayList<Integer> a) {


        if (a == null || a.size() <= 1) return a.size();

        int i=0;


        for (int j=1;j<a.size();j++) {
            if (!a.get(i).equals(a.get(j))) {
                i++;
                a.set(i,a.get(j));
            }
        }

        while (a.size() > i+1 ) {
            a.remove(a.size()-1);
        }


        return  a.size();

    }

}
