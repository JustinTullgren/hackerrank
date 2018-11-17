package com.justintullgren.hackerrank.dynamicprogramming;

import java.util.ArrayList;

public class PowerSet {
    public static ArrayList<ArrayList<Integer>> compute(ArrayList<Integer> set) {
        return compute(set, 0);
    }

    private static ArrayList<ArrayList<Integer>> compute(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> subsets;
        if (index == set.size()) {
            subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
        } else {
            subsets = compute(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> itemSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : subsets) {
                ArrayList<Integer> moreSubsets = new ArrayList<>();
                moreSubsets.addAll(subset);
                moreSubsets.add(item);
                itemSubsets.add(moreSubsets);
            }
            subsets.addAll(itemSubsets);
        }
        return subsets;
    }
}
