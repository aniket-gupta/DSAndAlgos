package com.aniket.ctci.tree;

public class LeftViewOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        printLeftView(root);
    }

    static class CurrLevel {
        int level;
    }

    public static void printLeftView(TreeNode root) {
        printLeftView(root, 1, new CurrLevel());
    }

    private static void printLeftView(TreeNode root, int nextLevel, CurrLevel curr) {
        if (root == null) return;
        if (curr.level < nextLevel) {
            System.out.println(root.val);
            curr.level = nextLevel;
        }

        printLeftView(root.left, nextLevel  +1, curr);
        printLeftView(root.right, nextLevel  +1, curr);

    }
}
