package com.aniket.ctci.tree;

/**
 * Created by AnGupta on 5/11/17.
 */
public class MirrorTree {

    public static void toMirrorTree(TreeNode root) {
        if(root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            toMirrorTree(root.left);
            toMirrorTree(root.right);
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

        LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println("");

        toMirrorTree(root);

        LevelOrderTraversal.levelOrderTraversal(root);
        System.out.println("");

    }
}
