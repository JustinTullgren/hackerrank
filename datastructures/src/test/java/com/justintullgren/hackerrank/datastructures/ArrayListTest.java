package com.justintullgren.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayListTest {

    private ArrayList<Integer> subject;

    @Before
    public void before() {
        subject = new ArrayList<>();
    }

    @Test
    public void testAddSize() {
        subject.add(1);
        subject.add(2);
        subject.add(1);
        assertThat(subject.size()).isEqualTo(3);
        subject.add(2);
        assertThat(subject.size()).isEqualTo(4);
    }

    @Test
    public void testAddGet() {
        subject.add(1);
        subject.add(20);
        assertThat(subject.size()).isEqualTo(2);
        assertThat(subject.get(0)).isEqualTo(1);
        assertThat(subject.get(1)).isEqualTo(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(40);
        assertThat(subject.get(10)).isEqualTo(40);
    }

    @Test
    public void testGetBadIndex() {
        subject.add(1);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        subject.add(20);
        assertThat(subject.get(10)).isEqualTo(null);
        assertThat(subject.get(11)).isEqualTo(null);
        assertThat(subject.get(1000)).isEqualTo(null);
    }

    @Test
    public void testAddRemoveSize() {
        subject.add(1);
        subject.add(2);
        assertThat(subject.size()).isEqualTo(2);
        subject.remove(0);
        assertThat(subject.size()).isEqualTo(1);
        assertThat(subject.get(0)).isEqualTo(2);
    }

    @Test
    public void testClear() {
        subject.add(1);
        subject.add(2);
        assertThat(subject.size()).isEqualTo(2);
        subject.clear();
        assertThat(subject.size()).isEqualTo(0);
        assertThat(subject.get(1)).isEqualTo(null);
    }

}