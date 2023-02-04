package arrays;

// Problem -
// https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/howie-and-the-menus-2-48359fe4/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JamesAndTheMenus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ranges = Arrays.stream(br.readLine().split(" ")).map(c -> Integer.parseInt(c)).toList();

        int n = ranges.get(0);
        int m = ranges.get(1);

        int[][] menus = new int[n][m];

        for (int i = 0; i< n ; i++) {
            List<Integer> menuPrices = Arrays.stream(br.readLine().split(" ")).map(c -> Integer.parseInt(c)).toList();

            for (int j =0 ; j < m; j++) {
                menus[i][j] = menuPrices.get(j);
            }

        }

        System.out.println("INPUT");
        for (int i = 0; i< n ; i++) {
            for (int j =0 ; j < m; j++) {
                System.out.print(menus[i][j] + " ");
            }
            System.out.print("\n");
        }

        findCorrectMenu(n,m,menus);
    }

    public static void findCorrectMenu(int n, int m, int[][] menus) {
        int[] maxPrices = new int[m];
        for (int j =0 ; j < m; j++) {
            for (int i = 0;i< n;i++) {
                maxPrices[j] = Math.max(menus[i][j], maxPrices[j]);
            }
        }

        double[] avgPrices = new double[n];
        int[] numberOfMaxPricesPerMenu = new int[n];

        for (int i = 0;i< n;i++) {
            for (int j =0 ; j < m; j++) {
                avgPrices[i] += menus[i][j] ;
                if (menus[i][j] == maxPrices[j]) {
                    numberOfMaxPricesPerMenu[i]++;
                }
            }
            avgPrices[i] /= m;
        }

        List<Integer> indexesOfDesiredMenus = new ArrayList<>();

        int maxNumberOfMaxPrices = 0;

        for (int numberOfMaxPrices : numberOfMaxPricesPerMenu) {
            maxNumberOfMaxPrices = Math.max(numberOfMaxPrices,maxNumberOfMaxPrices);
        }

        for (int i =0 ;i < n ; i++) {
            if (numberOfMaxPricesPerMenu[i] == maxNumberOfMaxPrices) {
                indexesOfDesiredMenus.add(i);
            }
        }

        double maxAvg = 0 ;
        int maxIndex = 0;

        for (int index : indexesOfDesiredMenus) {
            if (avgPrices[index] > maxAvg) {
                maxAvg = avgPrices[index];
                maxIndex = index;
            }
        }

        System.out.println(maxIndex+1);

    }

}
