package com.aniket.ctci.stack;

import com.aniket.ctci.linkedlist.LinkedList;

/**
 * Created by AnGupta on 5/28/17.
 */
public class BalancedBrackets {
    /*
    Your friend is making a text editor for programmers. He is currently working on a feature that will
    find errors in the usage of different types of brackets. Code can contain any brackets from the set
    []{}(), where the opening brackets are [,{, and ( and the closing brackets corresponding to them
    are ],}, and ).
    For convenience, the text editor should not only inform the user that there is an error in the usage
    of brackets, but also point to the exact place in the code with the problematic bracket. First priority
    is to find the first unmatched closing bracket which either doesn’t have an opening bracket before it,
    like ] in ](), or closes the wrong opening bracket, like } in ()[}. If there are no such mistakes, then
    it should find the first unmatched opening bracket without the corresponding closing bracket after it,
    like ( in {}([]. If there are no mistakes, text editor should inform the user that the usage of brackets
    is correct.
    Apart from the brackets, code can contain big and small latin letters, digits and punctuation marks.
    More formally, all brackets in the code should be divided into pairs of matching brackets, such that in
    each pair the opening bracket goes before the closing bracket, and for any two pairs of brackets either
    one of them is nested inside another one as in (foo[bar]) or they are separate as in f(a,b)-g[c].
    The bracket [ corresponds to the bracket ], { corresponds to }, and ( corresponds to ).
     */

    public int isBalanced(String str) {
        int result = -1;
        Stack<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() ||
                        (c  == ')' && stack.peek() != '(') ||
                        (c  == '}' && stack.peek() != '{') ||
                        (c  == ']' && stack.peek() != '[')) {
                    result = i + 1;
                    break;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            result = str.length();
        }

        return result;
    }

}
