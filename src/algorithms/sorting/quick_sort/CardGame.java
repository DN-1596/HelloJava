package algorithms.sorting.quick_sort;

// Problem -
// https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/card-game-1-44e9f4e7/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> player1Cards = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
        int m = Integer.parseInt(br.readLine());
        List<Integer> player2Cards = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();

        int maxPlayer2Card = getMax(player2Cards);
        Long moneyNeeded = 0L;

        for (int element : player1Cards) {
            if (element <= maxPlayer2Card) {
                moneyNeeded += maxPlayer2Card-element+1;
            }
        }

        System.out.println(moneyNeeded);

    }

    static int getMax(List<Integer> list) {
        int max = -1;

        for (int element : list) {
            max = Math.max(max,element);
        }

        return  max;
    }

}
