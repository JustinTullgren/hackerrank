package com.justintullgren.hackerrank.dynamicprogramming;

import java.util.Stack;

public class TowerOfHanoi {
    public static void move(int numberOfDisks, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> buffer) {
        if (numberOfDisks > 0) {

            move(numberOfDisks - 1, source, buffer, destination);

            destination.push(source.pop());

            System.out.println("Source: " + source.toString() + "\nBuffer: " + buffer.toString() + "\nDestination: " + destination.toString() + "\n");

            move(numberOfDisks - 1, buffer, destination, source);
        }
    }
}
