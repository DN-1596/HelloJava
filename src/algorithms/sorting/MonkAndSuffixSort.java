package algorithms.sorting;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MonkAndSuffixSort {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> s = Arrays.stream(br.readLine().split(" ")).toList();
        getKSmallestSuffix(s.get(0), Integer.parseInt(s.get(1)));
    }

    public static void getKSmallestSuffix(String S,int k) {

        int i=0;

        StringBuilder stringBuilder = new StringBuilder(S);
        List<String> subStrings = new ArrayList<>();

        while (!stringBuilder.isEmpty()) {
            subStrings.add(stringBuilder.toString());
            stringBuilder.deleteCharAt(0);
        }

        Collections.sort(subStrings);

        System.out.println(subStrings.get(k-1));


    }

}
