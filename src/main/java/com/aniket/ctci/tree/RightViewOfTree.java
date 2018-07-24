package com.aniket.ctci.tree;

public class RightViewOfTree {

    /**
     * Print Right View of a given binary tree
     */

    /** Solution
     * Traverse the tree from right to left
     * Print the first node you encounter
     * Take two variables , currentLevel=0 and nextLevel=1
     * As soon as you change level , change the currentLevel = nextLevel
     * Print only when current level<nextLevel so this way you will print only the first element
     * For rest of the nodes on the the level currentLevel and nextLevel are equal so it wont print
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        printRightView(root);
    }

    static class CurrLevel {
        int level;
    }

    public static void printRightView(TreeNode root) {
        printRightView(root, 1, new CurrLevel());
    }

    private static void printRightView(TreeNode root, int nextLevel, CurrLevel curr) {
        if(root == null) return;
        if (curr.level < nextLevel) {
            System.out.println(root.val);
            curr.level = nextLevel;
        }
        printRightView(root.right, nextLevel + 1, curr);
        printRightView(root.left, nextLevel + 1, curr);
    }
}
