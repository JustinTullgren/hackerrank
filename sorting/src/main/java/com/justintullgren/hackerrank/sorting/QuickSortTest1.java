package com.justintullgren.hackerrank.sorting;

import java.util.Collections;
import java.util.List;

public class QuickSortTest1 {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, 0, list.size() - 1);

    }

    private static <T extends Comparable<T>> void sort(List<T> list, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = (left + right) / 2;
        Comparable<T> pivotValue = list.get(pivotIndex);
        int partitionIndex = partition(list, left, right, pivotValue);
        sort(list, left, partitionIndex - 1);
        sort(list, partitionIndex, right);
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int left, int right, Comparable<T> pivotValue) {
        while (left <= right) {
            while (pivotValue.compareTo(list.get(left)) > 0) {
                left++;
            }
            while (pivotValue.compareTo(list.get(right)) < 0) {
                right--;
            }
            if (left <= right) {
                Collections.swap(list, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

}
