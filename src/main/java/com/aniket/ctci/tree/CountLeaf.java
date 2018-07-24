package com.aniket.ctci.tree;

import java.util.Scanner;

public class CountLeaf {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        TreeNode[] nodes = new TreeNode[numNodes];
        TreeNode root = null;
        int[] indices = new int[numNodes];

        for (int i = 0; i < numNodes; i++) {
            int val = scanner.nextInt();
            nodes[i] = new TreeNode(i);
            indices[i] = val;
            if (val == -1) {
                root = nodes[i];
            } else {
                TreeNode par = nodes[val];
                if (par.left == null) {
                    par.left = nodes[i];
                } else if(par.right == null) {
                    par.right = nodes[i];
                }
            }
        }
        int indexToRemove = scanner.nextInt();

//        for (int i = 0 ; i < numNodes; i++) {
//            TreeNode node = nodes[i];
//            int leftChildIndex = getLeftChildIndex(i);
//            int rightChildIndex = getRightChildIndex(i);
//            if( leftChildIndex < numNodes ) { // left node
//                node.left = nodes[leftChildIndex];
//            }
//            if( rightChildIndex < numNodes ) { // right node
//                node.right = nodes[rightChildIndex];
//            }
//        }

//        // Remove
//        int indexLC = getLeftChildIndex(indexToRemove);
//        int indexRC = getRightChildIndex(indexToRemove);
//        int indexOfParent = getParentIndex(indexToRemove);

//        inorderTraversal(nodes[0]);
//        System.out.println();

        if(indexToRemove != 0) {
            remove(nodes[indexToRemove], nodes[indices[indexToRemove]]);
        } else {
//            root = removeRoot(root);
            root = null;
        }

//        System.out.println(root.val);

//        inorderTraversal(root);
//        System.out.println();


        System.out.println(countLeaf(root));


    }

    private static TreeNode removeRoot(TreeNode node) {
        if (node.left == null && node.right == null) { // case 1;
            return null;
        } else if (node.left != null || node.right != null) {
            if(node.left != null && node.right != null) {
                TreeNode tmp = node.left;
                node.val = tmp.val;
                node.left = removeRoot(tmp);
            }
            else if (node.left != null) {
                node = node.left;

            } else if (node.right != null) {
                node = node.right;

            }
            return node;
        }
        return null;
    }

    private static int countLeaf(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaf(node.left) + countLeaf(node.right);
    }

    private static void remove(TreeNode node, TreeNode parent) {
        if(parent != null) {
            if (parent.left == node) parent.left = null;
            else if(parent.right == node) parent.right = null;
        }
//
//
//        if (node.left == null && node.right == null) { // case 1;
//            if (parent.left == node) {
//                parent.left = null;
//            } else if (parent.right == node) {
//                parent.right = null;
//            }
//
//        } else if (node.left != null || node.right != null) {
//            if(node.left != null && node.right != null) {
//                TreeNode tmp = node.left;
//                node.val = tmp.val;
//                remove(tmp, node);
//            }
//            else if (parent.left == node) {
//                parent.left = node.left;
//            } else if (parent.right == node) {
//                parent.right = node.left;
//            }
//
//        }

    }

    public static int getLeftChildIndex(int index) {
        return index*2 + 1;
    }

    public static int getRightChildIndex(int index) {
        return index*2+2;
    }

    public static int getParentIndex(int index) {
        if (index%2 == 0) {
            return (index -2)/2;
        } else {
            return (index - 1)/2;
        }
    }

    public static boolean isLeftChild(int index) {
        return index%2 != 0;
    }

    public static void inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
