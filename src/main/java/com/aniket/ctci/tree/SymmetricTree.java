package com.aniket.ctci.tree;


import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * But the following [1,2,2,null,3,null,3] is not:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetricIterative(root));

    }

    // -------------- recursive solution -----------------
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 != null &&
                root2 != null &&
                root1.val == root2.val) {
            return isSymmetric(root1.left, root2.right) &&
                    isSymmetric(root1.right, root2.left);
        }
        return false;
    }
    // -----------------------------------------------------------


    // -------------- iterative -----------------
    public boolean isSymmetricIterative(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if ((left != null && right == null) ||
                    (left == null && right != null))
                return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;


    }
}
