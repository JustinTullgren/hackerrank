package com.justintullgren.hackerrank.sorting;

import java.util.Collections;
import java.util.List;

public class QuickSortTest2 {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void sort(List<T> list, int left, int right) {
        int partition = partition(list, left, right);
        if (left < partition - 1) {
            sort(list, left, partition - 1);
        }
        if (right > partition) {
            sort(list, partition, right);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int left, int right) {
        T pivotValue = list.get((left + right) / 2);
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
