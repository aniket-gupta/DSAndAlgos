package com.aniket.ctci.tree;

import java.util.ArrayList;

public class SumRootToLeafNumbers {

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     *
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * Find the total sum of all root-to-leaf numbers % 1003.
     *
     * Example :
     *
     *     1
     *    / \
     *   2   3
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     *
     * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
     */

    private class SumObject {
        long sum = 0;
    }

    public int sumNumbers(TreeNode root) {
        SumObject sumObject = new SumObject();
        ArrayList<Integer> list = new ArrayList<>();
        sumNumbers(root, list, sumObject);
        return (int)sumObject.sum;
    }

    private void sumNumbers(TreeNode root, ArrayList<Integer> list, SumObject sumObject) {
        if (root != null) {
            list.add(root.val);
            if(root.left == null && root.right == null) {
                long sum = 0;
                for (Integer integer : list) {
                    sum = (sum * 10 + integer)%1003;
                }
                sumObject.sum =  (sumObject.sum %1003 + sum % 1003)%1003;
            }
            if (root.left != null) {
                sumNumbers(root.left, list, sumObject);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                sumNumbers(root.right, list, sumObject);
                list.remove(list.size() - 1);
            }
        }
    }
}
