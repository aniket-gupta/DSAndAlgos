package com.aniket.ctci.linkedlist;

public class ReverseLinkedList {

    /**
     * Reverse a linked list. Do it in-place and in one-pass.
     * <p>
     * For example:
     * Given 1->2->3->4->5->NULL,
     * <p>
     * return 5->4->3->2->1->NULL.
     * <p>
     * https://www.youtube.com/watch?v=sYcOK51hl-A
     * https://www.youtube.com/watch?v=KYH83T4q6Vs
     */

    public static void main(String[] args) {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);
//        a.print();
//        a = reverseLinkedList.reverseList(a);
//        a.print();
//        reverseLinkedList.reversePrint(a);

//        a.print();
        a = reverseLinkedList.reverseUsingRecursion(a);
        a.print();

    }


    public ListNode reverseList(ListNode a) {

        ListNode current = a;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode head = prev;
        return head;
    }

    public void reversePrint(ListNode a) {
        if (a.next == null) return;
        reversePrint(a.next);
        System.out.println(a.val);
    }

    public ListNode reverseUsingRecursion(ListNode a) {

        ListNode newHead = null;
        if (a.next == null) {
            return a;
        }

        newHead = reverseUsingRecursion(a.next);
        ListNode next = a.next;
        next.next = a;
        a.next = null;
        return newHead;
    }


}
