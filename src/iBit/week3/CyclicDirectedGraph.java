package iBit.week3;

/*
Problem Description

        Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

        Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

        NOTE:

        The cycle must contain atleast two nodes.
        There are no self-loops in the graph.
        There are no multiple edges between two nodes.
        The graph may or may not be connected.
        Nodes are numbered from 1 to A.
        Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


        Problem Constraints
        2 <= A <= 105

        1 <= M <= min(200000,A(A-1))

        1 <= B[i][0], B[i][1] <= A

        Output Format
        Return 1 if cycle is present else return 0.

        INPUT -
        A : 5
B :
[
  [1, 2]
  [1, 3]
  [2, 3]
  [1, 4]
  [4, 3]
  [4, 5]
  [3, 5]
]

OUTPUT - 0
*/


import java.util.*;

public class CyclicDirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

//        B.add(new ArrayList<>(List.of(1,2)));
//        B.add(new ArrayList<>(List.of(1,3)));
//        B.add(new ArrayList<>(List.of(2,3)));
//        B.add(new ArrayList<>(List.of(1,4)));
//        B.add(new ArrayList<>(List.of(4,3)));
//        B.add(new ArrayList<>(List.of(4,5)));
//        B.add(new ArrayList<>(List.of(3,5)));
//
//        System.out.println(solve(5,B));

        B.add(new ArrayList<>(List.of(1,3)));
        B.add(new ArrayList<>(List.of(3,2)));
        B.add(new ArrayList<>(List.of(2,3)));

        System.out.println(solve(3,B));
    }


    public static class Node {
        final int val;
        final List<Node> next = new ArrayList<Node>();

        Node(int val) {
            this.val = val;
        }

    }
    public static  int solve(int A, ArrayList<ArrayList<Integer>> B) {

        Map<Integer,Node> graph = new HashMap<>();

        for(int i=1;i<=A;i++) {
            graph.put(i, new Node(i));
        }

        B.forEach(edge -> {
            graph.get(edge.get(0)).next.add(graph.get(edge.get(1)));
        });


        for (int i=1;i<=A;i++) {
            boolean[] visited = new boolean[A+1];

            boolean isCycleDetected = checkCycle(graph.get(i),visited,i);
            if (isCycleDetected) {
                return 1;
            }
        }

        return 0;


    }

    public static boolean checkCycle(Node a,boolean[] visited,int startEle) {
        if (a == null) {
            return false;
        }

        if (visited[a.val]) {
            return a.val == startEle;
        }

        visited[a.val] = true;

        boolean isCycleDetected = false;

        for (Node node : a.next) {
            isCycleDetected = isCycleDetected || checkCycle(node,visited,startEle);
        }

        return isCycleDetected;

    }

}
