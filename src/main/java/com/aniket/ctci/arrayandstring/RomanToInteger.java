package com.aniket.ctci.arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /**
     * Given a roman numeral, convert it to an integer.
     * <p>
     * Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Read more details about roman numerals at Roman Numeric System
     * <p>
     * Example :
     * <p>
     * Input : "XIV"
     * Return : 14
     * Input : "XX"
     * Output : 20
     * See Expected Output
     */

    public int romanToInt(String a) {

        if (a == null || a.length() < 1) return 0;

        Map<Character, Integer> numMap = new HashMap<Character, Integer>();
        //I  V	X	L	C	D	M
        numMap.put('I', 1);
        numMap.put('V', 5);
        numMap.put('X', 10);
        numMap.put('L', 50);
        numMap.put('C', 100);
        numMap.put('D', 500);
        numMap.put('M', 1000);

        int sum = 0;
        int lastDigit = 0;

        for (int i = 0; i < a.length(); i++) {
            int val = numMap.get(a.charAt(i));
            if (lastDigit < val) {
                sum = sum + val - (2 * lastDigit);
            } else {
                sum = sum + val;
            }
            lastDigit = val;

        }

        return sum;

    }
}
