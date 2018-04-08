package com.aniket.ctci.arrayandstring;

/**
 * char[] message = { 'c', 'a', 'k', 'e', ' ',
 * 'p', 'o', 'u', 'n', 'd', ' ',
 * 's', 't', 'e', 'a', 'l' };
 * <p>
 * reverseWords(message);
 * <p>
 * System.out.println(message);
 * <p>
 * prints: "steal pound cake"
 */

public class ReverseWords {

    public static void main(String[] args) {
        String input = new String(new char[]{'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l'});
        System.out.println("input : " + input);
        char[] inputArr = input.toCharArray();
        reverseWords(inputArr);
        System.out.println("output : " + new String(inputArr));

        input = "My Name Is Aniket";
        System.out.println("input : " + input);
        inputArr = input.toCharArray();
        reverseWords(inputArr);
        System.out.println("output : " + new String(inputArr));
    }


    public static void reverseWords(char[] message) {

        // first reverse the message
        // input: { 'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l' };
        // output: {'l', 'a', 'e', 't', 's', ' ', 'd', 'n', 'u', 'o', 'p', ' ', 'e', 'k', 'a', 'c' }
        // now reverse the individual words
        // input:  {'l', 'a', 'e', 't', 's', ' ', 'd', 'n', 'u', 'o', 'p', ' ', 'e', 'k', 'a', 'c' }
        // output: {'s', 't', 'e', 'a', 'l', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 'c', 'a', 'k', 'e' }


        // ---------- reverse chars ------------
        for (int i = 0, j = message.length - 1; i < j; i++, j--) {
            char temp = message[i];
            message[i] = message[j];
            message[j] = temp;
        }

        // now reverse word
        int i = 0;
        int start = 0;

        while (i < message.length) {
            while (i < message.length && message[i] != ' ') {
                i++;
            }

            int end = i - 1;

            while (start < end) {
                char temp = message[start];
                message[start] = message[end];
                message[end] = temp;
                start++;
                end--;
            }

            start = ++i;
        }
    }
}
