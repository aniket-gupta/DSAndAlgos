package com.aniket.ctci.tree;

public class LowestCommonAncestor {

    public static TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return null;
        }

        if(root.val == n1.val || root.val == n2.val) {
            return root;
        }

        TreeNode left = LCA(root.left, n1, n2);
        TreeNode right = LCA(root.right, n1, n2);

        if(left != null && right != null) {
            return  root;
        }

        if(left != null) {
            return  left;
        } else if (right != null) {
            return right;
        } else {
            return  null;
        }
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        root.left.right = n3;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode n1 = new TreeNode(8);
        root.left.left.left = n1;
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(20);

        root.left.right.left.left = new TreeNode(11);
        TreeNode n2 = new TreeNode(30);
        root.left.right.left.right = n2 ;


        TreeNode x = LCA(root,n1,n2);
        System.out.println("Lowest Common Ancestor ("+n1.val +", "+ n2.val +" ) is " + x.val);
        x = LCA(root,n2,n3);
        System.out.println("Lowest Common Ancestor ("+n2.val +", "+ n3.val +" ) is " + x.val);
    }
}
