package com.aniket.ctci.tree;

/**
 * Created by AnGupta on 5/9/17.
 */
public class IsBinarySearchTree {

    public static boolean isBinarySearchTree(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;

        if( (min != null && root.val <= min ) ||
                (max != null && root.val > max)) {
            return false;
        }

        if(!isBinarySearchTree(root.left, min, root.val) || !isBinarySearchTree(root.right, root.val, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        System.out.println(isBinarySearchTree(root, null, null));
    }
}
