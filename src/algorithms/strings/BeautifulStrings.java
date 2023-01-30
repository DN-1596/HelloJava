package algorithms.strings;

// Problem -
// https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/beautiful-strings-10/
// Ref - https://www.youtube.com/watch?v=10OaJi-1dYg

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeautifulStrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int i = 0 ;
        while (i < n) {
            inputs.add(br.readLine());
            i++;
        }

        for (String input : inputs) {
//            getBeautyCountNaiveApproach(input);
            getBeautifulSubStringsCountOptimized(input);
        }

    }

    public static void getBeautyCountNaiveApproach(String input) {
        int n = input.length();
        int beautyCount = 0;

        for (int i = 0 ;i < n ; i++) {
            for (int j = i ; j < n; j++) {
                if (isBeautifulNaiveApproach(input,i,j)) {
                    beautyCount++;
                }
            }
        }

        System.out.println(beautyCount);
    }

    public static boolean isBeautifulNaiveApproach(String input, int start, int end) {

        boolean isBeautiful;

        if (start < 0 || start > end || end >= input.length()) {
            return false;
        }

        String str = input.substring(start,end+1);
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        for (char ch : str.toCharArray()) {
            if (ch == 'a') aCnt++;
            if (ch == 'b') bCnt++;
            if (ch == 'c') cCnt++;
        }

        isBeautiful = (aCnt == bCnt && cCnt == bCnt);

        return  isBeautiful;
    }

    public static void getBeautifulSubStringsCountOptimized(String input) {

        HashMap<String,Integer> diffCounter = new HashMap<>();
        diffCounter.put("0*0",1);
        int ans = 0;
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        for (char ch : input.toCharArray()) {

            if (ch == 'a') aCnt++;
            if (ch == 'b') bCnt++;
            if (ch == 'c') cCnt++;
            String key = (aCnt - bCnt) + "*" + (aCnt - cCnt);
            ans += diffCounter.getOrDefault(key,0);

            diffCounter.put(key,diffCounter.getOrDefault(key,0) + 1);

        }

        System.out.println(ans);

    }

}
