package com.justintullgren.hackerrank.sorting;

public class InsertionSort {
    public static void sortAscending(int[] arr) {
        // start at "position" 2 (0 based index + 1 = 1)
        // since elements will be shifted
        for (int j = 1; j < arr.length; j++) {
            // pop value to be sorted out
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                // shift element right (overriding key index value)
                arr[i + 1] = arr[i];
                i--;
            }
            // arr[i] is now <= key
            // so insert the popped value into the array
            arr[i + 1] = key;
        }

    }

    public static void sortDescending(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            // pop value to be sorted out
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] < key) {
                // shift element right (overriding key index value)
                arr[i + 1] = arr[i];
                i--;
            }
            // arr[i] is now <= key
            // so insert the popped value into the array
            arr[i + 1] = key;
        }
    }

    public static void sort(int[] arr, Order order) {
        // start at "position" 2 (0 based index + 1 = 1)
        // since elements will be shifted
        for (int j = 1; j < arr.length; j++) {
            // pop value to be sorted out
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && orderComparison(arr[i], key, order)) {
                // shift element right (overriding key index value)
                arr[i + 1] = arr[i];
                i--;
            }
            // arr[i] is now <> (depending on order) key
            // so insert the popped value into the array
            arr[i + 1] = key;
        }
    }

    private static boolean orderComparison(int a, int b, Order order) {
        return (order == Order.DESCENDING) ?
                a < b : a > b;
    }

    public enum Order {
        ASCENDING, DESCENDING;
    }
}
