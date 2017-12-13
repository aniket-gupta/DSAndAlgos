package com.aniket.ctci.linkedlist;

public class RemoveDuplicatesFromSortedList {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * <p>
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     */


    public ListNode deleteDuplicates(ListNode a) {

        ListNode head = a;

        while (a != null && a.next != null) {
            ListNode next = a.next;
            if (a.val == next.val) {
                a.next = next.next;
            } else {
                a = a.next;
            }
        }

        return head;
    }
}
