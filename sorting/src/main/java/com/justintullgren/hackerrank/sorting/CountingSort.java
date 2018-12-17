package com.justintullgren.hackerrank.sorting;

public class CountingSort {
    public static int[] sort(int[] arr, int constraint) {
        int[] result = new int[arr.length];
        // Counts is a range. each element is the frequency of that range item.
        // it needs to be one bigger than the constraint due to 0-based indexing
        int[] counts = new int[constraint + 1];
        // count up the frequency of each item in the array
        for (int i = 0; i < arr.length; i++) {
            ++counts[arr[i]];
        }
        // sum each range item to get an "index" that that range item
        // can be inserted at in the new array
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }
        // shift it right since we summed from 0 index
        for (int i = counts.length - 1; i > 0; i--) {
            counts[i] = counts[i - 1];
        }
        // insert into result
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = counts[num];
            // we are inserting at this index so need to increment
            // for next loop
            counts[num]++;
            result[index] = num;
        }
        return result;

    }
}
