package com.aniket.ctci.stack;

/**
 * Created by AnGupta on 5/28/17.
 */
public interface Stack<E> {

    public void push(E e);

    public E pop();

    public E peek();

    public boolean isEmpty();

}
