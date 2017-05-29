package com.aniket.ctci.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by AnGupta on 5/28/17.
 */
public class DisjointSet<E> {

    HashMap<E, Node<E>> map = new HashMap<E, Node<E>>();

    private static class Node<E> {
        E parent;
        int rank;

        Node(E parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public void makeSet(E e) {
        map.put(e, new Node<E>(e, 0));
    }

    public void union(E a, E b) {
        E set_a = findSet(a);
        E set_b = findSet(b);
        if (set_a == set_b)
            return;
        Node<E> aNode = map.get(set_a);
        Node<E> bNode = map.get(set_b);
        if(aNode.rank > bNode.rank) {
            bNode.parent = set_a;
        } else {
            aNode.parent = set_b;
            if (aNode.rank == bNode.rank) {
                bNode.rank++;
            }
        }

    }

    public E findSet(E e) {
        Node<E> node = map.get(e);
        if(node == null) {
            return null;
        }

        if(e != node.parent) {
            node.parent = findSet(node.parent);
        }
        return node.parent;
    }

    public void removeSet(E e) {
        E set = findSet(e);
        if(set == null)
            return;
        for (Iterator<E> it = map.keySet().iterator(); it.hasNext();) {
            E next = it.next();
            //remove the set representative last, otherwise findSet will fail
            if(next != set && findSet(next) == set) {
                it.remove();
            }
        }
        map.remove(set);
    }
}
