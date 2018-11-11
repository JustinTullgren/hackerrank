package com.justintullgren.hackerrank.datastructures.stacks;

import com.justintullgren.hackerrank.datastructures.IStack;

import java.util.Arrays;

public class Stack<T> implements IStack<T> {
    private Object[] array = new Object[10];

    private int depth = 0;


    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void push(T item) {
        if (depth >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[depth] = item;
        depth++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        T value = (T) array[depth - 1];
        array[--depth] = null;
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) array[depth - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
