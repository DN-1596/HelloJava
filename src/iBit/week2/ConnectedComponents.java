package iBit.week2;

import java.util.*;

/*
Problem Description



        Given a graph with A nodes.
        The edges in graph are given in a 2D array B.
        There is an undirected edge between B[i][0] and B[i][1].
        Find the number of connected components in the given graph.


        Problem Constraints
        1 <= A <= 105
        1 <= |B| <= 105
        1 <= B[i][0], B[i][1] <= A


        Input Format
        First argument is an integer A.
        Second argument is a 2D integer array B.


        Output Format
        Return an integer.


        Example Input
        Input 1:
        A = 4
        B = [[1, 2],
        [2, 3]]
        Input 2:

        A = 3
        B = [1, 2]
        [2, 1]


        Example Output
        Output 1:
        2
        Output 2:

        2


        Example Explanation
        Explanation 1:
        The two connected components are [1, 2, 3] and [4].
        Explanation 2:

        The two connected components are [1, 2] and [3].

*/

public class ConnectedComponents {

    public static void main(String[] args) {

        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        B.add(new ArrayList<>(List.of(1,2)));
        B.add(new ArrayList<>(List.of(2,3)));
        B.add(new ArrayList<>(List.of(3,1)));

        System.out.println(solve(A,B));

    }

    public static class Node {
        final int val;
        final ArrayList<Node> next;

        Node(int val,ArrayList<Node> next) {
            this.next = next;
            this.val = val;
        }
    }

    /**
     * First we will make a boolean array for the A nodes.
     * Then select any unvisited node and traverse through the nodes connected to it and mark them visited.
     * */

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // creating the graph.
        Map<Integer,Node> nodes = new HashMap<>();

        for (int i=1;i<=A;i++) {
            nodes.put(i,new Node(i,new ArrayList<>()));
        }

        for (int i=0;i<B.size();i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            nodes.get(start).next.add(nodes.get(end));
            nodes.get(end).next.add(nodes.get(start));

        }


        boolean[] visited = new boolean[A+1];

        int connectedComps = 0;

        for (int i=1;i<visited.length;i++) {

            if (!visited[i]) {
                connectedComps++;
                traverse(nodes.get(i),visited);
            }

        }

        return connectedComps;

    }

    public static void traverse(Node currentNode,boolean[] visited) {

        visited[currentNode.val] = true;

        for(Node neighbour : currentNode.next) {
            if (!visited[neighbour.val]) {
                traverse(neighbour,visited);

            }
        }
    }


}
