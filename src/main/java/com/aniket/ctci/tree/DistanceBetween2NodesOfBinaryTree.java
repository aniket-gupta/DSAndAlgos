package com.aniket.ctci.tree;


import java.util.Stack;

public class DistanceBetween2NodesOfBinaryTree {

    /**
     * Find distance between two nodes of a Binary Tree
     * Find the distance between two keys in a binary tree,
     * no parent pointers are given. Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left= new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right= new TreeNode(8);

        System.out.println("Dist(4,5) => " + findDist(root, 4, 5));
        System.out.println("Dist(4,6) => " + findDist(root, 4, 6));
        System.out.println("Dist(3,4) => " + findDist(root, 3, 4));
        System.out.println("Dist(2,4) => " + findDist(root, 2, 4));
        System.out.println("Dist(8,5) => " + findDist(root, 8, 5));

    }


    private static Stack<Integer> findPath(TreeNode root, int n) {
        if (root == null) return null;
        if (root.val == n) {
            Stack<Integer> stack = new Stack<>();
            stack.push(root.val);
            return stack;
        }
        Stack<Integer> leftStack = findPath(root.left, n);
        if (leftStack != null) {
            leftStack.push(root.val);
            return leftStack;
        }

        Stack<Integer> rightStack = findPath(root.right, n);
        if (rightStack != null) {
            rightStack.push(root.val);
            return rightStack;
        }
        return null;
    }

    public static int findDist(TreeNode root, int n1, int n2) {
        Stack<Integer> stack1 = findPath(root, n1);
        Stack<Integer> stack2 = findPath(root, n2);
        if (stack1 != null && stack2 != null) {
            int len1 = stack1.size();
            int len2 = stack2.size();
            int count  = 0;
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int val1 = stack1.pop();
                int val2 = stack2.pop();
                if (val1 == val2) count++;
                else break;
            }
            return len1 + len2 - 2 * count;
        }

        return 0;
    }
}
