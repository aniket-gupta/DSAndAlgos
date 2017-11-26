package com.aniket.ctci.arrayandstring;

public class AddBinaryStrings {

    /**
     * Add Binary Strings
     * Given two binary strings, return their sum (also a binary string).
     * <p>
     * Example:
     * <p>
     * a = "100"
     * <p>
     * b = "11"
     * Return a + b = “111”.
     */
    public static void main(String[] args) {
        System.out.println(new AddBinaryStrings().addBinary("1110000000010110111010100100111", "101001"));
    }

    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        StringBuffer strBuffer = new StringBuffer();
        char carry = '0';
        for (int i = b.length() - 1, j = a.length() - 1; i >= 0; i--, j--) {
            char a1 = a.charAt(j);
            char b1 = b.charAt(i);
            if (a1 == '1' && b1 == '1') {
                if (carry == '1') {
                    strBuffer.append('1');

                } else {
                    strBuffer.append('0');

                }
                carry = '1';
            } else if (a1 == '0' && b1 == '0') {
                if (carry == '1') {
                    strBuffer.append('1');

                    carry = '0';
                } else {
                    strBuffer.append('0');

                }
            } else {
                if (carry == '1') {
                    strBuffer.append('0');

                    carry = '1';
                } else {
                    strBuffer.append('1');

                }
            }
        }

        if (a.length() > b.length()) {
            int endIndex = a.length() - b.length() - 1;
            for (int i = endIndex; i >= 0; i--) {
                char c = a.charAt(i);

                if (carry == '1') {
                    if (c == '1') {
                        strBuffer.append('0');

                        carry = '1';
                    } else {
                        strBuffer.append(carry);
                        carry = '0';
                    }

                } else {
                    strBuffer.append(c);
                }


            }
        }
        if (carry == '1') {
            strBuffer.append(carry);
        }

        return strBuffer.reverse().toString();
    }
}
