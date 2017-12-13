package com.aniket.ctci.linkedlist;

public class AddTwoNumbersAsLists {
    /**
     * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * <p>
     * 342 + 465 = 807
     * Make sure there are no trailing zeros in the output list
     * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
     */

    public static void main(String[] args) {
        AddTwoNumbersAsLists obj = new AddTwoNumbersAsLists();

        int[] A = {0};
        int[] B = {5, 6, 4, 0, 0};
//        int[] B = {1,0,1};
        ListNode a = new ListNode(A[0]);
        for (int i = 1; i < A.length; i++) a.append(A[i]);

        ListNode b = new ListNode(B[0]);
        for (int i = 1; i < B.length; i++) b.append(B[i]);

        a.print();
        b.print();

        a = obj.addTwoNumbers(a, b);
        a.print();


    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        int carry = 0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = a, p2 = b, p3 = newHead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
            //enter value after addition in carry
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }
        //if any carry left in the above loop then make another node for this
        if(carry == 1) {
            p3.next = new ListNode(1);
        }

        return newHead.next;
    }

    // Constant space
    public ListNode addTwoNumbers2(ListNode A, ListNode B) {
        ListNode head = A;

        if (A == null) return B;
        if (B == null) return A;

        int carry = 0;

        while (A != null && B != null) {

            int a = A.val;
            int b = B.val;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;

            A.val = sum;
            A = A.next;
            B = B.next;
        }

        while (A != null) {
            int a = A.val;
            int sum = a + carry;
            carry = sum / 10;
            sum = sum % 10;
            A.val = sum;
            A = A.next;
        }

        if (B != null) {
            A = head;
            while (A.next != null) {
                A = A.next;
            }
        }

        while (B != null) {
            int a = B.val;
            int sum = a + carry;
            carry = sum / 10;
            sum = sum % 10;
            A.next = new ListNode(sum);
            A = A.next;
            B = B.next;

        }

        if (carry != 0) {
            if (A == null) {
                A = head;
                while (A.next != null) {
                    A = A.next;
                }
            }
            A.next = new ListNode(carry);
        }

        ListNode prev = null;
        A = head;
        while (A.next != null) {
            if(A.val == 0) {
                ListNode curr = A;
                while (curr != null && curr.val == 0) {
                    curr = curr.next;
                }
                if (curr == null) {
                    if(prev == null) return prev;
                    prev.next = null; break;
                }
            }
            prev = A;
            A = A.next;

        }
        if (A.val == 0) prev.next = null;
        return head;
    }
}
