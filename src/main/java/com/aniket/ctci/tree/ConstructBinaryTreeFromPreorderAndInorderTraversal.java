package com.aniket.ctci.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5 };
        int[] inorder = {3, 2, 4, 1, 5};

        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<>(Arrays.asList(3, 2, 4, 1, 5)));

        preorder(root);

        System.out.println();

        inorder(root);



    }

//    static int pIndex = 0;

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//        return buildTree(preorder, inorder, 0, inorder.length - 1);
//
//    }
//
//    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
//
//        if(start > end || pIndex >= preorder.length) return null;
//
//        TreeNode root = new TreeNode(preorder[pIndex++]);
//        if(start == end) return root;
//
//        int mid = indexOf(inorder, start, end, root.val);
//
//        root.left = buildTree(preorder, inorder, start, mid - 1);
//        root.right = buildTree(preorder, inorder, mid + 1, end);
//        return root;
//
//    }
//
//    private int indexOf(int[] inorder, int start, int end, int val) {
//        int index = -1;
//
//        for(int i = start; i <= end; i++) {
//            if(inorder[i] == val) {
//                return i;
//            }
//        }
//        return index;
//    }

    static int pIndex = 0;
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        return buildTree(preorder, inorder, 0, inorder.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int start, int end) {

        if(start > end || pIndex >= preorder.size()) return null;

        TreeNode root = new TreeNode(preorder.get(pIndex++));
        if(start == end) return root;

        int mid = indexOf(inorder, start, end, root.val);

        root.left = buildTree(preorder, inorder, start, mid - 1);
        root.right = buildTree(preorder, inorder, mid + 1, end);
        return root;

    }

    private int indexOf(ArrayList<Integer> inorder, int start, int end, int val) {
        int index = -1;

        for(int i = start; i <= end; i++) {
            if(inorder.get(i) == val) {
                return i;

            }
        }
        return index;
    }

    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    static void preorder(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
