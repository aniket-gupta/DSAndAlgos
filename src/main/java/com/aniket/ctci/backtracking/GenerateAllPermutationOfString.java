package com.aniket.ctci.backtracking;

public class GenerateAllPermutationOfString {

    public static void main(String[] args) {
        perm("abcd", "", 4);
    }

    public static void perm(String str, String permStr, int len) {
        if(permStr.length() == len) {
            System.out.println(permStr);
        } else {
            for(int i = 0; i < str.length(); i++) {

                perm(str.substring(0, i) + str.substring(i+1), permStr + str.charAt(i), len);
            }
        }
    }
}
