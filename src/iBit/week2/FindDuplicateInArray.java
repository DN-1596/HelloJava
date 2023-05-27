package iBit.week2;


//Problem Description
//
//
// Given a read-only array of n + 1 integers between 1 and n, find one number that repeats in linear time using
// less than O(n) space and traversing the stream sequentially O(1) times.
// If there are multiple possible answers ( like in the sample case ), output any one, if there is no duplicate,
// output -1
//
// Problem Constraints
// 1 <= |A| <= 10^5
// 1 <= A[i] <= |A|

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateInArray {

    public static void main(String[] args) {

        System.out.println(repeatedNumber(new int[] {3, 4, 1, 4, 1}));
    }
    public static  int repeatedNumber(final int[] A) {
        Map<Integer,Integer> countMap = new HashMap<>();

        for(int ele:A) {
            if (countMap.containsKey(ele)) {
                return ele;
            } else {
                countMap.put(ele,1);
            }
        }

        return -1;

    }
}
