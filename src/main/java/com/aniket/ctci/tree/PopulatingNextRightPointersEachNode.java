package com.aniket.ctci.tree;


import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode {

    /**
     *Given a binary tree
     *
     *     struct TreeLinkNode {
     *       TreeLinkNode *left;
     *       TreeLinkNode *right;
     *       TreeLinkNode *next;
     *     }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     *
     *  Note:
     * You may only use constant extra space.
     * Example :
     *
     * Given the following binary tree,
     *
     *          1
     *        /  \
     *       2    3
     *      / \  / \
     *     4  5  6  7
     * After calling your function, the tree should look like:
     *
     *          1 -> NULL
     *        /  \
     *       2 -> 3 -> NULL
     *      / \  / \
     *     4->5->6->7 -> NULL
     *
     */

    static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }


    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        connect(root);
    }


    public static void connect(TreeLinkNode root) {

        if(root != null) {

            Queue<TreeLinkNode> queue = new LinkedList<>();
            Queue<Integer> leveleQueue = new LinkedList<>();
            queue.offer(root);
            leveleQueue.offer(0);
            while(!queue.isEmpty()) {
                TreeLinkNode curr = queue.poll();
                int currLevel = leveleQueue.poll();
                if(queue.isEmpty() || (!queue.isEmpty() && currLevel !=  leveleQueue.peek())) {
                    curr.next = null;
                } else  {
                    curr.next = queue.peek();
                }

                if(curr.left != null) {
                    queue.offer(curr.left);
                    leveleQueue.offer(currLevel + 1);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                    leveleQueue.offer(currLevel + 1);
                }
            }


        }


    }


    private TreeLinkNode getNextNode(TreeLinkNode node)
    {
        node = node.next;
        while(node != null)
        {
            if(node.left != null)
            {
                return node.left;
            }
            if(node.right != null)
            {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }

    // interview bit solution
    public void connect1(TreeLinkNode root) {
        if(root == null)
        {
            return;
        }

        root.next = null;
        while(root != null)
        {
            TreeLinkNode current = root;
            //go through all the nodes in the level of root
            while(current != null)
            {
                if(current.left != null)
                {
                    if(current.right != null)
                    {
                        current.left.next = current.right;
                    }
                    else
                    {
                        current.left.next = getNextNode(current);
                    }
                }
                if(current.right != null)
                {
                    current.right.next = getNextNode(current);
                }


                current = current.next;
            }
            if(root.left != null) root = root.left;
            else if(root.right != null) root = root.right;
            else root = getNextNode(root);

        }

    }


}
