package com.aniket.ctci.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by AnGupta on 5/11/17.
 */
public class DiagonalSum {

    public static void diagonalSum(TreeNode root, int lineNo, Map<Integer, Integer> map) {
        if(root != null) {
            diagonalSum(root.left, lineNo + 1, map);

            int oldSum = (map.get(lineNo) == null) ? 0 : map.get(lineNo);

            map.put(lineNo, oldSum + root.data);

            diagonalSum(root.right, lineNo, map);
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

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        diagonalSum(root, 0, map);

        for (Integer keyset :
             map.keySet()) {

            System.out.println(keyset + " : " + map.get(keyset));
        }
    }
}
