package com.aniket.ctci.linkedlist;

public class ReorderList {

    /**
     * Given a singly linked list
     * <p>
     * L: L0 → L1 → … → Ln-1 → Ln,
     * reorder it to:
     * <p>
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     * You must do this in-place without altering the nodes’ values.
     * <p>
     * For example,
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};

        ListNode a = new ListNode(A[0]);
        for(int i = 1; i < A.length; i++) {
            a.append(A[i]);
        }
        a.print();

        ReorderList obj = new ReorderList();
        a = obj.reorderList(a);
        a.print();
    }

    public ListNode reorderList(ListNode a) {

        ListNode slow_ptr = a;
        ListNode fast_ptr = a;
        ListNode prev = null;

        if(a == null  || a.next == null) return a;

        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        if(fast_ptr != null) {
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        prev.next = null;

        ListNode secondHalf = slow_ptr;
        secondHalf = reverse(secondHalf);

        ListNode curr = a;
        while (curr != null && secondHalf != null) {
            ListNode next = curr.next;
            ListNode nextInSec = secondHalf.next;
            curr.next = secondHalf;
            secondHalf.next = next;
            curr = next;
            secondHalf = nextInSec;
        }

        return a;
    }

    private ListNode reverse(ListNode a) {
        ListNode curr = a;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
