package com.aniket.ctci.linkedlist;

public class KReverseLinkedList {

    /**
     * Given a singly linked list and an integer K, reverses the nodes of the
     * <p>
     * list K at a time and returns modified linked list.
     * <p>
     * NOTE : The length of the list is divisible by K
     * Example :
     * <p>
     * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
     * <p>
     * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
     * <p>
     * Try to solve the problem using constant extra space.
     */

    public static void main(String[] args) {
        KReverseLinkedList obj = new KReverseLinkedList();
        int[] A = {1, 2, 3, 4, 5, 6};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i < A.length; i++) a.append(A[i]);
        a.print();
        a = obj.reverseList(a, 3);
        a.print();
    }

    public ListNode reverseList(ListNode A, int B) {

        if (B < 2) return A;

        if (len(A) % B != 0) return A;

        ListNode curr = A;

        ListNode beforeNode = null;
        ListNode head = null;

        while (curr != null) {

            ListNode startNode = curr;
            ListNode endNode = curr;

            for (int i = 1; i < B; i++) {
                endNode = endNode.next;
            }

            ListNode afterNode = endNode.next;
            endNode.next = null;
            ListNode tmp = startNode;
            tmp = reverse(tmp);
            if (head == null) {
                head = tmp;
            }

            if (beforeNode != null) beforeNode.next = tmp;
            startNode.next = afterNode;
            beforeNode = startNode;
            curr = afterNode;
        }

        return head;
    }

    private ListNode reverse(ListNode a) {
        ListNode curr = a;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private int len(ListNode a) {
        int count = 0;
        while (a != null) {
            count++;
            a = a.next;
        }

        return count;
    }


}
