package com.aniket.ctci.tree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).
     * <p>
     * Example :
     * Given binary tree
     * <p>
     *    3
     *   / \
     *  9  20
     *    /  \
     *   15   7
     * return
     * <p>
     * [
     * [3],
     * [20, 9],
     * [15, 7]
     * ]
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

//        System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder(root));
        System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder1(root));


    }

    /*
     Solution Approach:
        use level order traversal. just reverse list at odd level
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> level = new LinkedList<>();
        level.offer(0);
        int prevLev = -1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer currLevel = level.poll();
            if (currLevel != prevLev && !list.isEmpty()) {
                res.add(new ArrayList<>(list));
                list.clear();
                prevLev = currLevel;
            }
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                level.offer(currLevel + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(currLevel + 1);
            }
        }
        if (!list.isEmpty()) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(res.get(i));
            }
        }

        return res;

    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int dir = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            if (!stack1.isEmpty()) {
                list.clear();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    System.out.print(node.val + " ");
                    pushTostack(node, stack2, dir);


                }
                res.add(new ArrayList<>(list));
            } else if (!stack2.isEmpty()) {
                list.clear();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    System.out.print(node.val + " ");
                    pushTostack(node, stack1, dir);

                }
                res.add(new ArrayList<>(list));
            }
            if (dir == 0) dir = 1;
            else dir = 0;
        }

        return res;


    }

    private void pushTostack(TreeNode node, Stack<TreeNode> stack, int dir) {
        if (dir == 0) {
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        } else {
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
