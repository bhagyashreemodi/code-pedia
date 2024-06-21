package arrays;

import java.util.Arrays;

/*
Given an unsorted array nums, find the sum of the maximum sum subarray. The maximum sum subarray is an array of contiguous elements in nums for which the sum of the elements is maximum.
Solution -> Kadane's Algorithm
https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
Link :  https://www.youtube.com/watch?v=AHZpyENo7k4&ab_channel=takeUforward
 */
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 3, 3, 1, 4},
                {2, 2, 1},
                {4, 1, 2, 1, 2},
                {-4, -1, -2, -1, -2},
                {-4, 2, -5, 1, 2, 3, 6, -5, 1},
                {25}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tMaximum Sum: " + findMaxSumSubArray(inputs[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }

    private static long findMaxSumSubArray(int[] input) {
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int start = 0;
        for(int i = 0; i < input.length; i++) {
            if(sum == 0) {
                start = i;
            }
            sum = sum + input[i];
            if( sum > maxSum)
            {
                maxSum = sum;
                /*If asked to print the subarray*/
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
