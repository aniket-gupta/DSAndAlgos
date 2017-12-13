package com.aniket.ctci.linkedlist;

public class ListCycle {

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * <p>
     * Try solving it using constant additional space.
     * <p>
     * Example :
     * <p>
     * Input :
     * <p>
             * ______
             * |     |
             * \/    |
     * 1 -> 2 -> 3 -> 4
     * <p>
     * Return the node corresponding to node 3.
     */

    public ListNode detectCycle(ListNode a) {

        ListNode slow = a;
        ListNode fast = a;

       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
           if (slow == fast) break;
       }

       if (fast == null || fast.next == null) return null;

       slow = a;

       while (slow != fast) {
           slow = slow.next;
           fast = fast.next;
       }

        return fast;
    }
}
