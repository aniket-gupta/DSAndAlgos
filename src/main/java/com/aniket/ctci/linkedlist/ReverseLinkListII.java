package com.aniket.ctci.linkedlist;

public class ReverseLinkListII {

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * <p>
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * <p>
     * return 1->4->3->2->5->NULL.
     * <p>
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list. Note 2:
     * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i < A.length; i++) {
            a.append(A[i]);
        }

        a.print();
        ReverseLinkListII obj = new ReverseLinkListII();
//        a = obj.reverseBetween(a, 2, 4);
        a = obj.reverseBetween(a, 1, 1);
        a.print();
    }

    public ListNode reverseBetween(ListNode a, int m, int n) {

        ListNode startNode = a;
        ListNode endNode = a;
        ListNode head = a;
        ListNode beforeNode = null;
        ListNode afterNode = null;

        for (int i = 1; i < m; i++) {
            beforeNode = startNode;
            startNode = startNode.next;
        }


        for (int i = 1; i < n; i++) {
            endNode = endNode.next;
        }
        afterNode = endNode.next;
        endNode.next = null;
        if (beforeNode != null) beforeNode.next = null;

        ListNode curr = startNode;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (beforeNode != null) {
            beforeNode.next = prev;

        } else head = prev;

        startNode.next = afterNode;

        return head;

    }
}
