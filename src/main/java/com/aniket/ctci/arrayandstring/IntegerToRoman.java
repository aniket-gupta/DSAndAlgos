package com.aniket.ctci.arrayandstring;

public class IntegerToRoman {

    /**
     * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version
     * <p>
     * Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Example :
     * <p>
     * Input : 5
     * Return : "V"
     * <p>
     * Input : 14
     * Return : "XIV"
     */

    public String intToRoman(int a) {

        StringBuffer strBuffer = new StringBuffer();

        while (a != 0) {
            if (a >= 1000) {
                int count = a / 1000;
                append("M", count, strBuffer);
                a = a % 1000;
            } else if (a >= 500) {
                if (a < 900) {
                    int count = a / 500;
                    append("D", count, strBuffer);
                    a = a % 500;
                } else {
                    append("CM", 1, strBuffer);
                    a = a % 100;
                }

            } else if (a >= 100) {
                if (a < 400) {
                    int count = a / 100;
                    append("C", count, strBuffer);
                    a = a % 100;
                } else {
                    append("CD", 1, strBuffer);
                    a = a % 100;
                }

            } else if (a >= 50) {
                if (a < 90) {
                    int count = a / 50;
                    append("L", count, strBuffer);
                    a = a % 50;
                } else {
                    append("XC", 1, strBuffer);
                    a = a % 10;
                }
            } else if (a >= 10) {
                if (a < 40) {
                    int count = a / 10;
                    append("X", count, strBuffer);
                    a = a % 10;
                } else {
                    append("XL", 1, strBuffer);
                    a = a % 10;
                }
            } else if (a >= 5) {
                if (a < 9) {

                    append("V", 1, strBuffer);
                    a = a % 5;
                } else {
                    append("IX", 1, strBuffer);
                    a = 0;
                }
            } else if (a >= 1) {
                if (a < 4) {
                    append("I", a, strBuffer);
                    a = 0;
                } else {
                    append("IV", 1, strBuffer);
                    a = 0;
                }
            }
        }
        return strBuffer.toString();
    }

    private void append(String s, int count, StringBuffer strBuffer) {
        for (int i = 0; i < count; i++) {
            strBuffer.append(s);
        }
    }

}
