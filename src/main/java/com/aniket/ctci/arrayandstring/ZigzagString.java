package com.aniket.ctci.arrayandstring;

import java.util.ArrayList;

public class ZigzagString {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P.......A........H.......N
     * ..A..P....L....S....I...I....G
     * ....Y.........I........R
     * And then read line by line: PAHNAPLSIIGYIR
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
     * *Example 2 : **
     * ABCD, 2 can be written as
     * <p>
     * A....C
     * ...B....D
     * and hence the answer would be ACBD.
     */

    public static void main(String[] args) {
        System.out.println(new ZigzagString().convert("ABCD", 3));
    }

    public String convert(String a, int b) {

        if (a == null || a.length() < 1) return null;
        if (b == 1) return a;
        String s = "a " + 'c';
        ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
        for (int i = 0; i < b; i++) {
            list.add(new StringBuffer());
        }
        int index = 0;
        boolean directionDown = true;
        for (int i = 0; i < a.length(); i++) {
            list.get(index).append(a.charAt(i));
            if (directionDown) {
                index++;
                directionDown = index >= b ? false : true;
                if (!directionDown) {
                    index = b - 2;
                }

            } else {
                index--;
                directionDown = index < 0 ? true : false;
                if (directionDown) {
                    index = 1;
                }
            }

        }

        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < b; i++) {
            strBuffer.append(list.get(i));
        }
        return strBuffer.toString();

    }
}
