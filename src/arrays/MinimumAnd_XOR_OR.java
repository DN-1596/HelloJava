package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// PROBLEM -
// Given an array A of N integers. Find out the minimum value of the following expression for all valid
// (Ai AND Aj) XOR (Ai OR Aj)
// where i!=j
//.

/// CONCEPT -How to minimize f(A,B) = (A AND B) XOR (A OR B) where A,B >= 0 ?
/// Minimizing f(A, B) = (A AND B) XOR (A OR B), where A and B are non-negative, is a bitwise optimization problem.
//
//In binary representation, A AND B gives the bits that are set in both A and B, while A OR B gives the bits that are set
// in either A or B. The XOR operation then flips the bits that are set in exactly one of the operands.
//
//One way to minimize the function is to find the values of A and B that result in the smallest number of set bits in
// the XOR operation. This can be achieved by making A and B as similar as possible, so that the AND operation sets
// as many bits as possible, and the OR operation clears as many bits as possible.
//
//For example, if A and B are both 1, then (A AND B) XOR (A OR B) = 1 XOR 1 = 0, which is the minimum possible value for
// the function.
//
//Note that this is just one possible strategy for minimizing the function, and there may be other methods that yield different results.
// It is also important to consider the specific requirements and constraints for the optimization problem,
// such as the size of A and B, and the specific values that are allowed for A and B.

// VIDEO - https://www.youtube.com/watch?v=jmD5V4yRMsw&list=PL1YS4hYJip07A-YteNUR8qTeA_wHQarDX&index=46



public class MinimumAnd_XOR_OR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int queries=Integer.parseInt(br.readLine()); queries>0; queries--) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> input = new ArrayList<>();
            input.addAll(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList());
            Collections.sort(input);
            long min = (long) Math.pow(10,9) + 1;
            for (int i=0;i<n-1;i++) {
                min = Math.min(computeBitOp(input.get(i),input.get(i+1)),min);
            }
            System.out.println(min);
        }
    }

    public static int computeBitOp(int a,int b) {
        return (a&b)^(a|b);
    }

}
