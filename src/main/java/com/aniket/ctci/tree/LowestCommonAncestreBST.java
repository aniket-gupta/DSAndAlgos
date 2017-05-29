package com.aniket.ctci.tree;

public class LowestCommonAncestreBST {

    public static TreeNode LCABST(TreeNode root, TreeNode n1, TreeNode n2) {
       while (root != null) {

           if(root.data > n1.data && root.data > n2.data) {
               root = root.left;
           } else if (root.data < n1.data && root.data < n2.data) {
               root = root.right;
           } else {
               return root;
           }

       }
       return  root;
    }

    // recursive solution
    public static TreeNode LCA_BST_RECUR(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return  null;
        }
        if(root.data > n1.data && root.data > n2.data) {
            return  LCA_BST_RECUR(root.left, n1, n2);
        } else if (root.data < n1.data && root.data <n2.data) {
            return LCA_BST_RECUR(root.right, n1, n2);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        TreeNode n1 = new TreeNode(5);
        root.left.left = n1;
        root.left.right = new TreeNode(13);
        TreeNode n2 = new TreeNode(14);
        root.left.right.right = n2;
        root.left.right.left = new TreeNode(12);


        System.out.println("Recursive-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : "
                + LCA_BST_RECUR(root, n1, n2).data);

        TreeNode x = LCABST(root, n1, n2);
        System.out.println("Iterative-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : " + x.data);
    }
}
