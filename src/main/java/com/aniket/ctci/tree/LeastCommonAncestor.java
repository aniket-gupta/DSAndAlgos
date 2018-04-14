package com.aniket.ctci.tree;


import java.util.Stack;

public class LeastCommonAncestor {

    /**
     * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
     *
     *  Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
     * Example :
     *
     *
     *         _______3______
     *        /              \
     *     ___5__          ___1__
     *    /      \        /      \
     *    6      _2_     0        8
     *          /   \
     *          7    4
     * For the above tree, the LCA of nodes 5 and 1 is 3.
     *
     *  LCA = Lowest common ancestor
     * Please note that LCA for nodes 5 and 4 is 5.
     *
     * You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
     * No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
     * There are no duplicate values.
     * You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        int lca = lca(root, 7, 8);
        System.out.println(lca);
    }

    public static int lca(TreeNode root, int n1, int n2) {
        if (root == null) return -1;
        if (n1 == n2) return n1;

        Stack<Integer> pathToN1 = pathTo(root, n1);
        Stack<Integer> pathToN2 = pathTo(root, n2);

        int ancestor = -1;
        while (!pathToN1.isEmpty() && !pathToN2.isEmpty()) {
            Integer p1 = pathToN1.pop();
            Integer p2 = pathToN2.pop();
            if (p1 == p2) ancestor = p1;
            else break;
        }

        return ancestor;
    }

    private static Stack<Integer> pathTo(TreeNode root, int n) {
        if (root == null) return null;
        if (root.val == n) {
            Stack<Integer> stack = new Stack<>();
            stack.push(root.val);
            return stack;
        }

        Stack<Integer> left = pathTo(root.left, n);
        Stack<Integer> right = pathTo(root.right, n);
        if (left != null) {
            left.push(root.val);
            return left;
        }
        if (right != null) {
            right.push(root.val);
            return right;
        }
        return null;

    }


}
