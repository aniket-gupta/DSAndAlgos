package com.aniket.ctci.linkedlist;

public class RotateList {

    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.
     * <p>
     * For example:
     * <p>
     * Given 1->2->3->4->5->NULL and k = 2,
     * return 4->5->1->2->3->NULL.
     */

    public static void main(String[] args) {
        int[] A = {23 , 57 , 65 , 90 , 56 , 69 , 77 , 52 , 71 , 74 , 15 , 25 , 41 , 17 , 76 , 95 , 58 , 38 , 29 , 68 , 4 , 89 , 55 , 99 , 13 , 92 , 98 , 62 , 36 , 59 , 54 , 48 , 53 , 12 , 11 , 6 , 2 , 35 , 46 , 39 , 20 , 27 , 44 , 78 , 82 , 67 , 91 , 64 , 97 , 43 , 84 , 83 , 70 , 73 , 79 , 88 , 16 , 1 , 96 , 66 , 80 , 72 , 10 , 19 , 100 , 33 , 75 , 3 , 81 , 24 , 22 , 87 , 63 , 9 , 7 , 40 , 8 , 34 , 101 , 60 , 28};

        ListNode a = new ListNode(23);
        for(int i = 1; i < A.length; i++) {
            a.append(A[i]);
        }
        a.print();

        RotateList obj = new RotateList();
        a = obj.rotateRight(a, 20);
        a.print();
    }

    public ListNode rotateRight(ListNode a, int b) {

        // find nth element from last
        ListNode prev = null;
        ListNode curr = a;
        ListNode f_ptr = a;
        ListNode head = a;
        int i = 1;
        int len = length(a);
        int r = b % len;
        for (; i <= r && f_ptr != null; i++) {
            f_ptr = f_ptr.next;

        }


        while (f_ptr != null) {
            f_ptr = f_ptr.next;
            prev = curr;
            curr = curr.next;
        }

        if(prev == null || curr == null) return a;

        prev.next = null;
        head = curr;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = a;




        return head;
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
