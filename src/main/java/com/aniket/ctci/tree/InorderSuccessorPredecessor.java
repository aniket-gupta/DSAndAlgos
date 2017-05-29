package com.aniket.ctci.tree;


public class InorderSuccessorPredecessor {

    static int successor;
    static int predecessor;

    // for Binary search tree
    public static void successorPredecessorBST(TreeNode root, int val) {

        if (root != null) {

            if (root.data == val) {

                // predecessor -> rigt most node in left subtree
                if (root.left != null) {
                    TreeNode t = root.left;
                    while (t.right != null) {
                        t = t.right;
                    }
                    predecessor = t.data;
                }

                // successor -> left most node in right subtree
                if (root.right != null) {
                    TreeNode t = root.right;
                    while (t.right != null) {
                        t = t.right;
                    }

                    successor = t.data;
                }
            } else if (root.data > val) {
                successor = root.data;
                successorPredecessorBST(root.left, val);
            } else if (root.data < val) {
                predecessor = root.data;
                successorPredecessorBST(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(7);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.left.right.left = new TreeNode(13);
        root.left.right.right = new TreeNode(18);
        successorPredecessorBST(root, 10);
        System.out.println("Inorder Successor of 10 is : " + successor
                + " and predecessor is : " + predecessor);
        successorPredecessorBST(root, 30);
        System.out.println("Inorder Successor of 30 is : " + successor
                + " and predecessor is : " + predecessor);
    }

}
