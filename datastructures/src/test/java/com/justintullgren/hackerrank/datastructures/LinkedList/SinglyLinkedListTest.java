package com.justintullgren.hackerrank.datastructures.LinkedList;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> subject;

    @Before
    public void before() {
        subject = new SinglyLinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        subject.add(1);
        subject.add(2);
        assertThat(subject.size()).isEqualTo(2);
        subject.add(3);
        assertThat(subject.size()).isEqualTo(3);
        assertThat(subject.first()).isEqualTo(1);
        assertThat(subject.last()).isEqualTo(3);

        System.out.println(subject.toString());
    }

    @Test
    public void testRemove() {
        subject.add(1);
        subject.remove(1);
        assertThat(subject.size()).isEqualTo(0);

        subject.clear();

        subject.add(1);
        subject.add(2);
        subject.remove(2);
        assertThat(subject.first()).isEqualTo(1);
        assertThat(subject.last()).isEqualTo(1);

        subject.clear();

        subject.add(1);
        subject.add(2);
        subject.remove(1);
        assertThat(subject.first()).isEqualTo(2);
        assertThat(subject.last()).isEqualTo(2);

        subject.clear();

        subject.add(1);
        subject.add(2);
        subject.add(3);
        assertThat(subject.size()).isEqualTo(3);

        subject.remove(2);
        assertThat(subject.size()).isEqualTo(2);
        assertThat(subject.toString().contains("2")).isEqualTo(false);

        subject.clear();

        subject.add(1);
        subject.add(2);
        subject.add(3);
        subject.remove(3);
        assertThat(subject.last()).isEqualTo(2);
        assertThat(subject.first()).isEqualTo(1);

        assertThat(subject.toString().contains("3")).isEqualTo(false);

        System.out.println(subject.toString());
    }

    @Test
    public void testGet() {
        subject.add(0);
        subject.add(1);
        subject.add(2);
        subject.add(20);
        subject.add(40);
        subject.add(50);
        subject.add(60);
        subject.add(70);

        assertThat(subject.get(0)).isEqualTo(0);
        assertThat(subject.get(1)).isEqualTo(1);
        assertThat(subject.get(2)).isEqualTo(2);
        assertThat(subject.get(3)).isEqualTo(20);
        assertThat(subject.get(100)).isEqualTo(null);
    }

    @Test
    public void testRemoveDuplicatesRecursive() {
        subject.add(5);
        subject.add(5);
        subject.add(1);
        subject.add(2);
        subject.add(4);
        subject.add(3);
        subject.add(2);
        subject.add(1);

        subject.removeDuplicatesRecursive();

        assertThat(subject.get(0)).isEqualTo(5);
        assertThat(subject.get(1)).isEqualTo(1);
        assertThat(subject.get(2)).isEqualTo(2);
        assertThat(subject.get(3)).isEqualTo(4);
        assertThat(subject.get(4)).isEqualTo(3);
        assertThat(subject.size()).isEqualTo(5);
    }

    @Test
    public void testRemoveDuplicatesIteration() {
        subject.add(5);
        subject.add(5);
        subject.add(1);
        subject.add(2);
        subject.add(4);
        subject.add(3);
        subject.add(2);
        subject.add(1);

        subject.removeDuplicatesIteration();

        assertThat(subject.get(0)).isEqualTo(5);
        assertThat(subject.get(1)).isEqualTo(1);
        assertThat(subject.get(2)).isEqualTo(2);
        assertThat(subject.get(3)).isEqualTo(4);
        assertThat(subject.get(4)).isEqualTo(3);
        assertThat(subject.size()).isEqualTo(5);
    }

    @Test(expected = IllegalStateException.class)
    public void testReturnKthToLastRecursive() {
        subject.add(1);
        subject.add(2);
        subject.add(3);
        subject.add(4);
        subject.add(5);
        subject.add(6);
        subject.add(7);
        subject.add(8);

        int value = subject.getKthToLastRecursive(7);
        assertThat(value).isEqualTo(1);

        value = subject.getKthToLastRecursive(1);
        assertThat(value).isEqualTo(7);

        // throw
        value = subject.getKthToLastRecursive(10);
    }

    @Test(expected = IllegalStateException.class)
    public void testReturnKthToLastIterative() {
        subject.add(1);
        subject.add(2);
        subject.add(3);
        subject.add(4);
        subject.add(5);
        subject.add(6);
        subject.add(7);
        subject.add(8);

        int value = subject.getKthToLastIterative(7);
        assertThat(value).isEqualTo(1);

        value = subject.getKthToLastRecursive(1);
        assertThat(value).isEqualTo(7);

        // throw
        value = subject.getKthToLastRecursive(10);
    }
}