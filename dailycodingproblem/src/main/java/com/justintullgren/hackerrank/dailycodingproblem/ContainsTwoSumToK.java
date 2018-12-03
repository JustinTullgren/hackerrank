package com.justintullgren.hackerrank.dailycodingproblem;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 */
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
