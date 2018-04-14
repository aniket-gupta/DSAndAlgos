package com.aniket.ctci.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * For example, you may serialize the following tree
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     *
     *
     */

    public static void main(String[] args) {
//        [5,2,3,null,null,2,4,3,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);

        String s = serialize(root);


        System.out.println(serialize(deserialize(s)));

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "null";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder strBuilder = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                strBuilder.append("null");

            } else {
                strBuilder.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(!queue.isEmpty()) strBuilder.append(",");
        }

        return strBuilder.toString();

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data == "" ) return null;
        String[] input = data.split(",");
        if(input[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node =  queue.poll();
            TreeNode left = null;
            TreeNode right = null;
            if(i < input.length) {
                String s = input[i++];
                if(!s.equals("null"))
                    left = new TreeNode(Integer.parseInt(s));
            }
            if(i < input.length) {
                String s = input[i++];
                if(!s.equals("null"))
                    right = new TreeNode(Integer.parseInt(s));
            }
            node.left = left;
            node.right = right;
            if (left != null) queue.offer(left);
            if (right != null) queue.offer(right);
        }

        return root;

    }
}
