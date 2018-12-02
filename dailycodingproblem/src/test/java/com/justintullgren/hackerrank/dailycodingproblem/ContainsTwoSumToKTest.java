package com.justintullgren.hackerrank.dailycodingproblem;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainsTwoSumToKTest {

    @Test
    public void testContainsTwo() {
        int[] arr = {0};
        boolean result = ContainsTwoSumToK.check(3, arr);
        assertThat(result).isEqualTo(false);

        arr = new int[]{1, 3};
        result = ContainsTwoSumToK.check(3, arr);
        assertThat(result).isEqualTo(false);

        arr = new int[]{1, 2};
        result = ContainsTwoSumToK.check(3, arr);
        assertThat(result).isEqualTo(true);

        arr = new int[]{1, 2};
        result = ContainsTwoSumToK.check(2, arr);
        assertThat(result).isEqualTo(false);

        arr = new int[]{1, 0, 0, 0, 0, 1};
        result = ContainsTwoSumToK.check(2, arr);
        assertThat(result).isEqualTo(true);

    }

}