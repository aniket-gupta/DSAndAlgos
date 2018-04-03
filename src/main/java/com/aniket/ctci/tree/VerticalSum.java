package com.aniket.ctci.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AnGupta on 5/11/17.
 */
public class VerticalSum {


    public static void verticalSum(TreeNode root, int hd, Map<Integer, Integer> map) {
        if(root != null) {

            verticalSum(root.left, hd - 1, map);

            int prevSum = (map.get(hd) == null) ? 0 : map.get(hd);
            map.put(hd, prevSum + root.val);

            verticalSum(root.right, hd + 1, map);

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

        verticalSum(root, 0, map);

        for (Map.Entry<Integer, Integer> entrySet: map.entrySet()) {
            System.out.println("for horizontal distance " + entrySet.getKey() + " is: " + entrySet.getValue());
        }


    }

}
