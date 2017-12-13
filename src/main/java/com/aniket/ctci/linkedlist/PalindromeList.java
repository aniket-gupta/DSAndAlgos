package com.aniket.ctci.linkedlist;

public class PalindromeList {

    /**
     * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
     * <p>
     * Notes:
     * <p>
     * Expected solution is linear in time and constant in space.
     * For example,
     * <p>
     * List 1-->2-->1 is a palindrome.
     * List 1-->2-->3 is not a palindrome.
     */

    public static void main(String[] args) {
        PalindromeList palindromeList = new PalindromeList();
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(1);

//        ListNode a = new ListNode(1);
//        a.next = new ListNode(2);
//        a.next.next = new ListNode(2);
//        a.next.next.next = new ListNode(1);

//        ListNode a = new ListNode(1);
//        a.next = new ListNode(2);
//        a.next.next = new ListNode(3);
//        a.next.next.next = new ListNode(1);

//        ListNode a = new ListNode(1);
//        a.next = new ListNode(2);
//        a.next.next = new ListNode(3);
//        a.next.next.next = new ListNode(3);
//        a.next.next.next.next = new ListNode(1);

//        ListNode a = new ListNode(1);
//        a.next = new ListNode(1);
//        a.next.next = new ListNode(2);
//        a.next.next.next = new ListNode(1);

        System.out.println(palindromeList.lPalin(a));

    }

    public int lPalin(ListNode A) {
        int res = 1;

        ListNode head = A;

        if (head != null && head.next != null) {


            ListNode slow_ptr = head;
            ListNode prev_slow_ptr = head;
            ListNode fast_ptr = head;
            ListNode midNode = null;

            //----------- divide the list into half -----------
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                prev_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            if (fast_ptr != null) { // slow_ptr is at mid point of list otherwise slow_ptr is at starting of second half;
                midNode = slow_ptr;
                slow_ptr = slow_ptr;
            }

            ListNode secondHalf = slow_ptr;
            prev_slow_ptr.next = null;
            //-------------------------------------------------

            //reverse second half
            secondHalf = reverse(secondHalf);
            // compare two list
            res = compareList(head, secondHalf);
            // restore original second half
            secondHalf = reverse(secondHalf);

            // restore original list
            if (midNode != null) {
                prev_slow_ptr.next = midNode;
                midNode.next = secondHalf;
            } else {
                prev_slow_ptr.next = secondHalf;
            }

        }

        return res;

    }

    private int compareList(ListNode first, ListNode second) {
        while (first != null && second != null) {
            if (first.val != second.val) return 0;
            first = first.next;
            second = second.next;
        }
        return 1;
    }

    private ListNode reverse(ListNode a) {

        ListNode current = a;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


}
