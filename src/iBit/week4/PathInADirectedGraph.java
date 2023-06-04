package iBit.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathInADirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        B.add(new ArrayList<>(List.of(1,2)));
        B.add(new ArrayList<>(List.of(4,1)));
        B.add(new ArrayList<>(List.of(2,4)));
        B.add(new ArrayList<>(List.of(3,4)));
        B.add(new ArrayList<>(List.of(5,2)));
        B.add(new ArrayList<>(List.of(1,3)));

        System.out.println(solve(5,B));
    }

    public static class Node {
        int val;
        final ArrayList<Node> next = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }

    }

    public static int solve(int A,ArrayList<ArrayList<Integer>> B) {
        int M = B.size();

        Map<Integer,Node> graph =  new HashMap<>();

        for (int i=1;i<=A;i++) {
            graph.put(i,new Node(i));
        }


        B.forEach(edge -> {
            Node a = graph.get(edge.get(0));
            a.next.add(graph.get(edge.get(1)));
        });

        boolean[] visited = new boolean[A+1];

        return canGetToA(A,graph.get(1),visited) ? 1 : 0;

    }

    public static boolean canGetToA(int A,Node node,boolean[] visited) {


        if (node == null || visited[node.val]) return false;

        visited[node.val] = true;
        if (node.val == A) return true;

        for (Node nbr : node.next) {
            boolean reachedA = canGetToA(A,nbr,visited);
            if (reachedA) return true;
        }

        return false;



    }

}
