package com.aniket.ctci.tree;

public class LowestCommonAncestreBST {

    public static TreeNode LCABST(TreeNode root, TreeNode n1, TreeNode n2) {
       while (root != null) {

           if(root.val > n1.val && root.val > n2.val) {
               root = root.left;
           } else if (root.val < n1.val && root.val < n2.val) {
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
        if(root.val > n1.val && root.val > n2.val) {
            return  LCA_BST_RECUR(root.left, n1, n2);
        } else if (root.val < n1.val && root.val <n2.val) {
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
                + n1.val + " and " + n2.val + " is : "
                + LCA_BST_RECUR(root, n1, n2).val);

        TreeNode x = LCABST(root, n1, n2);
        System.out.println("Iterative-Lowest Common Ancestor of Nodes "
                + n1.val + " and " + n2.val + " is : " + x.val);
    }
}
