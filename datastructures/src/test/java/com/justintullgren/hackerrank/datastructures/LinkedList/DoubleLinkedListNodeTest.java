package com.justintullgren.hackerrank.datastructures.LinkedList;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleLinkedListNodeTest {

    @Test
    public void testAdd() {
        DoubleLinkedListNode<Integer> node = new DoubleLinkedListNode<>(1);
        node.add(2);
        node.add(3);
        System.out.println(node.toString());
    }

    @Test
    public void testFind() {
        DoubleLinkedListNode<Integer> node = new DoubleLinkedListNode<>(1);
        node.add(1);
        node.add(2);
        node.add(3);

        DoubleLinkedListNode<Integer> result = node.search(2);
        assertThat(result.getValue()).isEqualTo(2);

        result = node.search(3);
        assertThat(result.getValue()).isEqualTo(3);

        result = node.search(4);
        assertThat(result).isNull();
    }

    @Test
    public void testDelete() {
        DoubleLinkedListNode<Integer> node = new DoubleLinkedListNode<>(1);
        node.add(1);
        node.add(2);
        node.add(3);

        assertThat(node.size()).isEqualTo(4);

        DoubleLinkedListNode<Integer> result = node.search(2);
        node.delete(result);

        assertThat(node.size()).isEqualTo(3);
        result = node.search(2);
        assertThat(result).isNull();
    }

    @Test
    public void testRemoveDuplicates() {
        DoubleLinkedListNode<Integer> node = new DoubleLinkedListNode<>(1);
        node.add(1);
        node.add(2);
        node.add(3);

        assertThat(node.size()).isEqualTo(4);

        node.removeDuplicates();

        assertThat(node.size()).isEqualTo(3);
        System.out.println(node.toString());
    }

}