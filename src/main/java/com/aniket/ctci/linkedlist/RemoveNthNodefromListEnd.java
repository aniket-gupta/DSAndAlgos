package com.aniket.ctci.linkedlist;

public class RemoveNthNodefromListEnd {

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * <p>
     * For example,
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * <p>
     * Note:
     * If n is greater than the size of the list, remove the first node of the list.
     * Try doing it using constant additional space.
     */

    public ListNode removeNthFromEnd(ListNode a, int b) {

        ListNode prev = null;
        ListNode curr = a;
        ListNode f_ptr = a;
        int i = 1;
        for (; i <= b && f_ptr != null; i++) {
            f_ptr = f_ptr.next;

        }

        if (i <= b) return a.next;

        while (f_ptr != null) {
            f_ptr = f_ptr.next;
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) return curr.next;
        if (curr == null) return null;

        prev.next = curr.next;

        return a;

    }
}
