package com.aniket.ctci.arrayandstring;

public class KthSmallestElementInArray {

    /**
     * Find the kth smallest element in an unsorted array of non-negative integers.
     * <p>
     * Definition of kth smallest element
     * <p>
     * kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
     * In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
     * NOTE
     * You are not allowed to modify the array ( The array is read only ).
     * Try to do it using constant extra space.
     * <p>
     * Example:
     * <p>
     * A : [2 1 4 3 2]
     * k : 3
     * <p>
     * answer : 2
     */

//    static final int[] A = {2 ,1, 4, 3, 2};

    public static void main(String[] args) {
        int[] A = {2 ,1, 4, 3, 2};
        for (int i: A) {
            System.out.print(i + " ");
        }
        System.out.println();

        KthSmallestElementInArray obj = new KthSmallestElementInArray();
        obj.kthsmallest(A, 3);
        for (int i: A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int kthsmallest(final int[] A, int B) {

        return kthSmallest(A, 0, A.length - 1, B);
    }

    private int kthSmallest(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last element and get
            // position of pivot element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)  // If position is more, recur for left subarray
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        return Integer.MAX_VALUE;
    }

    private int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
