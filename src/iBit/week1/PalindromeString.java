package iBit.week1;

//Problem Description
//
//
//
//Given a string, determine if it is a palindrome. While checking for a palindrome, you have to ignore spaces, case, and all special characters; i.e. consider only alphanumeric characters.
//
//Check the sample test case for reference.
//Return 0 / 1 ( 0 for false, 1 for true ) for this problem
//
//
//Problem Constraints
//1 <= |A| <= 106
//
//
//Input Format
//The first argument is a string A.
//
//
//Output Format
//Return 0 / 1 ( 0 for false, 1 for true ) for this problem
//
//
//Example Input
//Input 1:
//"A man, a plan, a canal: Panama"
//Input 2:
//"race a car"
//
//
//Example Output
//Output 1:
//1
//Output 2:
//0
//
//
//Example Explanation
//Explanation 1:
//The input string after ignoring spaces, and all special characters is "AmanaplanacanalPanama"
//which is a palindrome after ignoring the case.
//Explanation 2:
//The input string after ignoring spaces, and all special characters is "raceacar" which is not a palindrome

public class PalindromeString {
    public static void main(String[] args) {

        System.out.println(isPalindrome("9"));

    }

    public static int isPalindrome(String A) {

        StringBuilder filteredA = new StringBuilder();

        for (char c: A.toCharArray()) {
            if (c >= 65 && c <= 90) {
                filteredA.append(Character.toLowerCase(c));
            }
            if (c >= 97 && c<=122) {
                filteredA.append(c);
            }
            if (c >= 48 && c<=57) {
                filteredA.append(c);
            }


        }

        A = filteredA.toString();
        int n = A.length();
        int checkUptoIndex = (n%2 == 0) ? (A.length()/2)-1 : (int) Math.floor(n/2);
        for (int i=0;i<=checkUptoIndex;i++) {
            int start = i;
            int end = n-i-1;

            if (A.charAt(start) != A.charAt(end)) return 0;
        }

        return 1;

    }
}
