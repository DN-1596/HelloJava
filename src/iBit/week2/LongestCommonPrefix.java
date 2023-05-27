package iBit.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


/*
Problem Description



        Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in
        the array.

        Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of
        both S1 and S2.

        For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



        Problem Constraints
        0 <= sum of length of all strings <= 1000000



        Input Format
        The only argument given is an array of strings A.



        Output Format
        Return the longest common prefix of all strings in A.

*/

public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] strings = new String[] {"abab", "ab", "abcd"};
        System.out.println(longestCommonPrefix(new ArrayList<>(Arrays.asList(strings))));

    }


    public static String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder result = new StringBuilder();

        int minLength = 1000001;

        for (String s : A) {
            minLength = Math.min(s.length(),minLength);
        }

        for (int i=0 ;i<minLength;i++) {
            char c = A.get(0).charAt(i);

            for (String s : A) {
               if (s.charAt(i) != c) {
                   return result.toString();
               }
            }

            result.append(c);

        }

        return result.toString();
    }


}
