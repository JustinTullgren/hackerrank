package com.justintullgren.hackerrank.arrays;


import java.util.HashSet;
import java.util.Set;

public class ContainsTwoSumToK {
    public static boolean check(int sum, int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int remainder = sum - num;
            if (seen.contains(remainder)) {
                return true;
            } else {
                seen.add(num);
            }
        }

        return false;
    }
}
