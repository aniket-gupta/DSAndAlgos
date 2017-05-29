package com.aniket.ctci.queue;

/**
 * Created by AnGupta on 5/28/17.
 */
public interface Queue<E> {

    public void enqueue(E e);

    public E dequeue();

    public E peek();

    public boolean isEmpty();
}
