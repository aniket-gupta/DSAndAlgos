package com.aniket.ctci.linkedlist;

public class PartitionList {

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     */

    public static void main(String[] args) {
        PartitionList obj = new PartitionList();

        int[] A = {1, 4, 3, 2, 5, 2};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i < A.length; i++) a.append(A[i]);
        a.print();
        a = obj.partition(a, 3);
        a.print();


    }

    public ListNode partition(ListNode a, int b) {

        ListNode prev = null;
        ListNode start = a;
        ListNode head = a;

        while (start != null) {

            // find first node >= b
            ListNode curr = start;
            while (curr != null && curr.val < b) {
                prev = curr;
                curr = curr.next;
            }

            if (curr == null) break;

            ListNode startPoint = curr;
            ListNode endPoint = startPoint;

            while (curr != null && curr.val >= b) {
                endPoint = curr;
                curr = curr.next;
            }
            if (curr == null) break;

            ListNode next = curr.next;
            endPoint.next = next;
            curr.next = startPoint;
            if (prev == null) head = curr;
            else prev.next = curr;


            prev = curr;
            start = curr.next;
        }

        return head;
    }
}
