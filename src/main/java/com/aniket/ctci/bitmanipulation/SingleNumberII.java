package com.aniket.ctci.bitmanipulation;

public class SingleNumberII {

    /**
     * Given an array of integers, every element appears thrice except for one which occurs once.
     * <p>
     * Find that element which does not appear thrice.
     * <p>
     * Note: Your algorithm should have a linear runtime complexity.
     * <p>
     * Could you implement it without using extra memory?
     * <p>
     * Example :
     * <p>
     * Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
     * Output : 4
     */

    /**
     * Lets see some XOR operation,
     * 1.   5 ^ 5     = 0101 ^ 0101 = 0000
     * 2.   1 ^ 1     = 0001 ^ 0001 = 0000
     * 3.   10 ^ 10 = 1010 ^ 1010 = 0000
     * From the above few operation, we can see that when a number is XOR with same number then result is 0.
     * <p>
     * Also XOR is Associative and Commutative, it means
     * Associative    = giving the same result regardless of grouping, i.e. so that a*(b*c)=(a*b)*c
     * Commutative = independent of order; as in e.g. "a x b = b x a"
     * <p>
     * 1.  1 ^ 1 = 0
     * 2.  1 ^ 1 ^ 2 ^ 2 = 0
     * 3.  1 ^ 2 ^ 1 ^ 2 = 0
     * <p>
     * Irrespective of order, when a same number will be XOR twice then result will be 0.
     * <p>
     * So, Now lets see our original problem statement.
     * Given an array of integers. All numbers occur thrice except one number which occurs once. Find the number.
     * <p>
     * If all the number appeared twice except one number and we need to find that number then it is easy,
     * <p>
     * Let's take a small example, say given array is,
     * 1. {1, 1 , 2}
     * Answer is 2 here, XOR all the numbers. result will be the number that appeared only once.
     * From the fact we saw that when a number is XOR with same number then result is 0.
     * = (1 ^ 1) ^ 2
     * = (0) ^ 2
     * =  2
     * Number that appear only once is 2.
     * <p>
     * In our question, all numbers are appeared thrice, So how to solve that?
     * If we do XOR of 3 same number then result will be same number, So XOR all number will not helpful here.
     * <p>
     * So idea here is to take 2 variable, say var1 and var2
     * 1. var1 will keep a note that variable appeared first time.
     * 2. var2 will keep a note that same variable appeared second time.
     * 3. Now, when the same variable appears third time, we have to discard the element as number
     * appears 3 times which is fine and it is not the variable we are looking for.
     * Also, if the number appears 3 times properly, then we have to initialize var1 and var2 to 0 to
     * start looking for new element.
     * So for all the numbers which appears thrice, var1 and var2 will become 0 but only for number
     * which appears only once, var1 will be set with that value.
     * <p>
     * Lets see what each line do in program.
     * <p>

     * secondTimeOccurence =  secondTimeOccurence | (firstTimeOccurence & arr[i]);
     * firstTimeOccurence  =  firstTimeOccurence ^ arr[i];
     * int neutraliser     =  ~(firstTimeOccurence & secondTimeOccurence);
     * firstTimeOccurence  =  firstTimeOccurence & neutraliser;
     * secondTimeOccurence =  secondTimeOccurence & neutraliser;
     * <p>
     * First line initialize the var2
     * Second line initialize var1
     * Third, Forth and Fifth line task is to check if the number appears thrice then reinitialize var1 and var2 to 0.
     * <p>
     * Lets take a simple example and see, given array is {1, 1, 1, 2}
     * 1. 1st iteration encounter 1
     * secondTimeOccurence = 0
     * firstTimeOccurence = 1
     * <p>
     * 2. 2nd iteration encounter 1
     * secondTimeOccurence = 1
     * firstTimeOccurence = 0
     * <p>
     * 3. 3rd iteration encounter 1
     * secondTimeOccurence = 0
     * firstTimeOccurence = 0
     * <p>
     * 4. 4th iteration encounter 2
     * secondTimeOccurence = 0
     * firstTimeOccurence = 2
     * <p>
     * Number that appear only once is present in variable firstTimeOccurence that is 2 here.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(new SingleNumberII().singleNumber(A));
    }

    public int singleNumber(final int[] A) {
        int firstTimeOccurence = 0;
        int secondTimeOccurence = 0;

        for (int i = 0; i < A.length; i++) {
            secondTimeOccurence = secondTimeOccurence | (firstTimeOccurence & A[i]);
            firstTimeOccurence = firstTimeOccurence ^ A[i];
            int neutraliser = ~(firstTimeOccurence & secondTimeOccurence);
            firstTimeOccurence = firstTimeOccurence & neutraliser;
            secondTimeOccurence = secondTimeOccurence & neutraliser;
        }
        return firstTimeOccurence;
    }
}
