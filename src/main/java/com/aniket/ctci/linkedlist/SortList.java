package com.aniket.ctci.linkedlist;

public class SortList {

    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * <p>
     * Example :
     * <p>
     * Input : 1 -> 5 -> 4 -> 3
     * <p>
     * Returned list : 1 -> 3 -> 4 -> 5
     */

    public static void main(String[] args) {
        SortList obj = new SortList();

        int[] A = {1, 5, 4, 3};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i < A.length; i++) a.append(A[i]);
        a.print();
        a = obj.sortList(a);
        a.print();

    }

    // Sorting using merge sort
    public ListNode sortList(ListNode a) {

        if (a == null || a.next == null) return a;

        ListNode slow = a;
        ListNode fast = a.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode next = slow.next;
        mid.next = null;

        return merge(sortList(a), sortList(next));


    }

    private ListNode merge(ListNode a, ListNode b) {
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
