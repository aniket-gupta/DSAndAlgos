package com.aniket.ctci.tree;


import java.util.*;

public class BST {

    class NODE {
        int val;
        NODE left;
        NODE right;

        NODE(int val) {
            this.val = val;
        }
    }


    private NODE root;

    public void insert(int val) {
        root = insert(root, val);
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private NODE remove(NODE root, int val) {
        if (root == null) return root;
        else if (root.val < val) {
            root.right = remove(root.right, val);
        } else if (root.val > val) {
            root.left = remove(root.left, val);
        } else { // found the node
            // case 1: node does not have any child;
            if (root.left == null && root.right == null) {
                root = null;
            }
            // case 2 : only one child
            else if (root.left == null) {
                root = root.right;

            } else if (root.right == null) {
                root = root.left;
            }
            // case 3: 2 children
            else {
                NODE tmp = findMin(root.right);
                root.val = tmp.val;
                root.right = remove(root.right, tmp.val);
            }
        }

        return root;
    }

    private NODE findMin(NODE root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    private boolean contains(NODE root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        else if (root.val < val) return contains(root.right, val);
        else return contains(root.left, val);
    }

    private NODE insert(NODE root, int val) {
        NODE newNode = new NODE(val);
        if (root == null) {
            root = newNode;
        } else {
            if (root.val < val) {
                root.right = insert(root.right, val);
            } else {
                root.left = insert(root.left, val);
            }

        }
        return root;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(NODE root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);

        }
    }

    public void inorderTraversalNonRecursive() {

        NODE curr = root;
//        ArrayList<Integer> res = new ArrayList<>();
        Stack<NODE> stack = new Stack<>();

        while (true) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else if (!stack.isEmpty()) {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else break;

        }

    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(NODE root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);

        }
    }

    public void preorderNonRecursive() {
        NODE curr = root;
        Stack<NODE> stack = new Stack<>();
        while (true) {

            if (curr != null) {
                System.out.print(curr.val + " ");
                if (curr.right != null) stack.push(curr.right);
                curr = curr.left;
            } else if (!stack.isEmpty()) {
                curr = stack.pop();
            } else break;

        }
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(NODE root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");


        }
    }

    public void postorderNonRecursive() {

        NODE curr = root;
        Stack<NODE> stack1 = new Stack<>();
        Stack<NODE> stack2 = new Stack<>();
        stack1.push(curr);
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
            stack2.push(curr);
        }

        while (!stack2.isEmpty()) {
            curr = stack2.pop();
            System.out.print(curr.val + " ");
        }

    }

    public void verticalTraversal() {

        TreeMap<Integer, ArrayList<ValDepthPair>> map = new TreeMap<>();
        verticalTraversal(root, 0, 0, map);
        Set<Integer> hds = map.keySet();
        for (int hd : hds) {
            ArrayList<ValDepthPair> valDepthPairs = map.get(hd);
            Collections.sort(valDepthPairs);
            for (ValDepthPair pair : valDepthPairs) {
                System.out.print(pair.val + " ");
            }
        }

    }

    private void verticalTraversal(NODE root, int hd, int depth, TreeMap<Integer, ArrayList<ValDepthPair>> map) {

        if (root != null) {
            verticalTraversal(root.left, hd - 1, depth + 1, map);
            if (map.containsKey(hd)) {
                map.get(hd).add(new ValDepthPair(root.val, depth));
            } else {
                map.put(hd, new ArrayList<>(Arrays.asList(new ValDepthPair(root.val, depth))));
            }
            verticalTraversal(root.right, hd + 1, depth + 1, map);
        }

    }

    class ValDepthPair implements Comparable<ValDepthPair> {
        int val;
        int depth;

        ValDepthPair(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }


        @Override
        public int compareTo(ValDepthPair o) {
            return new Integer(this.depth).compareTo(new Integer(o.depth));
        }
    }

    public void verticalOrderTraversalNonRecursive() {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return;
        NODE curr = root;
        Queue<NODE> queue = new LinkedList<>(); // queue for level order traversal
        Queue<Integer> hdQueue = new LinkedList<>(); // queue to maintain horizontal distance
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        queue.offer(curr);
        hdQueue.offer(0);

        int minHd = 0;
        int maxHd = 0;

        while (!queue.isEmpty()) {

            curr = queue.poll();
            Integer currHorzontalDistance = hdQueue.poll();
            if (!map.containsKey(currHorzontalDistance)) {
                map.put(currHorzontalDistance, new ArrayList<Integer>());
            }
            map.get(currHorzontalDistance).add(curr.val);
            minHd = Math.min(minHd, currHorzontalDistance);
            maxHd = Math.max(maxHd, currHorzontalDistance);
            if (curr.left != null) {
                queue.offer(curr.left);
                hdQueue.offer(currHorzontalDistance - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                hdQueue.offer(currHorzontalDistance + 1);
            }
        }

        for (int i = minHd; i <= maxHd; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }

        System.out.println(res);

    }

    public void postOrderTraversalUsingOneStack() {

        NODE curr = root;
        Stack<NODE> stack = new Stack<>();
        do {
            while (curr != null) {
                if (curr.right != null) stack.push(curr.right);
                stack.push(curr);

                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.right != null && !stack.isEmpty() && curr.right == stack.peek()) {
                NODE rightChild = stack.pop();
                stack.push(curr);
                curr = rightChild;
            } else {
                System.out.print(curr.val + " ");
                curr = null;
            }


        } while (!stack.isEmpty());

    }


    // --------------- MAIN ---------------
    public static void main(String[] args) {
        BST bst = new BST();

//        bst.insert(8);
//        bst.insert(6);
//        bst.insert(2);
//        bst.insert(5);
//        bst.insert(4);
//        bst.insert(10);
//        bst.insert(9);
//        bst.insert(11);
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);
        bst.insert(13);
        bst.insert(14);
        bst.inorderTraversal();
//        System.out.println("\n" + bst.contains(12));
//        bst.remove(10);
//        bst.inorderTraversal();
        System.out.println();
        bst.inorderTraversalNonRecursive();
        System.out.println();
        bst.preorderTraversal();
        System.out.println();
        bst.preorderNonRecursive();
        System.out.println();
        bst.postorderTraversal();
        System.out.println();
        bst.postorderNonRecursive();

        System.out.println();
        bst.postOrderTraversalUsingOneStack();
//        bst.verticalTraversal();
//        System.out.println();
//        bst.verticalOrderTraversalNonRecursive();

    }


}
