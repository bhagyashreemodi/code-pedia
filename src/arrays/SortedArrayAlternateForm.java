package arrays;

import java.util.Arrays;

/*
We're given a sorted array, nums, containing positive integers only. We have to rearrange the array so that when returned, the 0th index of the array will have the largest number, the
1st index will have the smallest number, the 2nd index will have the second largest number, the
3rd index will have the second smallest number, and so on.
In the end, we’ll have the largest remaining numbers in descending order and the smallest in ascending order at even and odd positions, respectively.
*/
public class SortedArrayAlternateForm {
    public static void main(String[] args) {
        int[][] inputArray = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {11, 22, 33, 44, 55, 66, 77, 88},
                {1, 2, 4, 8, 16, 32, 64, 128, 512, 1024},
                {3, 3, 5, 5, 7, 7, 9, 9, 11, 11, 13, 13},
                {100, 233, 544, 753, 864, 935, 1933, 2342}
        };

        for (int i = 0; i < inputArray.length; ++i) {
            System.out.print(i + 1 + ".\tOriginal array: " + Arrays.toString(inputArray[i]));
            int[] rearranged = rearrangeArray(inputArray[i]);
            System.out.print("\n\tRearranged array: " + Arrays.toString(rearranged));
            System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
        }
    }

    /*
    https://www.youtube.com/watch?v=ZRoVWxBngX0&list=TLPQMDUwNjIwMjQuSzqhU9QGoA&index=2&ab_channel=Techdose
     */
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return nums;

        // Initialize pointers to the start and end of the array
        int maxIdx = n - 1;
        int minIdx = 0;
        // Initialize a variable larger than any element in the array to use for encoding
        int maxElem = nums[n - 1] + 1;

        // Encoding phase
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {  // Encoding at even indexes
                nums[i] += (nums[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {  // Encoding at odd indexes
                nums[i] += (nums[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        // Decoding phase
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] / maxElem;
        }

        return nums;
    }
}
