package com.aniket.ctci.linkedlist;

public class RemoveDuplicatesFromSortedListII {

    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * <p>
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     */

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();

//        ListNode a = new ListNode(1);
//        a.next = new ListNode(1);
//        a.next.next = new ListNode(1);
//        a.print();
//        a = obj.deleteDuplicates(a);
//        if (a != null) {
//            a.print();
//        } else System.out.println("\nNULL");
//        ListNode a = new ListNode(1);
//        a.next = new ListNode(1);
//        a.next.next = new ListNode(1);
//        a.next.next.next = new ListNode(2);
//        a.next.next.next.next = new ListNode(3);
//        a.print();
//        a = obj.deleteDuplicates(a);
//        if (a != null) {
//            a.print();
//        } else System.out.println("\nNULL");

        ListNode a = new ListNode(0);
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(3);
        a.next.next.next.next.next = new ListNode(3);
        a.next.next.next.next.next.next = new ListNode(3);
        a.next.next.next.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next.next.next.next = new ListNode(4);
        a.next.next.next.next.next.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        a.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        a.print();
        a = obj.deleteDuplicates(a);
        if (a != null) {
            a.print();
        } else System.out.println("\nNULL");


    }

    public ListNode deleteDuplicates(ListNode a) {
        ListNode head = a;
        ListNode prev = null;
        while (a != null && a.next != null) {
            ListNode currNode = a;
            ListNode nextNode = a.next;
            while (nextNode != null && currNode.val == nextNode.val) {
                nextNode = nextNode.next;
            }

            if (nextNode != null && a.next != nextNode) {
                a.val = nextNode.val;
                a.next = nextNode.next;
            } else if (nextNode == null) {
                if (prev == null) return null;
                prev.next = null;
                a = null;
            } else {
                prev = a;
                a = a.next;
            }
        }

        return head;

    }
}
