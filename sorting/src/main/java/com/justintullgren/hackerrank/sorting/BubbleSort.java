package com.justintullgren.hackerrank.sorting;

import java.util.Collections;
import java.util.List;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        boolean isSorted = false;
        int length = list.size() - 1;
        T a, b;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < length; i++) {
                a = list.get(i);
                b = list.get(i + 1);
                if (a.compareTo(b) > 0) {
                    Collections.swap(list, i, i + 1);
                    isSorted = false;
                }

            }
            length--;
        }
    }
}
