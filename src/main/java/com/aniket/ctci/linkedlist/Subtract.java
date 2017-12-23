package com.aniket.ctci.linkedlist;

public class Subtract {

    /**
     * Given a singly linked list, modify the value of first half nodes such that :
     * <p>
     * 1st node’s new value = the last node’s value - first node’s current value
     * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
     * and so on …
     * <p>
     * NOTE :
     * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
     * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
     * Example :
     * <p>
     * Given linked list 1 -> 2 -> 3 -> 4 -> 5,
     * <p>
     * You should return 4 -> 2 -> 3 -> 4 -> 5
     * as
     * <p>
     * for first node, 5 - 1 = 4
     * for second node, 4 - 2 = 2
     * Try to solve the problem using constant extra space.
     */

    public ListNode subtract(ListNode A) {

        ListNode head = A;
        if (A.next != null) {
            ListNode slow_ptr = head;
            ListNode fast_ptr = head;
            ListNode firstHalfTail = head;

            while (fast_ptr != null && fast_ptr.next != null) {
                firstHalfTail = slow_ptr;
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next.next;
            }

            if (fast_ptr != null) {
                firstHalfTail = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            firstHalfTail.next = null;
            ListNode secondListHead = slow_ptr;

            secondListHead = reverse(secondListHead);

            ListNode curr_first = head;
            ListNode curr_sec = secondListHead;

            while (curr_sec != null) {
                int val = curr_sec.val - curr_first.val;
                curr_first.val = val;
                curr_sec = curr_sec.next;
                curr_first = curr_first.next;
            }
            secondListHead = reverse(secondListHead);
            firstHalfTail.next = secondListHead;

        }

        return head;

    }

    private ListNode reverse(ListNode A) {
        ListNode prev = null;
        while (A != null) {
            ListNode next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }
        return prev;
    }
}
