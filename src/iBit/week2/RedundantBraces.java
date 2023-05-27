package iBit.week2;

import java.util.Stack;

/*

Problem Description



        Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

        Chech whether A has redundant braces or not.

        NOTE: A will be always a valid expression.



        Problem Constraints
        1 <= |A| <= 105



        Input Format
        The only argument given is string A.



        Output Format
        Return 1 if A has redundant braces, else return 0.



        Example Input
        Input 1:

        A = "((a+b))"
        Input 2:

        A = "(a+(a+b))"
        Input 3:

        A = "((a*b)+(c+d))"


        Example Output
        Output 1:

        1
        Output 2:

        0
        Output 3:

        0


        Example Explanation
        Explanation 1:

        ((a+b)) has redundant braces so answer will be 1.
        Explanation 2:

        (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
        Explanation 3:

        ((a*b)+(c+d)) doesn't have have any redundant braces so answer will be 0.
*/

public class RedundantBraces {


    public static void main(String[] args) {

        System.out.println(braces("((a+)b))"));

    }


    public static int braces(String A) {

        Stack<Character> stack = new Stack<>();

        int n = A.length();

        for (int i=0;i<n;i++) {

            // Avoiding spaces
            while(i < n && A.charAt(i) == ' ') i++;


            if (i>=n) break;

            char c = A.charAt(i);

            switch (c) {
                case '(' :
                    stack.push(c);
                    break;
                case ')':
                    int operationCount = 0;
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stack.pop();
                        operationCount++;
                    }

                    if (stack.isEmpty() || operationCount == 0) {
                        return 1;
                    }

                    stack.pop();
                    break;
                default:
                    if (isOperation(c)) {
                        stack.push(c);
                    }
                    break;
            }



        }

        return  0;

    }

    public static boolean isOperation(char c) {
        return  c == '+' || c == '-' || c == '*' || c == '/';
    }

}
