package com.aniket.ctci.binarysearch;

public class MedianOfTwoSortedArray {

    // A = [1,3,5,7,9]
    // B = [2,4,6,8,10,12]

    public static void main(String[] args) {
        int[] A = {10, 20, 40, 60, 100, 140, 160, 200};
        int[] B = {15, 35, 50, 76, 80, 97, 111, 156, 171};
//        printArray(A);
//        printArray(B);
        mergeArrays(A, B, A.length, B.length, A.length + B.length);
//        System.out.println(usingMerge(A, B));
//        System.out.println(kthSmallestElement(A, 0, A.length, B, 0, B.length, (A.length + B.length)/2));
        System.out.println(usingBinarySearch(A, B));
    }

    public static float usingMerge(int[] a, int[] b) {

        int size_a = a != null ? a.length : 0;
        int size_b = b != null ? b.length : 0;

        int totalLen = size_a + size_b;

        if(totalLen > 0) {
            int[] s = mergeArrays(a, b, size_a, size_b, totalLen);

            if (totalLen % 2  == 0) {
                return (float) ((float) (s[totalLen/2] + s[totalLen/2 + 1]) / 2.0);
            } else return s[totalLen/2];
        }

        return -1;

    }

    public static double usingBinarySearch(int[] a, int[] b) {

        int len = a.length + b.length;
        if ( len % 2 == 1) return findKthSmallestElement(a, 0, b, 0, len/2 + 1);
        else return (findKthSmallestElement(a, 0, b, 0, len/2) + findKthSmallestElement(a, 0, b,0, len/2 + 1))/2.0;

    }

    private static int[] mergeArrays(int[] a, int[] b, int size_a, int size_b, int totalLen) {
        int[] s = new int[totalLen];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < size_a && j < size_b) {
            s[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        }

        while (i < size_a) s[k++] = a[i++];
        while (j < size_b) s[k++] = b[j++];
        printArray(s);
        return s;
    }

    private static void printArray(int[] s) {
        for (int integer : s) System.out.print( integer + " ");
        System.out.println();
    }

    public static int findKthSmallestElement(int[] a, int a_start, int[] b, int b_start, int k) {

        if(a_start > a.length) return b[b_start + k - 1];
        if(b_start > b.length) return a[a_start + k - 1];
        if(k == 1) return Math.min(a[a_start], b[b_start]);

        int a_key = a_start + k/2 - 1 < a.length ? a[a_start + k/2 - 1] : Integer.MAX_VALUE;
        int b_key = b_start + k/2 - 1 < b.length ? b[b_start + k/2 - 1] : Integer.MAX_VALUE;

        if(a_key < b_key)
            return findKthSmallestElement(a, a_start + k/2, b, b_start, k - k/2);
        else
            return findKthSmallestElement(a, a_start, b, b_start + k/2, k - k/2);

    }

}
