package com.aniket.ctci.backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every string of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return

     [
     ["a","a","b"]
     ["aa","b"],
     ]
     Ordering the results in the answer : Entry i will come before Entry j if :
     len(Entryi[0]) < len(Entryj[0]) OR
     (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
     *
     *
     *
     (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
     In the given example,
     ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
     */

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = new PalindromePartitioning().partition("abcba");
        System.out.println(list);
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> palindromSetList = new ArrayList<>();
        ArrayList<String> palindromSet = new ArrayList<>();
        partition(a, 0, palindromSet, palindromSetList);

        return  palindromSetList;

    }

    private void partition(String str, int start, ArrayList<String> palindromSet, ArrayList<ArrayList<String>> palindromSetList) {
        System.out.println("start " + start);
        if(start>=str.length()) {
            System.out.println("Adding " + palindromSet);
            palindromSetList.add(new ArrayList<>(palindromSet));
            return;
        }

        for (int i = start; i<str.length(); i++) {
//            System.out.println("i " + i);
            if (isPalindrom(str, start, i)) {
                System.out.println("start " + start + " i " + i);
                String substring = str.substring(start, i + 1);
                palindromSet.add(substring);
                partition(str, i+ 1, palindromSet, palindromSetList);
                System.out.println("before removing start" +  start + " i " + i);
                palindromSet.remove(palindromSet.size() - 1);
            }
        }
    }


    private boolean isPalindrom(String str, int start, int end) {

        int i = start;
        int j = end;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
