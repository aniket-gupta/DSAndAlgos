package com.aniket.ctci.arrayandstring;

public class MultiplyStrings {

    /**
     * Multiply Strings
     * Given two numbers represented as strings, return multiplication of the numbers as a string.
     * <p>
     * Note: The numbers can be arbitrarily large and are non-negative.
     * Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
     * For example,
     * given strings "12", "10", your answer should be “120”.
     * <p>
     * NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
     * We will retroactively disqualify such submissions and the submissions will incur penalties.
     */

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("5131848155574784703269632922904933776792735241197982102373370", "56675688419586288442134264892419611145485574406534291250836"));
    }

    public String multiply(String a, String b) {

        if (a == null || b == null) return "0";
        try {
            if (Integer.parseInt(a) == 0 || Integer.parseInt(b) == 0) return "0";
        } catch (Exception e) {
        }


        if (a.length() > b.length()) {
            return multiply(b, a);
        }

        int[][] table = new int[a.length()][b.length() + a.length() + 1];


        int count = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int a1 = a.charAt(i) - '0';
            int carry = 0;
            int j = b.length() - 1;
            for (; j >= 0; j--) {
                int b1 = b.charAt(j) - '0';
                int res = a1 * b1 + carry;
                carry = res / 10;
                int val = res % 10;
                table[i][j + a.length() - count + 1] = val;
            }

            if (carry != 0) {
                table[i][j + a.length() - count + 1] = carry;
            }
            count++;

        }

        char[] mult = new char[table[0].length];
        int carry = 0;
        for (int j = table[0].length - 1; j >= 0; j--) {

            int sum = 0;
            for (int i = table.length - 1; i >= 0; i--) {
                sum += table[i][j];
            }
            sum += carry;
            int res = sum % 10;
            carry = sum / 10;
            mult[j] = (char) ((char) res + '0');
        }

        int startIndex = 0;
        for (int i = 0; i < mult.length; i++) {
            if (mult[i] != '0') break;
            startIndex++;
        }

        if (carry != 0) {
            return String.valueOf(carry) + String.valueOf(mult, startIndex, mult.length - startIndex);
        }

        return String.valueOf(mult, startIndex, mult.length - startIndex);


    }
}
