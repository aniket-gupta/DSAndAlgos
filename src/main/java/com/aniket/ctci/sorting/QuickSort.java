package com.aniket.ctci.sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by AnGupta on 5/23/17.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};

//        sort(a);
//        print(a);
        randomizedQuickSort(a, 0, a.length - 1);
        print(a);


    }

    public static void randomizedQuickSort(int[] a, int start, int end) {
        if(start >= end) {
            return;
        }

        int randomInt = getRandom(start, end);
        System.out.println("start : " + start + " end: " + end);
        System.out.println("random number: " + randomInt);
        swap(a, end, randomInt);
        print(a);

        int mid = partition(a, start, end);

        System.out.println("pivot point: " + mid);
        print(a);
        randomizedQuickSort(a, start, mid - 1);
        randomizedQuickSort(a, mid + 1, end);
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = partition(a, start, end);
        sort(a, start, mid - 1);
        sort(a, mid + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int j = start;
        for(int i = start; i <= end - 1; i++) {
            if(a[i] <= pivot) {

                swap(a, i, j);
                j++;
            }
        }

        swap(a, end, j);
        return j;
    }

    private static void swap(int[] a, int i , int j) {
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

    private static int getRandom(int min, int max) {
        Random r  = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
