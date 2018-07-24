package com.aniket.ctci.tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TopViewOfTree {

    /**
     * Print The Top View of a Binary Tree
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        printTopView(root);


    }

    public static void printTopView(TreeNode root) {
        if(root != null) {
            Map<Integer, Integer> map = new TreeMap<>();
            topView(root, 0, map);
            Set<Integer> integers = map.keySet();
            for (int integer : integers) {
                System.out.println(map.get(integer));
            }

        }
    }

    private static void topView(TreeNode root, int hd, Map<Integer,Integer> map) {
        if(root != null) {
            if(!map.containsKey(hd)) {
                map.put(hd, root.val);
            }
            topView(root.left, hd - 1, map);
            topView(root.right, hd + 1, map);
        }
    }
}
