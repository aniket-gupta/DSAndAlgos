package com.aniket.ctci.arrayandstring;


import java.util.PriorityQueue;

/**
 * problem 1.4n
 */
public class PalindromPermutaion {

    public static void main(String[] args) {
        String str = "Tact Coa";

        System.out.println(new PalindromPermutaion().palindromPermutaion(str));
    }

    public boolean palindromPermutaion(String str) {
        int[] table = buildCharTable(str);

        return containsOnlyOneOdd(table);
    }

    private boolean containsOnlyOneOdd(int[] table) {
        boolean foundOdd = false;

        for (int i : table) {
            if (i % 2 != 0) {
                if (foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }

    private int[] buildCharTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for(Character c : str.toCharArray()) {
            int x = getNumericValueFromChar(c);
            if(x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    private int getNumericValueFromChar(Character c) {

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(Character.toLowerCase(c));
        if(a <= val && val <= z) return val - a;
        return -1;

    }
}
