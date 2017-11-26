package com.aniket.ctci.arrayandstring;

import java.util.ArrayList;

public class JustifiedText {

    /**
     * Justified Text
     * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
     * <p>
     * Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
     * For the last line of text, it should be left justified and no extra space is inserted between words.
     * <p>
     * Your program should return a list of strings, where each string represents a single line.
     * <p>
     * Example:
     * <p>
     * words: ["This", "is", "an", "example", "of", "text", "justification."]
     * <p>
     * L: 16.
     * <p>
     * Return the formatted lines as:
     * <p>
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     */

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {

        ArrayList<String> list = new ArrayList<String>();

        if (a.size() < 1) return list;

        StringBuffer strBuffer = new StringBuffer();

        for (int i = 0; i < a.size(); i++) {
            if (strBuffer.length() == 0) {
                strBuffer.append(a.get(i));
            } else if (strBuffer.length() + a.get(i).length() + 1 <= b) {
                strBuffer.append(" " + a.get(i));
            } else {
                list.add(strBuffer.toString());
                strBuffer = new StringBuffer();
                strBuffer.append(a.get(i));
            }
        }
        list.add(strBuffer.toString());
        updateList(list, b);
        return list;
    }

    private void updateList(ArrayList<String> list, int len) {
        for (int j = 0; j < list.size() - 1; j++) {
            StringBuffer strBuffer = new StringBuffer(list.get(j));
            if (strBuffer.length() > 0) {
                int noOfSpaceReq = len - strBuffer.length();
                if (strBuffer.indexOf(" ") == -1) {
                    while (noOfSpaceReq > 0) {
                        strBuffer.append(" ");
                        noOfSpaceReq--;
                    }
                } else {

                    int i = 0;
                    while (noOfSpaceReq != 0 && i < strBuffer.length()) {
                        i = strBuffer.indexOf(" ", i);
                        if (i == -1) i = 0;
                        else {
                            strBuffer.insert(i, " ");
                            i += 2;
                            while (strBuffer.charAt(i) == ' ') {
                                i++;
                            }
                            noOfSpaceReq--;
                        }
                    }

                }
                list.set(j, /*"\"" + */ strBuffer.toString() /*+ "\""*/);
            }
        }

        StringBuffer strBuffer = new StringBuffer(list.get(list.size() - 1));
        if (strBuffer.length() > 0) {
            int noOfSpaceReq = len - strBuffer.length();
            while (noOfSpaceReq > 0) {
                strBuffer.append(" ");
                noOfSpaceReq--;
            }
            list.set(list.size() - 1, /*"\"" + */  strBuffer.toString() /*+ "\""*/);
        }


    }

}
