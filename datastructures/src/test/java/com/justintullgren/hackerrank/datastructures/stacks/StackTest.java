package com.justintullgren.hackerrank.datastructures.stacks;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest {

    private Stack<Integer> subject;

    @Before
    public void setup() {
        subject = new Stack<>();
    }

    @Test
    public void testPushPeek() {
        assertThat(subject.getDepth()).isEqualTo(0);

        subject.push(1);
        assertThat(subject.peek()).isEqualTo(1);
        subject.push(2);
        assertThat(subject.peek()).isEqualTo(2);

        assertThat(subject.getDepth()).isEqualTo(2);

        subject.push(2);
        subject.push(2);
        subject.push(2);
        subject.push(2);
        subject.push(2);
        subject.push(2);
        subject.push(2);
        subject.push(2);
        subject.push(20);
        assertThat(subject.getDepth()).isEqualTo(11);
        assertThat(subject.peek()).isEqualTo(20);
    }

    @Test
    public void testPushPop() {
        subject.push(1);
        assertThat(subject.pop()).isEqualTo(1);
        assertThat(subject.getDepth()).isEqualTo(0);

        subject.push(1);
        subject.push(2);
        System.out.println(subject.toString());
        assertThat(subject.pop()).isEqualTo(2);
        assertThat(subject.getDepth()).isEqualTo(1);

        System.out.println(subject.toString());
    }

}