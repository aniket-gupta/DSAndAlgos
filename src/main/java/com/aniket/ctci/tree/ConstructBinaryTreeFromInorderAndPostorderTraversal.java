package com.aniket.ctci.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
            TreeNode root = buildTree(new ArrayList<>(Arrays.asList(9,3,15,20,7)), new ArrayList<>(Arrays.asList(9,15,7,20,3))  );
        print(root);


    }

    static class Index  {
        int index;
    }

    public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

        Index pIndex = new Index();
        pIndex.index = inorder.size() - 1;
        return buildUtil(inorder, postorder, 0, inorder.size() - 1, pIndex);

    }

    static TreeNode buildUtil(ArrayList<Integer> in, ArrayList<Integer> post, int inStrt,
                       int inEnd, Index pIndex)
    {
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Preorder traversal using
           postIndex and decrement postIndex */
        TreeNode node = new TreeNode(post.get(pIndex.index));
        (pIndex.index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;

        /* Else find the index of this node in Inorder
           traversal */
        int iIndex = search(in, inStrt, inEnd, node.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex);
        node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex);

        return node;
    }


   static int search(ArrayList<Integer> arr, int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++)
        {
            if (arr.get(i) == value)
                break;
        }
        return i;
    }

    public static void print(TreeNode root) {
        if(root != null) {
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }

}
