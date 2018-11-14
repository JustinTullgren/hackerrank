package com.justintullgren.hackerrank.datastructures.stacks;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NStackTest {
    private NStack<Integer> subject;

    @Before
    public void setup() {
        subject = new NStack<>(3);
    }

    @Test
    public void testPushPop() {
        subject.push(1, 0);
        subject.push(10, 0);
        int result = subject.pop(0);
        assertThat(result).isEqualTo(10);

        subject.push(20, 1);
        result = subject.pop(1);
        assertThat(result).isEqualTo(20);

        subject.push(20, 1);
        subject.push(22, 1);
        result = subject.pop(1);
        assertThat(result).isEqualTo(22);

        result = subject.pop(0);
        assertThat(result).isEqualTo(1);

        subject.clear();
    }

    @Test
    public void testPushPopGrowArray() {
        subject.push(1, 0);
        subject.push(10, 0);
        subject.push(100, 0);
        subject.push(2, 1);
        subject.push(20, 1);
        subject.push(200, 1);
        subject.push(3, 2);
        subject.push(30, 2);
        subject.push(300, 2);
        subject.push(3000, 2);

        assertThat(subject.size(0)).isEqualTo(3);
        assertThat(subject.size(1)).isEqualTo(3);
        assertThat(subject.size(2)).isEqualTo(4);
        assertThat(subject.peek(0)).isEqualTo(100);
        assertThat(subject.peek(1)).isEqualTo(200);
        assertThat(subject.peek(2)).isEqualTo(3000);

        subject.push(2000, 1);
        subject.push(20000, 1);
        assertThat(subject.size(1)).isEqualTo(5);

        int result = subject.pop(0);
        assertThat(result).isEqualTo(100);

        result = subject.pop(0);
        assertThat(result).isEqualTo(10);

        result = subject.pop(0);
        assertThat(result).isEqualTo(1);
        assertThat(subject.size(0)).isEqualTo(0);

        result = subject.pop(2);
        assertThat(result).isEqualTo(3000);


    }

}