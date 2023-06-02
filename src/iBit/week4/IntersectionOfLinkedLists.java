package iBit.week4;


/*
* Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
* */

public class IntersectionOfLinkedLists {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {



    }

    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        int lenA = getLength(a);
        int lenB = getLength(b);

        while (lenB < lenA) {
            a = a.next;
            lenA--;
        }

        while (lenA < lenB) {
            b = b.next;
            lenB--;
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return  a;

    }

    public static int getLength(ListNode a) {
        if (a == null) {
            return 0;
        }
        return 1+getLength(a.next);
    }

}
