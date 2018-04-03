package com.aniket.ctci.tree;

import java.util.*;

public class LevelOrderTraversal {

    // variation 1
    public static void levelOrderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int level = 0;

        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {

            level = queue.size();

            while (level > 0) {

                TreeNode n = queue.remove();

                System.out.print(" " + n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
                level--;

            }

            System.out.println("");

        }

    }

    // variation 2
    public static void reverseLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            stack.add(node);
        }

        while (!stack.isEmpty()) {
            System.out.print(" " + stack.pop().val);
        }

    }

    // // variation 3
    public static void spiralLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>();
        boolean evenLevel = false;

        int levelNodes = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelNodes = queue.size();
            arrayList.clear();
            while (levelNodes > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                arrayList.add(node);
                levelNodes--;
            }

            if (evenLevel) {
                System.out.println(arrayList);
                System.out.println("");
                evenLevel = !evenLevel;
            } else {
                Collections.reverse(arrayList);
                System.out.println(arrayList);
                System.out.println("");
                evenLevel = !evenLevel;
            }


        }


    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        levelOrderTraversal(root);
        System.out.println("");
        reverseLevelOrderTraversal(root);
        System.out.println("");
        spiralLevelOrderTraversal(root);

    }
}
