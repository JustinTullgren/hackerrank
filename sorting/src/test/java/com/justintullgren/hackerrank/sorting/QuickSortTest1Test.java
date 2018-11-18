package com.justintullgren.hackerrank.sorting;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class QuickSortTest1Test {

    @Test
    public void testSort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(9);
        list.add(8);
        list.add(6);
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);

        QuickSortTest1.sort(list);
        int i = 0;
        while (++i < 11) {
            assertThat(list.get(i - 1)).isEqualTo(i);
        }
    }

}