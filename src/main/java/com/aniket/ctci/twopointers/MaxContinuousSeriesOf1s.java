package com.aniket.ctci.twopointers;

public class MaxContinuousSeriesOf1s {


    /**
     * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
     * Find the position of zeros which when flipped will produce maximum continuous series of 1s.
     * <p>
     * For this problem, return the indices of maximum continuous series of 1s in order.
     * <p>
     * Example:
     * <p>
     * Input :
     * Array = {1 1 0 1 1 0 0 1 1 1 }
     * M = 1
     * <p>
     * Output :
     * [0, 1, 2, 3, 4]
     * <p>
     * If there are multiple possible solutions, return the sequence which has the minimum start index.
     */

    /**
     * Solution Approach
     * Hint : Think in terms of 2 pointers.
     * Would it help if you maintained the number of 0s in the current range ? When would you range become invalid ?
     * <p>
     * Lets take an example:
     * <p>
     * N : 4
     * lis : 1 0 1 0
     * M : 2
     * <p>
     * pointer i and j
     * i = j = 0
     * iterate till i < N:
     * if(Number_of_Zeros_in_Current_range > M) :
     * increment j and reduce range till Number_of_Zeros_in_current_range < M
     * else :
     * add element in range and update all variables
     */

    public int[] maxone(int[] A, int B) {

        int i = 0;
        int maxLen = 1;
        int startIndex = 0;
        int endIndex = 0;

        while (i < A.length) {
            int j = i;
            int count = 0;
            while (j < A.length && count != B + 1) {
                if (A[j] == 0) count++;
                j++;
            }
            j = j - 1;
            if (A[j] == 0 && count == B + 1) j--;

            int len = j - i + 1;
            if (len > maxLen) {
                maxLen = len;
                startIndex = i;
                endIndex = j;
            }
            i++;
            
        }

        int[] arr = new int[maxLen];

        int ind = 0;
        while (startIndex <= endIndex) arr[ind++] = startIndex++;
        return arr;
    }
}
