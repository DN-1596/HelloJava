package arrays.oneD;

// Problem -
// Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School,
// he assigned a task to his new student Mishki. Mishki will be provided with an integer array A of size N and
// an integer K , where she needs to rotate the array in the right direction by K steps and then print the resultant array.
// As she is new to the school, please help her to complete the task.
//
//Video approach to solve this question: https://www.youtube.com/watch?v=mX38pWM--0M&list=PL1YS4hYJip07A-YteNUR8qTeA_wHQarDX&index=42
//
//Input:
//The first line will consists of one integer T denoting the number of test cases.
//For each test case:
//1) The first line consists of two integers N and K, N being the number of elements in the array and K denotes the number of steps of rotation.
//2) The next line consists of N space separated integers , denoting the elements of the array A.
//
//Output:
//Print the required array.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MonkAndRotation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> params = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();
            int n = params.get(0);
            int rotation = params.get(1);
            rotation = rotation % n;
            List<String> data = Arrays.stream(br.readLine().split(" ")).toList();


            for (int i = n-rotation; i < n; i++) {
                stringBuilder.append(data.get(i) + " ");
            }
            for (int i = 0; i < n-rotation; i++) {
                stringBuilder.append(data.get(i) + " ");
            }
            System.out.println(stringBuilder);


        }

    }

}
