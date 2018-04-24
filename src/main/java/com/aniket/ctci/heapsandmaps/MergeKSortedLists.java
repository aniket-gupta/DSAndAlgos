package com.aniket.ctci.heapsandmaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * Merge k sorted linked lists and return it as one sorted list.
     * <p>
     * Example :
     * <p>
     * 1 -> 10 -> 20
     * 4 -> 11 -> 13
     * 3 -> 8 -> 9
     * will result in
     * <p>
     * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        ListNode head = null;
        ListNode tail = null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val > o2.val ? 1 : (o1.val == o2.val ? 0 : -1));

        for (int i = 0; i < a.size(); i++) {
            queue.offer(a.get(i));
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            ListNode newNode = new ListNode(node.val);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return head;


    }
}
