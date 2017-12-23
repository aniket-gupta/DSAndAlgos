package com.aniket.ctci.backtracking;

public class ModularExpression {

    /**
     * Implement pow(A, B) % C.
     * <p>
     * In other words, given A, B and C,
     * find (AB)%C.
     * <p>
     * Input : A = 2, B = 3, C = 3
     * Return : 2
     * 2^3 % 3 = 8 % 3 = 2
     */

    public int Mod(int a, int b, int c) {

        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        long y = 0;
        if (b % 2 == 0) {
            y = Mod(a, b / 2, c);
            y = (y * y) % c;
        } else {
            y = a % c;
            y = (y * Mod(a, b - 1, c)) % c;
        }
        // Incase y is negative.
        return (int) ((y + c) % c);

    }
}
