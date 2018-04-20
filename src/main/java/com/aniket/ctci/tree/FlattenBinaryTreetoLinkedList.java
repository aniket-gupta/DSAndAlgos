package com.aniket.ctci.tree;

import java.util.ArrayList;

public class FlattenBinaryTreetoLinkedList {

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * Example :
     * Given
     *
     *
     *          1
     *         / \
     *        2   5
     *       / \   \
     *      3   4   6
     * The flattened tree should look like:
     *
     *    1
     *     \
     *      2
     *       \
     *        3
     *         \
     *          4
     *           \
     *            5
     *             \
     *              6
     * Note that the left child of all nodes should be NULL.
     */

    public TreeNode flatten(TreeNode root) {
        if(root == null) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for(int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode next = list.get(i);
            prev.left = null;
            next.left = null;
            prev.right = next;
        }
        return list.get(0);
    }

    private void preOrder(TreeNode root, ArrayList<TreeNode> list) {
        if(root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }


    // -------- InterviewBit solution --------
    public TreeNode flatten1(TreeNode a) {
        if(a==null)
            return null;
        TreeNode node=a;
        while(node!=null)
        {
            if(node.left!=null)
            {
                TreeNode rightmost=node.left;
                while(rightmost.right!=null)
                {
                    rightmost=rightmost.right;


                }
                rightmost.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
        }
        return a;

    }
}
