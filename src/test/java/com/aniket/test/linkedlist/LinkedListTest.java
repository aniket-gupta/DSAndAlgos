package com.aniket.test.linkedlist;

import com.aniket.ctci.linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AnGupta on 5/28/17.
 */
public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        String expected = "[a b c d e f]";
        String actual = list.toString();
        System.out.println("Expected    :" + expected);
        System.out.println("Actual      :" + actual);
        assertEquals(expected, actual);
        assertEquals(6, list.size());
    }

    @Test
    public void testPush() {
        LinkedList<String> list = new LinkedList<String>();
        list.push("a");
        list.push("b");
        list.push("c");
        list.push("d");
        list.push("e");
        list.push("f");
        String expected = "[f e d c b a]";
        String actual = list.toString();
        System.out.println("Expected    :" + expected);
        System.out.println("Actual      :" + actual);
        assertEquals(expected, actual);
        assertEquals(6, list.size());
    }

    @Test
    public void testPeek() {
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(null, list.peek());
        list.push("a");
        assertEquals("a", list.peek());
        list.push("b");
        assertEquals("b", list.peek());
        list.push("c");
        assertEquals("c", list.peek());
        list.push("d");
        assertEquals("d", list.peek());

    }

    @Test
    public void testPop() {
        LinkedList<String> list = new LinkedList<String>();
        list.push("a");
        list.push("b");
        list.push("c");
        list.push("d");
        list.push("e");
        list.push("f");
        list.push("g");
        list.push("h");
        list.push("i");
        assertEquals("i", list.pop());
        assertEquals("[h g f e d c b a]", list.toString());
        assertEquals(8, list.size());
        assertEquals("h", list.pop());
        assertEquals("[g f e d c b a]", list.toString());
        assertEquals(7, list.size());
        assertEquals("g", list.pop());
        assertEquals("[f e d c b a]", list.toString());
        assertEquals(6, list.size());
        assertEquals("f", list.pop());
        assertEquals("[e d c b a]", list.toString());
        assertEquals(5, list.size());
        assertEquals("e", list.pop());
        assertEquals("[d c b a]", list.toString());
        assertEquals(4, list.size());
        assertEquals("d", list.pop());
        assertEquals("[c b a]", list.toString());
        assertEquals(3, list.size());
        assertEquals("c", list.pop());
        assertEquals("[b a]", list.toString());
        assertEquals(2, list.size());
        assertEquals("b", list.pop());
        assertEquals("[a]", list.toString());
        assertEquals(1, list.size());
        assertEquals("a", list.pop());
        assertEquals("[]", list.toString());
        assertEquals(0, list.size());

    }
}
