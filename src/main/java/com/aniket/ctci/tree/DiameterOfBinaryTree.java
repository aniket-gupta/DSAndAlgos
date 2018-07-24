package com.aniket.ctci.tree;

public class DiameterOfBinaryTree {

    /**
     * Diameter of a Binary Tree
     * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
     * https://cdncontribute.geeksforgeeks.org/wp-content/uploads/Diameter-of-Binary-Tree.png
     *
     *
     * Find the height of left subtree.
     * Find the height of right subtree.
     * Find the left diameter.
     * Find the right diameter.
     * Return the Maximum(Diameter of left subtree, Diameter of right subtree, Longest path between two nodes which passes through the root.)
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);


        System.out.println("Diameter of Tree: " + diameter(root));
    }

    public static int height(TreeNode root) {
        if (root != null)
            return Math.max(height(root.left), height(root.right)) + 1;
        return 0;
    }

    public static int diameter(TreeNode root) {
        if (root != null) {
            int leftH = height(root.left);
            int rightH = height(root.right);

            int leftD = diameter(root.left);
            int rightD = diameter(root.right);

            return Math.max(leftH + rightH + 1, Math.max(leftD, rightD));


        }
        return 0;
    }
}
