package com.aniket.ctci.binarysearch;

/**
 * Created by AnGupta on 7/31/17.
 */
public class PaintersPartitionProblem {

    /**
     * Painter's Partition ProblemBookmark Suggest Edit

     You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given
     how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the
     constraints that any painter will only paint contiguous sections of board.

     NOTE:
     1. 2 painters cannot share a board to paint. That is to say, a board
     cannot be painted partially by one painter, and partially by another.
     2. A painter will only paint contiguous boards. Which means a
     configuration where painter 1 paints board 1 and 3 but not 2 is
     invalid.

     Return the ans % 10000003

     Input :
     K : Number of painters
     T : Time taken by painter to paint 1 unit of board
     L : A List which will represent length of each board

     Output:
     return minimum time to paint all boards % 10000003

     Example:

     Input :
     K : 2
     T : 5
     L : [1, 10]

     Output : 50

     */

    public int paint(int k, int t, int[] c) {

        int max = 0;
        for(int i =0;i<c.length;i++)
        {
            max +=(int)(((long)c[i])%10000003);
            max = max%10000003;
        }
        int begin = 0, end = max;
        while(begin<end) {
            int mid = (begin + end) / 2;
            //System.out.println(begin + " -" + mid +"- " + end + " " + isPossible(k,mid,c) );
            if(isPossible(k,mid,c))
                end = mid;
            else
                begin = mid + 1;
        }
        return  (int)(((long)end*t)%10000003);
    }

    private boolean isPossible(int k, int averageTime, int[] c)
    {
        int painterCount =1;
        int currentTime = 0;
        for(int i = 0;i<c.length;i++)
        {
            currentTime += c[i];
            if(currentTime >averageTime) {
                painterCount+=1;
                currentTime = c[i];
                if(currentTime>averageTime || painterCount>k) return false;
            }
        }
        return true;
    }
}
