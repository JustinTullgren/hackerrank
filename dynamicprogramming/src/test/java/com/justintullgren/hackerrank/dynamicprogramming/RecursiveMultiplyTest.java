package com.justintullgren.hackerrank.dynamicprogramming;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RecursiveMultiplyTest {

    @Test
    public void testRecursiveMultiply() {
        int result = RecursiveMultiply.multiply(2, 4);
        assertThat(result).isEqualTo(8);

        result = RecursiveMultiply.multiply(3, 4);
        assertThat(result).isEqualTo(12);

        result = RecursiveMultiply.multiply(10000, 10000);
        assertThat(result).isEqualTo(100000000);

        result = RecursiveMultiply.multiply(10000, 0);
        assertThat(result).isEqualTo(0);

        result = RecursiveMultiply.multiply(12, -2);
        assertThat(result).isEqualTo(-24);

        result = RecursiveMultiply.multiply(-12, 2);
        assertThat(result).isEqualTo(-24);

        result = RecursiveMultiply.multiply(-12, -2);
        assertThat(result).isEqualTo(24);
    }
}