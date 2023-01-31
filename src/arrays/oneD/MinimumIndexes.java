package arrays.oneD;

// Problem -
// https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/yassers-conditions-6cc26a09/

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class MinimumIndexes {
    public static final Scanner sc = new Scanner(new InputStreamReader(System.in));
    public static final int minValue = -2;
    public static void main(String[] args) {
        int n = sc.nextInt();
        int queries = sc.nextInt();
        int[] A = new int[n];
        for (int i=0;i<n;i++) {
            A[i] = sc.nextInt();
        }

        int[] minIndexes = new int[n];

        for (int i=0;i<n;i++) {
            int minIndex = -2;
            for (int j=i+1;j<n;j++) {
                if (A[i] < A[j] && getDigitSum(A[i]) > getDigitSum(A[j])) {
                    minIndex = j;
                    break;
                }
            }
            minIndexes[i] = minIndex;
        }

        while (queries-- > 0) {
            int query = sc.nextInt()-1;
            System.out.println(minIndexes[query]+1);
        }

    }

    public static int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n%10;
            n/=10;
            sum += digit;
        }
        return  sum;
    }

}
