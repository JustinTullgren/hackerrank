package com.justintullgren.hackerrank.sorting;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertionSortTest {

    @Test
    public void testAscending() {
        int[] arr = {5, 4, 7, 2, 3, 1, 6};
        InsertionSort.sortAscending(arr);
        assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void testDescending() {
        int[] arr = {5, 4, 7, 2, 3, 1, 6};
        InsertionSort.sortDescending(arr);
        assertThat(arr).isEqualTo(new int[]{7, 6, 5, 4, 3, 2, 1});

    }

    @Test
    public void testSort() {
        int[] arr = {5, 4, 7, 2, 3, 1, 6};
        InsertionSort.sort(arr, InsertionSort.Order.DESCENDING);
        assertThat(arr).isEqualTo(new int[]{7, 6, 5, 4, 3, 2, 1});

        arr = new int[]{5, 4, 7, 2, 3, 1, 6};
        InsertionSort.sort(arr, InsertionSort.Order.ASCENDING);
        assertThat(arr).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7});

    }

}