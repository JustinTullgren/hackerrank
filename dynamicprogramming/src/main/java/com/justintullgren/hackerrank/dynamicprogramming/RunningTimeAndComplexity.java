package com.justintullgren.hackerrank.dynamicprogramming;

public class RunningTimeAndComplexity {
    public static void main(String[] args) {

        boolean isPrime = isPrime(4);
        System.out.println(isPrime);

    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (isEven(number)) {
            return false;
        }
        int i = 1;
        while (i++ < Math.sqrt(number)) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isEven(int number) {
        return (number & 1) == 0;
    }


}
