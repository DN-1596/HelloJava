package iBit.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Problem Description
//
//
//
//        Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 105



public class SymmetricBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);

        TreeNode t1 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        System.out.println(isSymmetric(t1.left,t1.right));



    }

    public static int isSymmetricNaive(TreeNode A) {

        List<Integer> leftAlignedTree = new ArrayList<>();
        List<Integer> rightAlignedTree = new ArrayList<>();

        getLeftAlignedTree(A.left,leftAlignedTree);
        getRightAlignedTree(A.right,rightAlignedTree);

        int i=0;
        for (;i<leftAlignedTree.size() && i<rightAlignedTree.size();i++) {
            if (!Objects.equals(leftAlignedTree.get(i), rightAlignedTree.get(i))) {
                return 0;
            }
        }

        if (i == leftAlignedTree.size() && i == rightAlignedTree.size()) {
            return 1;
        } else {
            return 0;
        }



    }

    public static void getLeftAlignedTree(TreeNode A, List<Integer> leftAlignedTree) {

        if (A == null) return;

        if (A.left != null) {
            getLeftAlignedTree(A.left,leftAlignedTree);
        }

        leftAlignedTree.add(A.val);

        if (A.right != null) {
            getLeftAlignedTree(A.right,leftAlignedTree);
        }



    }

    public static void getRightAlignedTree(TreeNode A, List<Integer> rightAlignedTree) {

        if (A == null) return;

        if (A.right != null) {
            getRightAlignedTree(A.right,rightAlignedTree);
        }

        rightAlignedTree.add(A.val);

        if (A.left != null) {
            getRightAlignedTree(A.left,rightAlignedTree);
        }



    }



    /**
     * Most Optimized solution as no extra space is required
     * */
    public static boolean isSymmetric(TreeNode r1,TreeNode r2)
    {
        if(r1==null && r2 == null)
        {
            return true;
        }
        if(r1 == null || r2 == null)
        {
            return false;
        }
        if(r1.val!= r2.val) return false;

        return isSymmetric(r1.left,r2.right) && isSymmetric(r1.right,r2.left);
    }


}
