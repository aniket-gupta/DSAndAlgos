package com.aniket.ctci.sorting;

/**
 * Created by AnGupta on 5/22/17.
 */
public class SelectionSort {


    public static void main(String[] args) {
        int[] a  = {1,2,3,4,5};
        sort(a);
        print(a);
        a  = new int[]{5,4,3,2,1};
        sort(a);
        print(a);
    }


    // O(n^2)
    public static void sort(int[] a) {

        for(int i = 0; i < a.length; i++) {

            int minIndex = 0;
            int minValue = a[i];
            for(int j = i+1; j < a.length; j++) {
                if(a[j] < minValue) {
                    minValue = a[j];
                    minIndex = j;
                }
            }

            if(a[i] > minValue)
                swap(a, minIndex, i);

        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
    }
}
