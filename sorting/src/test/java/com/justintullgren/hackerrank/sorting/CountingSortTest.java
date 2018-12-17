package com.justintullgren.hackerrank.sorting;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingSortTest {
    @Test
    public void test() {
        int[] items = {2, 22, 3, 3, 55, 4, 5, 3, 100};
        int[] result = CountingSort.sort(items);

        assertThat(result).isSorted();
    }

}