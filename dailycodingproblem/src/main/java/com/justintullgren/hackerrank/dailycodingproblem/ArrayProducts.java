package com.justintullgren.hackerrank.dailycodingproblem;

/**
 * Problem: Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * <p>
 * Follow-up: what if you can't use division?
 */
public class ArrayProducts {

    public static int[] productList(int[] arr) {
        int total = arr[0];
        for (int i = 1; i < arr.length; i++) {
            total *= arr[i];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = total / arr[i];
        }
        return result;
    }

    public static int[] productListBonus(int[] arr) {
        int length = arr.length;
        int prod[] = new int[length];
        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0; i < length; i++) {
            prod[i] = 1;
        }
        for (int i = 0; i < length; i++) {
            prod[i] *= leftProd;
            leftProd *= arr[i];
            prod[length - 1 - i] *= rightProd;
            rightProd *= arr[length - 1 - i];
        }
        return prod;
    }

}
