package com.aniket.ctci.arrayandstring;

import java.util.ArrayList;

public class PrettyJson {

    /**
     * Pretty print a json object using proper indentation.
     * <p>
     * Every inner brace should increase one indentation to the following lines.
     * Every close brace should decrease one indentation to the same line and the following lines.
     * The indents can be increased with an additional ‘\t’
     * Example 1:
     * <p>
     * Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
     * Output :
     * {
     * A:"B",
     * C:
     * {
     * D:"E",
     * F:
     * {
     * G:"H",
     * I:"J"
     * }
     * }
     * }
     * Example 2:
     * <p>
     * Input : ["foo", {"bar":["baz",null,1.0,2]}]
     * Output :
     * [
     * "foo",
     * {
     * "bar":
     * [
     * "baz",
     * null,
     * 1.0,
     * 2
     * ]
     * }
     * ]
     * [] and {} are only acceptable braces in this case.
     * <p>
     * Assume for this problem that space characters can be done away with.
     * <p>
     * Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
     */

    public static void main(String[] args) {
        ArrayList<String> strings = new PrettyJson().prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public ArrayList<String> prettyJSON(String a) {

        ArrayList<String> list = new ArrayList<String>();
        int iden = 0;
        char lastChar = 0;
        int index = 0;
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '[' || c == '{') {
                strBuffer = new StringBuffer();
                doIdentation(iden, strBuffer);
                strBuffer.append(c);
                list.add(strBuffer.toString());
                iden++;
                index = list.size();

            } else if (c == ']' || c == '}') {
                iden--;
                strBuffer = new StringBuffer();
                doIdentation(iden, strBuffer);
                strBuffer.append(c);
                list.add(strBuffer.toString());
                index = list.size();

            } else if (c == ',') {
                list.set(list.size() - 1, list.get(list.size() - 1) + c);
                index = list.size();
            } else {
                if (c == '\n') continue;
                if (lastChar == ',' && c == ' ') {
                    continue;
                }
                if (index == list.size()) {
                    strBuffer = new StringBuffer();
                    doIdentation(iden, strBuffer);
                    list.add(strBuffer.toString());
                }
                list.set(index, list.get(index) + c);
            }
            lastChar = c;
        }
        return list;
    }

    private void doIdentation(int count, StringBuffer strBuffer) {
        for (int i = 0; i < count; i++) {
            strBuffer.append("\t");
        }
    }

}
