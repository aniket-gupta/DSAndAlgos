package com.aniket.ctci.arrayandstring;

public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * <p>
     * 1, 11, 21, 1211, 111221, ...
     * 1 is read off as one 1 or 11.
     * 11 is read off as two 1s or 21.
     * <p>
     * 21 is read off as one 2, then one 1 or 1211.
     * <p>
     * Given an integer n, generate the nth sequence.
     * <p>
     * Note: The sequence of integers will be represented as a string.
     * <p>
     * Example:
     * <p>
     * if n = 2,
     * the sequence is 11.
     */

    public String countAndSay(int a) {
        if (a < 1) return "";

        String currentSeq = "1";

        for (int i = 1; i < a; i++) {

            currentSeq = generateNextSeq(currentSeq);
        }

        return currentSeq;
    }

    private String generateNextSeq(String currentSeq) {
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        int i = 0;
        while (i < currentSeq.length() - 1) {
            if (currentSeq.charAt(i) == currentSeq.charAt(i + 1)) {
                count++;
                i++;
            } else {
                buffer.append(count);
                buffer.append(currentSeq.charAt(i));
                count = 1;
                i++;
            }
        }
        buffer.append(count);
        buffer.append(currentSeq.charAt(i));
        return buffer.toString();
    }
}
