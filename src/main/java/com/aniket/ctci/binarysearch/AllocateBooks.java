package com.aniket.ctci.binarysearch;

/**
 * Created by AnGupta on 8/1/17.
 */
public class AllocateBooks {

    /**
     * N number of books are given.
     The ith book has Pi number of pages.
     You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

     NOTE: Return -1 if a valid assignment is not possible
     Input:
        List of Books M number of students
     Your function should return an integer corresponding to the minimum number.

     Example:
     P : [12, 34, 67, 90]
     M : 2

     Output : 113

     There are 2 number of students. Books can be distributed in following fashion :
     1) [12] and [34, 67, 90]
     Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
     2) [12, 34] and [67, 90]
     Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
     3) [12, 34, 67] and [90]
     Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

     Of the 3 cases, Option 3 has the minimum pages = 113.
     */

    public static void main(String[] args) {
        int[] A = { 73, 58, 30, 72, 44, 78, 23, 9};
        int B = 5;

        System.out.println(books(A, B));
    }

    public static int books(int[] A, int B) {

        if(A == null || B < 1 || A.length < B) return -1;

        if(A.length == 1) return A[0];

        int minPages = Integer.MAX_VALUE;
        int maxPages = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < A.length; i++) {
            maxPages += A[i];
            if(A[i] < minPages) minPages = A[i];
        }

        if(B < 2) return maxPages;

        while (minPages < maxPages) {
            int mid = minPages + (maxPages - minPages) / 2;
            boolean isPos = isPossible(A, B, mid);
            if(isPos) {

                ans =Math.min(ans, mid);
                maxPages = mid;

            } else {

                minPages = mid + 1;
            }

        }
//        if(ans == Integer.MAX_VALUE) return -1;
        return ans;


    }

    private static boolean isPossible(int[] A, int B, int numOfPages) {

        int count = 1;
        int sum = 0;

        for(int i = 0; i < A.length; i++) {

            if(A[i] > numOfPages) return false;

            if(( sum + A[i]) > numOfPages ) {
                sum = A[i];
                count++;
                if(count > B) return false;
            } else {
                sum += A[i];
            }
        }


        return true;

    }
}
