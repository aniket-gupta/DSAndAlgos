package com.aniket.ctci.arrayandstring;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AnGupta on 2/14/17.
 */
public class LinkedList {

    static class Node {
        Node next = null;
        int data;

        Node(int data) {
            this.data = data;
        }

        void append(int data) {

            Node newNode = new Node(data);

            Node n = this;

            while (n.next != null) {
                n = n.next;
            }

            n.next = newNode;
        }
    }

    public static void main(String[] args) {


        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.append(6);

        print(head);

        System.out.println("=========== Testing dedup ===========");
        head = new Node(1);
        head.append(2);
        head.append(1);
        head.append(2);
        head.append(3);

        print(head);

        deDup(head);

        print(head);

        head = new Node(1);
        head.append(2);
        head.append(1);
        head.append(2);
        head.append(3);
        head.append(3);

        print(head);

        deDup(head);

        print(head);

        head = new Node(1);
        print(head);

        deDup(head);

        print(head);

        System.out.println("=========== Testing dedup without extra space ===========");
        head = new Node(1);
        head.append(2);
        head.append(1);
        head.append(2);
        head.append(3);

        print(head);

        dedupNoExtraMem(head);

        print(head);

        head = new Node(1);
        head.append(2);
        head.append(1);
        head.append(2);
        head.append(3);
        head.append(3);

        print(head);

        dedupNoExtraMem(head);

        print(head);

        head = new Node(1);
        print(head);

        dedupNoExtraMem(head);

        print(head);

        System.out.println("========== Testing Kth to last node ==========");

        head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.append(6);
        head.append(7);
        head.append(8);
        head.append(9);

        print(head);

        System.out.println(kthToLast(head, 3).data);
        System.out.println(kthToLast(head, 1).data);
        System.out.println(kthToLast(head, 4).data);
        System.out.println(kthToLast(head, 8).data);
        System.out.println(kthToLast(head, 9).data);

        head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.append(6);
        head.append(7);
        head.append(8);
        head.append(9);
        print(head);
        head = reverse(head);
        print(head);


    }

    public static void print(Node head) {

        Node n = head;

        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }

        System.out.print("NULL");
        System.out.println();
    }

    /**
     * Problem 2.1
     * @param head
     */
    public static void deDup(Node head) {
        if (head == null) return;

        Node n = head;
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.data);

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if(set.contains(curr.data)) {

                System.out.println("removing " + curr.data);
                // delete this node
                prev.next = curr.next;
                curr = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }

    }

    public static void dedupNoExtraMem(Node head) {

        if (head == null) return;

        Node prev = head;

        Node curr = head.next;

        while (curr != null) {
            if(dupFound(curr, head)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

    }

    private static boolean dupFound(Node curr, Node head) {
        Node runner = head;
        while (runner != curr) {
            if (runner.data == curr.data) return true;
            runner = runner.next;
        }

        return false;
    }

    private static Node kthToLast(Node head, int k) {
        int count = 0;
        Node slowPtr = head;
        Node fastPtr = head;

        while (count != k && fastPtr != null) {
            fastPtr = fastPtr.next;
            count++;
        }

        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr;

    }

    private static Node reverse(Node head) {
        return reverse(null, head);
    }

    private static Node reverse(Node prev, Node curr) {
        if(curr.next == null) {
            curr.next = prev;
            return curr;
        }

        Node tmp = prev;
        prev = curr;
        curr = curr.next;
        Node n = reverse(prev, curr);
        prev.next = tmp;
        return n;
    }
}
