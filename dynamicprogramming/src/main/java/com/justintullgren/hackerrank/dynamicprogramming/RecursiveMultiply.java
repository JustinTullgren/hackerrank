package com.justintullgren.hackerrank.dynamicprogramming;

public class RecursiveMultiply {
    public static int multiply(int x, int y) {
        if (y == 0 || x == 0) {
            return 0;
        }
        if (y > 0) {
            return x + multiply(x, y - 1);
        }
        if (x < 0) {
            return -multiply(-x, y);
        } else {
            return -multiply(x, -y);
        }
    }
}
