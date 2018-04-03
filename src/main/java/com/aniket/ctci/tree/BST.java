package com.aniket.ctci.tree;

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
        }
        else if (root.val > val){
            root.left =  remove(root.left, val);
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





    // --------------- MAIN ---------------
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(8);
        bst.insert(6);
        bst.insert(2);
        bst.insert(5);
        bst.insert(4);
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.inorderTraversal();
        System.out.println("\n" + bst.contains(12));
        bst.remove(10);
        bst.inorderTraversal();

    }


}
