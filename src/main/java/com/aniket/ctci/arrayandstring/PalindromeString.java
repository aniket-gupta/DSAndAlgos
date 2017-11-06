package com.aniket.ctci.arrayandstring;

public class PalindromeString {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     Example:

     "A man, a plan, a canal: Panama" is a palindrome.

     "race a car" is not a palindrome.

     Return 0 / 1 ( 0 for false, 1 for true ) for this problem

     */

    public int isPalindrome(String a) {

        if(a == null || a.length() < 2) return 1;

        int i = 0;
        int j = a.length() - 1;
        String punchuation = ",;'.:-\"";
        a = a.toLowerCase();

        while(i < j) {

            if(a.charAt(i) == ' ' || punchuation.indexOf(a.charAt(i)) != -1) {
                i++;
            } else if(a.charAt(j) == ' ' || punchuation.indexOf(a.charAt(j)) != -1) {
                j--;
            } else {
                if(a.charAt(i) != a.charAt(j)) {
                    return 0;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return 1;


    }
}
