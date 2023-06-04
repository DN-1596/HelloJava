package iBit.week4;


/*
Problem Description



        Given a string A containing only lowercase characters.
        Find the frequencies of the characters in order of their occurrence.


        Problem Constraints
        1 <= |A| <= 105


        Input Format
        Given a string A.
*/

import java.util.*;

public class CharacterFrequency {

    public static void main(String[] args) {

        System.out.println(solve("cbbcca"));
    }


    public static ArrayList<Integer> solve(String A) {

        Map<Character,Integer> freq = new HashMap<>();
        ArrayList<Character> orderOfOccurrence = new ArrayList<>();

        for(char c : A.toCharArray()) {
            if (freq.containsKey(c)) {
                freq.put(c,freq.get(c)+1);
            } else {
                orderOfOccurrence.add(c);
                freq.put(c,1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (char c: orderOfOccurrence) {
            res.add(freq.get(c));
        }

        return res;


    }


}
