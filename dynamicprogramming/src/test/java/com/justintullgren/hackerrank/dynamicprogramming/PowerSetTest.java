package com.justintullgren.hackerrank.dynamicprogramming;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerSetTest {
    private static final ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1, 2, 3));
    private static final ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

    static {
        subsets.add(new ArrayList<>());
        subsets.add(new ArrayList<>(Arrays.asList(1)));
        subsets.add(new ArrayList<>(Arrays.asList(1, 2)));
        subsets.add(new ArrayList<>(Arrays.asList(1, 3)));
        subsets.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        subsets.add(new ArrayList<>(Arrays.asList(2)));
        subsets.add(new ArrayList<>(Arrays.asList(2, 3)));
        subsets.add(new ArrayList<>(Arrays.asList(3)));
    }

    @Test
    public void testComputeSubSets() {
        ArrayList<ArrayList<Integer>> result = PowerSet.compute(set);
        assertThat(result.size()).isEqualTo(subsets.size());
    }

}