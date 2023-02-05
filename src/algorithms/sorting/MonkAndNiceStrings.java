package algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class MonkAndNiceStrings {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        int[] results = new int[n];
        for (int i=0;i<n;i++) {

            int res = 0;
            str[i] = br.readLine();
            for (int j = i-1;j>=0;j--) {
                if (str[j].compareTo(str[i]) < 0) res++;
            }
            results[i] = res;
        }

        for (int result : results) {
            System.out.println(result);
        }

    }
}