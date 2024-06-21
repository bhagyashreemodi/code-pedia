package arrays;

import java.util.Arrays;

/*
 * Implement a function that rearranges elements in an array so that all
 * negative elements appear to the left and all positive elements
 * (including zero) appear to the right.
 * It’s important to note that maintaining the original sorted order
 * of the input array is not required for this task.
 */
public class RearrangePositiveAndNegativeNumbers {

    public static void rearrange(int[] arr) {
        int leftMostPosEle = 0;
        for (int curr = 0; curr < arr.length; curr++) {
            // If negative number found
            if (arr[curr] < 0) {
                if (curr != leftMostPosEle) {
                    // Swapping with leftmost positive
                    int temp = arr[curr];
                    arr[curr] = arr[leftMostPosEle];
                    arr[leftMostPosEle] = temp;
                }
                leftMostPosEle++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {10, 4, 6, 23, 7},
                {-3, 20, -1, 8},
                {2, -5, -4, 43, 2},
                {-3, -10, -19, 21, -17},
                {25, 50, 75, 100, 400}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            rearrange(inputs[i]);
            System.out.println("\tResult: " + Arrays.toString(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}