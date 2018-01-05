package com.aniket.ctci.backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {

    /**
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3 ) :
     * <p>
     * 1. "123"
     * 2. "132"
     * 3. "213"
     * 4. "231"
     * 5. "312"
     * 6. "321"
     * Given n and k, return the kth permutation sequence.
     * <p>
     * For example, given n = 3, k = 4, ans = "231"
     * <p>
     * Good questions to ask the interviewer :
     * What if n is greater than 10. How should multiple digit numbers be represented in string?
     * In this case, just concatenate the number to the answer.
     * so if n = 11, k = 1, ans = "1234567891011"
     * Whats the maximum value of n and k?
     * In this case, k will be a positive integer thats less than INT_MAX.
     * n is reasonable enough to make sure the answer does not bloat up a lot.
     */

    public static void main(String[] args) {
        KthPermutationSequence obj = new KthPermutationSequence();
        String permutation = obj.getPermutation(3, 6);
        System.out.println(permutation);
    }


    /**
     * ]
     * <p>
     * This involves a little bit of maths and recursion for simplicity.
     * <p>
     * Number of permutation possible using n distinct numbers = n!
     * <p>
     * Lets first make k 0 based.
     * Let us first look at what our first number should be.
     * Number of sequences possible with 1 in first position : (n-1)!
     * Number of sequences possible with 2 in first position : (n-1)!
     * Number of sequences possible with 3 in first position : (n-1)!
     * <p>
     * Hence, the number at our first position should be k / (n-1)! + 1 th integer.
     * <p>
     * Can we reduce the k and modify the set we pick our numbers from ( initially 1 2 3 … n ) to call the function for second position onwards ?
     * <p>
     * For example, n=4 and k=8, in this case we need to find 8th permutation in the permutation sequence of {1,2,3,4}. Below is all of 4! = 24 permutations in order. 8th permutation is [2, 1, 4, 3].
     * <p>
     * 1. [1, 2, 3, 4]
     * 2. [1, 2, 4, 3]
     * 3. [1, 3, 2, 4]
     * 4. [1, 3, 4, 2]
     * 5. [1, 4, 2, 3]
     * 6. [1, 4, 3, 2]
     * 7. [2, 1, 3, 4]
     * 8. [2, 1, 4, 3]
     * 9. [2, 3, 1, 4]
     * 10. [2, 3, 4, 1]
     * 11. [2, 4, 1, 3]
     * 12. [2, 4, 3, 1]
     * 13. [3, 1, 2, 4]
     * 14. [3, 1, 4, 2]
     * 15. [3, 2, 1, 4]
     * 16. [3, 2, 4, 1]
     * 17. [3, 4, 1, 2]
     * 18. [3, 4, 2, 1]
     * 19. [4, 1, 2, 3]
     * 20. [4, 1, 3, 2]
     * 21. [4, 2, 1, 3]
     * 22. [4, 2, 3, 1]
     * 23. [4, 3, 1, 2]
     * 24. [4, 3, 2, 1]
     * A permutation stating with a number has (n-1) positions to permute the rest (n-1) numbers giving total (n-1)! permutations stating with each of the elements in lexicographic order. For example, n=4, We can see the first (4-1)! = 3! = 6 permutations fixed for permutations starting with 1. Next 6 position is fixed for permutations starting with 2 and so on. For each of 6 permutations starting with 1, the next position will be fixed with 2 for total (n-2)! = (4-2)! = 2! = 2 permutations.
     * <p>
     * That is, first (n-1)! permutations will start with 1, next (n-1)! permutations will start with 2 and so on. That is for a given k the permutation will start with the element at index k/(n-1)!. We need to have this element fixed at the first spot and shift the remaining numbers down to right of it.
     */
    public String getPermutation(int A, int B) {
        ArrayList<Integer> candidateSet = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            candidateSet.add(i);
        }
        return getPermutation(B - 1, candidateSet);
    }

    private static String getPermutation(int k, ArrayList<Integer> candidateSet) {
        int n = candidateSet.size();
        if (n == 0) {
            return "";
        }
        if (k > factorial(n)) return ""; // invalid. Should never reach here.

        int f = factorial(n - 1);
        int pos = k / f;
        k %= f;
        String ch = String.valueOf(candidateSet.get(pos));
        // now remove the character ch from candidateSet.
        candidateSet.remove(pos);
        return ch + getPermutation(k, candidateSet);
    }

    static int factorial(int n) {
        if (n > 12) {
            // this overflows in int. So, its definitely greater than k
            // which is all we care about. So, we return INT_MAX which
            // is also greater than k.
            return Integer.MAX_VALUE;
        }
        // Can also store these values. But this is just < 12 iteration, so meh!
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}
