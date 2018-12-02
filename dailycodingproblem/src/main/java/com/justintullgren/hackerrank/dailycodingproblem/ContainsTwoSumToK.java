package com.justintullgren.hackerrank.dailycodingproblem;


import java.util.HashSet;
import java.util.Set;

public class ContainsTwoSumToK {
    public static boolean check(int sum, int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int num, remainder;
        for (int i = 0; i < arr.length; i++) {
            num = arr[i];
            remainder = sum - num;
            if (remainder >= 0 && seen.contains(remainder)) {
                return true;
            } else {
                seen.add(num);
            }
        }

        return false;
    }
}
