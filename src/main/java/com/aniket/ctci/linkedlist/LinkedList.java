package com.aniket.ctci.linkedlist;

import com.aniket.ctci.queue.Queue;
import com.aniket.ctci.stack.Stack;

/**
 * Created by AnGupta on 5/28/17.
 */
public class LinkedList<E> implements Stack<E>, Queue<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public void add(E e) {
        pushBack(e);
    }

    /**
     * Remove first element
     * @return
     */
    public E remove() {
        return popFront();
    }

    public boolean remove(E e) {

        if(head != null) {
            if(head.data.equals(e)) {
                if(head == tail) {
                    tail = null;
                }
                head = head.next;
                size--;
                return true;
            }
            Node<E> prev = head;
            Node<E> curr = head.next;

            while (curr != null) {
                if (e.equals(curr.data)) {
                    if(e.equals(tail.data)) {
                        tail = prev;
                    }
                    prev.next = curr.next;
                    curr = null;
                    size--;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return false;

    }

    public boolean contains(E e) {
        Node<E> tmp = head;

        while (tmp != null) {
            if(e.equals(tmp.data)) {
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    public void push(E e) {
        pushFront(e);
    }

    public E pop() {
        return popFront();
    }

    public void enqueue(E e) {
        pushBack(e);
    }

    public E dequeue() {
        return popFront();
    }

    public E peek() {
        return head != null ? head.data : null;
    }

    public E getFirst() {
        return peek();
    }

    public E getLast() {
        return tail != null ? tail.data : null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<E> tmp = head;
        while (tmp != null) {
            stringBuilder.append(tmp.data);
            stringBuilder.append(' ');
            tmp = tmp.next;
        }
        String listAsStr = stringBuilder.toString();
        listAsStr.trim();
        return listAsStr.trim() + "]";
    }

    private void pushBack(E e) {
        Node<E> newNode = new Node<E>(e);
        tail = newNode;
        if(head == null) {
            head = newNode;
        } else {
            Node<E> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        size++;

    }

    private void pushFront(E e) {
        Node<E> newNode = new Node<E>(e);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    private E popBack() {
        E data = null;
        if (head != null) {
            data = tail.data;
            size--;
            if(head == tail) {
                head = null;
                tail = null;
                size = 0;
            } else {
                Node<E> tmp = head;
                while (tmp.next != tail) {
                    tmp = tmp.next;
                }
                tail = tmp;
                tail.next = null;
            }
        }
        return data;
    }

    private E popFront() {
        if(head != null) {
            E data = head.data;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
                size = 0;
            }
            return data;
        }
        return null;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
