package com.aniket.test.stack;

import com.aniket.ctci.stack.BalancedBrackets;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by AnGupta on 5/28/17.
 */
public class TestBalancedBrackets {

    @Test
    public void test() {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        assertEquals(-1, balancedBrackets.isBalanced("[]"));
        assertEquals(-1, balancedBrackets.isBalanced("{}[]"));
        assertEquals(-1, balancedBrackets.isBalanced("[()]"));
        assertEquals(-1, balancedBrackets.isBalanced("(())"));
        assertEquals(-1, balancedBrackets.isBalanced("{[]}()"));
        assertEquals(1, balancedBrackets.isBalanced("{"));
        assertEquals(3, balancedBrackets.isBalanced("{[}"));
        assertEquals(-1, balancedBrackets.isBalanced("foo(bar)"));
        assertEquals(10, balancedBrackets.isBalanced("foo(bar[i)"));

    }
}
