package com.aniket.ctci.arrayandstring;

import java.util.ArrayList;

public class IPAddress {

    /**
     * Very good use of recursion
     *
     * Valid Ip Addresses
     * <p>
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * <p>
     * A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
     * <p>
     * Example:
     * <p>
     * Given “25525511135”,
     * <p>
     * return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
     */

    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> list = new ArrayList<String>();
        if (a == null || a.length() < 4 || a.length() > 12) return list;
        dfs(a, "", 0, list);
        return list;
    }

    private void dfs(String s, String temp, int count, ArrayList<String> res) {
        if (count == 3 && isValid(s)) {
            res.add(temp + s);
            return;
        }

        for (int i = 1; i < 4 && i < s.length(); i++) {
            String substr = s.substring(0, i);
            if (isValid(substr)) {
                dfs(s.substring(i), temp + substr + ".", count + 1, res);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");

        long val = Long.parseLong(s);
        return val <= 255 && val > 0;

    }
}
