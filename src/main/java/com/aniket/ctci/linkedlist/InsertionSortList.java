package com.aniket.ctci.linkedlist;

public class InsertionSortList {

    /**
     * Sort a linked list using insertion sort.
     * <p>
     * <p>
     * Example :
     * <p>
     * Input : 1 -> 3 -> 2
     * <p>
     * Return 1 -> 2 -> 3
     */

    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        int[] A = {1,3,2, 4, 1, 2, 5, 8, 7, 6};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i <A.length; i++) a.append(A[i]);
        a.print();
        a = obj.insertionSortList(a);
        a.print();
     }

    public ListNode insertionSortList(ListNode a) {

        ListNode head = a;
        ListNode start = a;
        ListNode curr = a.next;
        ListNode prev = a;
        while (curr != null) {

            int val = curr.val;
            ListNode next = curr.next;
            ListNode runner = head;
            ListNode prev_runner = null;
            while (runner != curr && runner.val < val) {
                prev_runner = runner;
                runner = runner.next;
            }

            if (runner == curr) {
                prev = curr;
                curr  = curr.next;
            }
            else {
                if(prev_runner == null) {
                    head = curr;
                } else {
                    prev_runner.next = curr;
                }

                if(runner.next == curr) {
                    runner.next = next;
                }
                prev.next = next;
                curr.next = runner;
                curr = next;
            }
        }

        return head;
    }
}
