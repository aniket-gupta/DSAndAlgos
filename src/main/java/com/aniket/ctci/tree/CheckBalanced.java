package com.aniket.ctci.tree;

/**
 * Implement a function to check if binary tree is balanced
 */
public class CheckBalanced {

    public static int heightofBT(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(heightofBT(root.left), heightofBT(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heighDiff = heightofBT(root.left) - heightofBT(root.right);
        if(Math.abs(heighDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // improved algo
    public static int checkHeight(TreeNode root) {
        if(root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) {
            return  Integer.MIN_VALUE;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
         }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        System.out.println(heightofBT(root));

        System.out.println(isBalanced(root));

        System.out.println(checkHeight(root) != Integer.MIN_VALUE);

        root.right.right.right = new TreeNode(38);
        root.right.right.right.right = new TreeNode(40);
        System.out.println(heightofBT(root));
        System.out.println(isBalanced(root));

        System.out.println(checkHeight(root) != Integer.MIN_VALUE);

    }
}
