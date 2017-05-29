package com.aniket.ctci.tree;

// Construct Binary Search tree with minimal hight from sorted array
public class MinimalTree {

    public static TreeNode constructMinimalTree(int[] arr, int start, int end) {
        if (arr == null) {
            return null;
        }
        if(start>end) return null;

        int mid = (end + start) / 2;
        TreeNode leftTree = constructMinimalTree(arr, start, mid -1);
        TreeNode rightTree = constructMinimalTree(arr, mid+1, end);

        TreeNode root = new TreeNode(arr[mid]);
        root.left = leftTree;
        root.right = rightTree;
        return root;

    }

    public static void inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(" " + root.data);
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        TreeNode root = constructMinimalTree(arr, 0, arr.length - 1);
        LevelOrderTraversal.levelOrderTraversal(root);
        inorderTraversal(root);
    }
}
