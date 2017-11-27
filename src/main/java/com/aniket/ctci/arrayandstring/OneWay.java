package com.aniket.ctci.arrayandstring;

/**
 * problem 1.5
 */
public class OneWay {

    public static void main(String[] args) {
        System.out.println(new OneWay().isOneWay("pale", "ple"));
        System.out.println(new OneWay().isOneWay("pales", "pale"));
        System.out.println(new OneWay().isOneWay("pale", "bale"));
        System.out.println(new OneWay().isOneWay("pale", "bake"));
    }

    public boolean isOneWay(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        if (str1.length() == str2.length()) {
            return isEditReplace(str1, str2);
        } else if (str1.length() > str2.length()) {
            return isEditInsert(str1, str2);
        } else return isEditInsert(str2, str1);

    }

    private boolean isEditInsert(String str1, String str2) {

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str1.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else i++;
            j++;
        }

        return true;

    }

    private boolean isEditReplace(String str1, String str2) {
        boolean foundDiff = false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (foundDiff) return false;
                foundDiff = true;
            }
        }

        return true;
    }

}
