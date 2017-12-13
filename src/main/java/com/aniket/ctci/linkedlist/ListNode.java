package com.aniket.ctci.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void append(int val) {
        ListNode node = new ListNode(val);
        ListNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public void print() {
        ListNode current = this;
        System.out.println();
        while (current != null) {
            System.out.print(current.val + "-->");
            current = current.next;
        }
        System.out.print("NULL");
    }
}
