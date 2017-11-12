package com.aniket.ctci.arrayandstring;

public class CompareVersionNumbers {

    /**
     * Compare Version Numbers
     * Compare two version numbers version1 and version2.

     If version1 > version2 return 1,
     If version1 < version2 return -1,
     otherwise return 0.
     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

     */
    public int compareVersion(String a, String b) {

        int i = 0;
        int j = 0;


        while (i < a.length() || j < b.length()) {

            long ver_a = 0;
            long ver_b = 0;
            while (i < a.length() && a.charAt(i) != '.') {

                ver_a = (long) (ver_a * (long) 10) + (long) ((long) a.charAt(i) - (long) '0');
                i++;
            }


            while (j < b.length() && b.charAt(j) != '.') {
                ver_b = (long) ((long) ((long) ver_b * (long) 10) + (long) ((long) b.charAt(j) - (long) '0'));
                j++;
            }


            if (ver_a < 0 && ver_b >= 0) { // for out of range case
                return 1;
            }

            if (ver_b < 0 && ver_a >= 0) { // for out of range case
                return -1;
            }

            if (ver_a > ver_b) {
                return 1;
            } else if (ver_a < ver_b) {
                return -1;
            }

            i++;
            j++;

        }


        return 0;


    }
}
