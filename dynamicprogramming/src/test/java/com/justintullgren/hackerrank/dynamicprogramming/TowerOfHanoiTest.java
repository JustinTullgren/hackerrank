package com.justintullgren.hackerrank.dynamicprogramming;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;


public class TowerOfHanoiTest {

    @Test
    public void testSolve() {
        Stack<Integer> source = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
        int i = 5;
        while (--i >= 0) {
            source.push(i);
        }

        TowerOfHanoi.move(source.size(), source, destination, buffer);

        assertThat(source.isEmpty()).isEqualTo(true);
        assertThat(buffer.isEmpty()).isEqualTo(true);
        assertThat(destination.isEmpty()).isEqualTo(false);
        assertThat(destination.pop()).isEqualTo(0);
        assertThat(destination.pop()).isEqualTo(1);
        assertThat(destination.pop()).isEqualTo(2);
        assertThat(destination.pop()).isEqualTo(3);
        assertThat(destination.pop()).isEqualTo(4);
    }

}