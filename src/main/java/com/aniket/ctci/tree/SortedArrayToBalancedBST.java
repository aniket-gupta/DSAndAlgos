package com.aniket.ctci.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     *  Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * Example :
     *
     *
     * Given A : [1, 2, 3]
     * A height balanced BST  :
     *
     *       2
     *     /   \
     *    1     3
     */

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBalancedBST().sortedArrayToBST(new ArrayList<>(Arrays.asList(1,2,3)));
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public TreeNode sortedArrayToBST(final List<Integer> list) {
        return sortedArrayToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedArrayToBST(List<Integer> list, int start, int end) {
        if(start > end) return null;
        if(start == end) new TreeNode(list.get(start));
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedArrayToBST(list, start, mid - 1);
        root.right = sortedArrayToBST(list, mid+ 1, end);
        return root;

    }
}
