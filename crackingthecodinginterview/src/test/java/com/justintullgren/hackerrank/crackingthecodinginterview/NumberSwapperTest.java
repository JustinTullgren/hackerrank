package com.justintullgren.hackerrank.crackingthecodinginterview;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSwapperTest {

    @Test
    public void test() {
        int[] arr = {1, 2};
        NumberSwapper.swap(arr);
        assertThat(arr).isEqualTo(new int[]{2, 1});

        arr[0] = 8;
        arr[1] = 5;

        NumberSwapper.swap(arr);

        assertThat(arr).isEqualTo(new int[]{5, 8});

    }

}