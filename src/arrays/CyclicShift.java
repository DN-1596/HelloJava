package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// Problem and Solution - https://www.youtube.com/watch?v=VGYOHSWJeKU&list=PL1YS4hYJip07A-YteNUR8qTeA_wHQarDX&index=45


public class CyclicShift {

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-->0) {
            List<Integer> params = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
            int n = params.get(0);
            int k = params.get(1);
            String binary = br.readLine();
            printCyclicShiftCount(n,k,binary);
        }
    }

    // Naive Approach
    //  [sum] and max and be too big hence not a solution
    private static void getCyclicShiftsForK(int n, int k,String binary) {
        List<Integer> A = new ArrayList<>();

        int sum = 0;
        int x = (int) Math.pow(2,n);
        for (int i = 0 ;i < n ; i++) {
            int b = getBinaryInt(binary.charAt(i));
            A.add(b);
            sum += (int) Math.pow(2,n-1-i) * b;
        }

        int maxSum  = -1, _sum = sum;
        for (int i = 1 ;i <= n ; i++) {
            int leading = A.get(i == n ? n-1 : i-1);

            if (leading == 1) {
                _sum = 2*_sum + 1 - x;
            } else {
                _sum*=2;
            }
            maxSum = Math.max(_sum,maxSum);
        }

        int c = 0 ,i = 1;

        while (c<k) {
            int leading = A.get((i%n) ==0 ? n-1 : (i%n)-1);
            i++;

            if (leading == 1) {
                sum = 2*sum + 1 - x;
            } else {
                sum*=2;
            }

            if (sum == maxSum) c++;

        }

        System.out.println(i-1);


    }

    // Correct approach but [sum] and max and be too big hence not a solution
    private static void printCyclicShiftCount(int n, int k,String binary) {

        int[] A = new int[n];
        int repFreq = n;

        int sum = 0;
        int x = (int) Math.pow(2,n);
        for (int i = 0 ;i < n ; i++) {
            int b = getBinaryInt(binary.charAt(i));
            sum += (int) Math.pow(2,n-1-i) * b;
            A[i] = b;
        }

        int max = -1;
        int maxIndex = 0;

        for (int i = 0 ;i < n ; i++) {

            if (max < sum) {
                max = sum;
                maxIndex = i;
            } else if (max == sum) {
                repFreq = i - maxIndex;
                break;
            }

            if (A[i] == 1) {
                sum = 2*sum + 1 - x;
            } else {
                sum*=2;
            }
        }

        System.out.println(maxIndex + (k-1)*repFreq);

    }

    public static int getBinaryInt(char a) {
        return  a == '0' ? 0 : 1;
    }

    // as [k] can be huge as well, therefore above approach is further enhanced to handle this case.
    public static void printCyclicShiftCountStringApproach(int n, long k,String binary) {

        int repFreq = n;
        String max = "";
        int maxIndex = 0;
        StringBuilder stringBuilder = new StringBuilder(binary);

        for (int i = 0 ;i < n ; i++) {

            String s = stringBuilder.toString();
            int compare = max.compareTo(s);

            if (compare < 0) {
                max = s;
                maxIndex = i;
            } else if (compare == 0) {
                repFreq = i - maxIndex;
                break;
            }

            stringBuilder.append(s.charAt(0)).deleteCharAt(0);

        }

        System.out.println(maxIndex + (k-1)*repFreq);

    }


}
