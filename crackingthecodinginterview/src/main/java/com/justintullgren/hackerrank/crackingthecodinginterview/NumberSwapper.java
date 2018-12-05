package com.justintullgren.hackerrank.crackingthecodinginterview;

/**
 * Chapter 16
 * 16.1
 * Number Swapper - swap numbers in place without temporary variables.
 */
public class NumberSwapper {
    public static void swap(int[] arr) {
        // 1, 2
        arr[0] = arr[0] + arr[1];
        // 3, 2
        arr[1] = arr[0] - arr[1];
        // 3, 1
        arr[0] = arr[0] - arr[1];
        // 2, 1
    }

    public static void swapAnswer(int[] arr) {
        // 9, 4
        arr[0] = arr[0] - arr[1];
        // 5, 4
        arr[1] = arr[0] + arr[1];
        // 5, 9
        arr[0] = arr[1] - arr[0];
        // 4, 9
    }
}
