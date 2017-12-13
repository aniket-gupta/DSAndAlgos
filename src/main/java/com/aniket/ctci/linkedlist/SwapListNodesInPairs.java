package com.aniket.ctci.linkedlist;

public class SwapListNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * <p>
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     */

    public static void main(String[] args) {

        SwapListNodesInPairs obj = new SwapListNodesInPairs();
        int[] A = {1, 2};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i < A.length; i++) a.append(A[i]);
        a.print();
        a = obj.swapPairs(a);
        a.print();

    }

    public ListNode swapPairs(ListNode A) {

        if (A == null || A.next == null) return A;

        ListNode head = null;
        ListNode curr = A;
        ListNode prev = null;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            ListNode nextOfNext = next.next;
            if (head == null) head = next;
            if (prev != null) prev.next = next;
            next.next = curr;
            curr.next = nextOfNext;
            prev = curr;
            curr = nextOfNext;

        }
        return head;

    }
}
