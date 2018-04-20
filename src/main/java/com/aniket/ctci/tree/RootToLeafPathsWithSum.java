package com.aniket.ctci.tree;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
     *
     * For example:
     * Given the below binary tree and sum = 22,
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * return
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(new RootToLeafPathsWithSum().pathSum(root, 22));
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        pathSum(root, sum, list, res);

        return res;


    }

    private void pathSum(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (root != null) {
            int remaining = sum - root.val;
            list.add(root.val);
            if (remaining == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList<>(list));
            }
            if (root.left != null) {
                pathSum(root.left, remaining, list, res);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                pathSum(root.right, remaining, list, res);
                list.remove(list.size() - 1);
            }

        }
    }
}
