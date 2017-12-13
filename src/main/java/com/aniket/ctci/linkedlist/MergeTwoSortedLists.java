package com.aniket.ctci.linkedlist;

public class MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
     * <p>
     * For example, given following linked lists :
     * <p>
     * 5 -> 8 -> 20
     * 4 -> 11 -> 15
     * The merged list should be :
     * <p>
     * 4 -> 5 -> 8 -> 11 -> 15 -> 20
     */

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        ListNode a = new ListNode(5);
        a.next = new ListNode(8);
        a.next.next = new ListNode(20);
        ListNode b = new ListNode(4);
        b.next = new ListNode(11);
        b.next.next = new ListNode(15);
        b.next.next.next = new ListNode(16);

        a = obj.mergeTwoLists(a, b);
        a.print();
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head = a;
        ListNode prev = null;
        if (a.val <= b.val) {
            head = a;

            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        prev = head;

        while (a != null && b != null) {

            if (a.val <= b.val) {

                prev.next = a;
                prev = a;
                a = a.next;

            } else {
                prev.next = b;
                prev = b;
                b = b.next;

            }

        }

        while (a != null) {
            prev.next = a;
            prev = a;
            a = a.next;
        }
        while (b != null) {
            prev.next = b;
            prev = b;
            b = b.next;
        }

        return head;
    }
}
