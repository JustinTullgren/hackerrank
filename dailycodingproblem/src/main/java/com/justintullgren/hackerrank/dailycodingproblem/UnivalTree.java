package com.justintullgren.hackerrank.dailycodingproblem;


public class UnivalTree {
    public static int count(Node root) {
        return counter(root).count;
    }

    private static Pair counter(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair left = counter(root.left);
        Pair right = counter(root.right);
        int totalCount = left.count + right.count;
        if (left.isUnival && right.isUnival) {
            if (root.left != null && root.left.value != root.value) {
                return new Pair(false, totalCount);
            }
            if (root.right != null && root.right.value != root.value) {
                return new Pair(false, totalCount);
            }
            return new Pair(true, totalCount + 1);

        }
        return new Pair(false, totalCount);
    }

    private static class Pair {
        final int count;
        final boolean isUnival;

        Pair(boolean isUnival, int count) {
            this.count = count;
            this.isUnival = isUnival;
        }
    }


    public static class Node {
        public final int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
