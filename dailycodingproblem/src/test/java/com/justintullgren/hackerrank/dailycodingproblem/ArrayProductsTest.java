package com.justintullgren.hackerrank.dailycodingproblem;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayProductsTest {

    @Test
    public void testNormal() {
        int[] result = ArrayProducts.productList(new int[]{1, 2, 3, 4, 5});
        assertThat(result).containsExactly(120, 60, 40, 30, 24);

        result = ArrayProducts.productList(new int[]{3, 2, 1});
        assertThat(result).containsExactly(2, 3, 6);
    }

    @Test
    public void testBonus() {
        int[] result = ArrayProducts.productListBonus(new int[]{1, 2, 3, 4, 5});
        assertThat(result).containsExactly(120, 60, 40, 30, 24);

        result = ArrayProducts.productListBonus(new int[]{3, 2, 1});
        assertThat(result).containsExactly(2, 3, 6);
    }

}