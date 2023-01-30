package arrays.oneD;

// Problem -
// https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/nevedle-and-permutations-c6acb85e/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/// APPROACH 1.
/*class arrays.oneD.Permutations {

    static int n = 0;

    public static void main(String args[] ) throws Exception {
        //BufferedReader
        long startTime, timeAfterInput, timeAfterCalculation;
        startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> metaData = Arrays.stream(br.readLine().split(" "))
                .map(str -> Integer.parseInt(str))
                .toList();
        int n = metaData.get(0);
        int q = metaData.get(1);
        List<Integer> data = Arrays.stream(br.readLine().split(" "))
                .map(str -> Integer.parseInt(str))
                .toList();
        assert data.size() == n;

        int[][] queries = new int[q][2];

        for (int i = 0; i< q ; i++) {
            List<Integer> queryData = Arrays.stream(br.readLine().split(" "))
                    .map(str -> Integer.parseInt(str))
                    .toList();
            queries[i][0] = queryData.get(0);
            queries[i][1]  = queryData.get(1);
        }
        timeAfterInput = System.nanoTime();
        for (int[] query : queries) {
            System.out.println(getMaxFromRemainingSubArray(data,query[0],query[1]));
        }
        timeAfterCalculation = System.nanoTime();

        System.out.println("TIMES -\nINPUT = " + (timeAfterInput-startTime)/1e+9  + " ::: CALCULATION TIME = " + (timeAfterCalculation-timeAfterInput)/1e+9);

    }



    private static int getMaxFromRemainingSubArray(List<Integer> array,int startIndex, int endIndex) {

        int max = -1;

        for (int i=0;i<array.size();i++) {
            if ( startIndex-1 <= i && i <= endIndex-1) {
                continue;
            }
            int element = array.get(i);
            if (max < element) max = element;

        }

        return  max;
    }


}*/

/// APPROACH 2.
class Permutations {

    public static void main(String args[] ) throws Exception {
        //BufferedReader
        long startTime, timeAfterInput, timeAfterCalculation;
        startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> metaData = Arrays.stream(br.readLine().split(" "))
                .map(str -> Integer.parseInt(str))
                .toList();
        int n = metaData.get(0);
        int q = metaData.get(1);
        List<Integer> data = Arrays.stream(br.readLine().split(" "))
                .map(str -> Integer.parseInt(str))
                .toList();
        assert data.size() == n;

        int[][] queries = new int[q][2];

        for (int i = 0; i< q ; i++) {
            List<Integer> queryData = Arrays.stream(br.readLine().split(" "))
                    .map(str -> Integer.parseInt(str))
                    .toList();
            queries[i][0] = queryData.get(0);
            queries[i][1]  = queryData.get(1);
        }
        timeAfterInput = System.nanoTime();
        getMaxFromRemainingSubArray(data,queries);
        timeAfterCalculation = System.nanoTime();

        System.out.println("TIMES -\nINPUT = " + (timeAfterInput-startTime)/1e+9  + " ::: CALCULATION TIME = " + (timeAfterCalculation-timeAfterInput)/1e+9);

    }


    public static void getMaxFromRemainingSubArray(List<Integer> data,int[][] queries) {

        List<Integer> leftMax = getArrayOfMaxOfElementsOnTheLeft(data);
        List<Integer> rightMax = getArrayOfMaxOfElementsOnTheRight(data);

        for (int[] query : queries) {
            int left = query[0]-1;
            int right = query[1]-1;
            System.out.println(
                    leftMax.get(left) > rightMax.get(right)
                            ? leftMax.get(left)
                            : rightMax.get(right)
            );
        }

    }

    private static List<Integer> getArrayOfMaxOfElementsOnTheLeft(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        int max = -1;

        Iterator<Integer> it = data.iterator();
        while (it.hasNext()) {
            result.add(max);
            int element = it.next();
            if (max < element) {
                max = element;
            }
        }

        return  result;
    }

    private static List<Integer> getArrayOfMaxOfElementsOnTheRight(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        int max = -1;

        ListIterator<Integer> it = data.listIterator(data.size());
        while (it.hasPrevious()) {
            result.add(max);
            int element = it.previous();
            if (max < element) {
                max = element;
            }
        }
        Collections.reverse(result);
        return  result;
    }


}
