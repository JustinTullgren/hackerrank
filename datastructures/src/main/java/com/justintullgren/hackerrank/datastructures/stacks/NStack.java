package com.justintullgren.hackerrank.datastructures.stacks;

import java.util.Arrays;

public class NStack<T> {
    private static final int ALLOCATED_SPACE = 2;
    private final StackInfo[] stackInfos;
    private Object[] array = new Object[10];


    public NStack(int numberOfStacks) {
        stackInfos = new StackInfo[numberOfStacks];
        clearStackInfo();
    }

    public void push(T item, int stackIndex) {
        StackInfo info = stackInfos[stackIndex];
        int index = info.startIndex + info.size;
        // if last stack
        if (stackIndex == stackInfos.length - 1 && index >= array.length) {
            doubleArray();
        } else if (
                ((stackIndex + 1) <= (stackInfos.length - 1))
                        &&
                        (index >= stackInfos[stackIndex + 1].startIndex)) {
            shiftStacks();
            info = stackInfos[stackIndex];
            index = info.startIndex + info.size;
        }

        array[index] = item;
        info.size++;
    }

    private void shiftStacks() {
        int minimumLength = 0;
        StackInfo[] newStackInfos = new StackInfo[stackInfos.length];
        for (int i = 0; i < stackInfos.length; i++) {
            StackInfo info = stackInfos[i];
            if (i == 0) {
                newStackInfos[i] = info;
            } else {
                StackInfo previous = stackInfos[i - 1];
                StackInfo newInfo = new StackInfo(previous.startIndex + previous.size + ALLOCATED_SPACE, info.size);
                newStackInfos[i] = newInfo;

            }
            minimumLength += info.size + ALLOCATED_SPACE;
        }

        if (minimumLength >= array.length) {
            doubleArray();
        }

        for (int i = stackInfos.length - 1; i >= 0; i--) {
            StackInfo info = stackInfos[i];
            StackInfo newInfo = newStackInfos[i];
            System.arraycopy(array, info.startIndex, array, newInfo.startIndex, info.size);
            stackInfos[i] = newInfo;
        }
    }

    private void doubleArray() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @SuppressWarnings("unchecked")
    public T pop(int stackIndex) {
        int index = getPeekPopIndex(stackIndex);
        T value = (T) array[index];
        array[index] = null;
        stackInfos[stackIndex].size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek(int stackIndex) {
        int index = getPeekPopIndex(stackIndex);
        return (T) array[index];
    }

    public void clear() {
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = null;
        }
        clearStackInfo();
    }

    public int size(int stackIndex) {
        return stackInfos[stackIndex].size;
    }

    private int getPeekPopIndex(int stackIndex) {
        StackInfo info = stackInfos[stackIndex];
        return info.startIndex + info.size - 1;
    }

    private void clearStackInfo() {
        for (int i = 0; i < stackInfos.length; i++) {
            stackInfos[i] = new StackInfo(i * ALLOCATED_SPACE, 0);
        }
    }

    private static class StackInfo {
        int size;
        int startIndex;

        StackInfo(final int startIndex, final int size) {
            this.startIndex = startIndex;
            this.size = size;
        }
    }

}
