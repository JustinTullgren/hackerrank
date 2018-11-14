package com.justintullgren.hackerrank.datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BinarySearchTreeNodeTest {

    private BinarySearchTreeNode<Integer> subject;

    @Before
    public void setup() {
        subject = new BinarySearchTreeNode<>(10);
    }

    @Test
    public void testAdd() {
        subject.add(9);
        subject.add(11);

        assertThat(subject.toString()).isEqualTo("{ 9 }{ 10 }{ 11 }");

        subject.add(8);
        subject.add(12);

        assertThat(subject.toString()).isEqualTo("{ 8 }{ 9 }{ 10 }{ 11 }{ 12 }");
    }

    @Test
    public void testFind() {
        subject.add(9);
        subject.add(11);
        subject.add(8);
        subject.add(12);

        BinarySearchTreeNode<Integer> result = subject.find(12);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(12);

        result = subject.find(30);
        assertThat(result).isNull();
    }

    @Test
    public void testCreateFromSorted() {
        Integer[] sorted = {8, 9, 10, 11, 12};
        BinarySearchTreeNode<Integer> root = BinarySearchTreeNode.createFromSorted(sorted);

        assertThat(root).isNotNull();
        assertThat(root.getValue()).isEqualTo(10);
        assertThat(root.toString()).isEqualTo("{ 8 }{ 9 }{ 10 }{ 11 }{ 12 }");
    }
}