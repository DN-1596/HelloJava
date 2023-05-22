package iBit.week1;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElement {

    public static void main(String[] args) {

        int[] A = {34, 35, 27, 42, 5, 28, 39, 20, 28 };

        Arrays.stream(prevSmaller(A)).forEach(value -> System.out.println(value));

    }

    /**
     * This approach tracks global minima
     * */
    public static int[] prevSmaller1(int[] A) {
        int smallestIndex = -1;
        int[] G = new int[A.length];

        for(int i=0;i<A.length;i++) {

            if (smallestIndex == -1) {
                G[i] = -1;
                smallestIndex = i;
            } else {
                if (A[smallestIndex] >= A[i]) {
                    smallestIndex = i;
                    G[i] = -1;
                } else {
                    G[i] = A[smallestIndex];
                }
            }

        }

        return G;

    }

    /**
     * The probblem statement requires that we track only the local minima from any
     * element
     * */
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> minStack = new Stack<>();
        minStack.push(-1);
        int[] G = new int[A.length];

        for(int i=0;i<A.length;i++) {

            while(minStack.peek() != -1 && A[minStack.peek()] >= A[i] ) {
                minStack.pop();
            }

            if (minStack.peek() == -1) {
                G[i] = -1;
            } else {
                G[i] = A[minStack.peek()];
            }

            minStack.push(i);

        }

        return G;

    }

}
