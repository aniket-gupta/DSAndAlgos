package com.aniket.ctci.linkedlist;

public class IntersectionOfLinkedLists {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * <p>
     * For example, the following two linked lists:
     * <p>
     * <p>
     * A:          a1 → a2
                            ↘
                             c1 → c2 → c3
                            ↗
     * B:     b1 → b2 → b3
     * <p>
     * begin to intersect at node c1.
     * <p>
     * Notes:
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     */

    public static void main(String[] args) {

        IntersectionOfLinkedLists intersectionOfLinkedLists = new IntersectionOfLinkedLists();

        ListNode b = new ListNode(5);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        ListNode a = new ListNode(1);
        a.next = b;

        ListNode mPoint = intersectionOfLinkedLists.getIntersectionNode(a, b);

        while (mPoint != null) {
            System.out.print(mPoint.val);
            mPoint = mPoint.next;
            if (mPoint != null) System.out.print("-->");

        }

    }

    public ListNode getIntersectionNode(ListNode a, ListNode b) {

        int m = length(a);
        int n = length(b);
        int diff = Math.abs(m - n);
        if (m < n) {
            ListNode temp = a;
            a = b;
            b = temp;
        }

        for (int i = 0; i < diff; i++) {
            a = a.next;
        }

        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }

        return null;
    }

    private int length(ListNode a) {
        int len = 0;

        while (a != null) {
            len++;
            a = a.next;
        }
        return len;
    }
}
