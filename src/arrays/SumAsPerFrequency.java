package arrays;

// Problem -
// https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/sum-as-per-frequency-88b00c1f/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SumAsPerFrequency {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<Integer> userInput = Arrays.stream(br.readLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .toList();

        int[] dataFrequency = new int[10000001];
        for (int data : userInput) {
            dataFrequency[data]++;
        }

        long[] frequencySum = new long[n+1];

        for (int i=0;i<dataFrequency.length;i++) {
            int freq = dataFrequency[i];
            frequencySum[freq] += i*freq;
        }

        for (int i=1;i<n+1;i++) {
            frequencySum[i] += frequencySum[i-1];
        }

        int queries = Integer.parseInt(br.readLine());
        while (queries-- > 0) {
            List<Integer> range = Arrays.stream(br.readLine().split(" "))
                    .map(element -> Integer.parseInt(element))
                    .toList();
            int l = range.get(0);
            int r = range.get(1);
            if (l>r) continue;
            System.out.println(frequencySum[r]-frequencySum[l-1]);
        }
    }
}
