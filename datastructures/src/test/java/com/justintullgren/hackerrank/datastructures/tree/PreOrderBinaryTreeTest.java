package com.justintullgren.hackerrank.datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;


public class PreOrderBinaryTreeTest {

    private PreOrderBinaryTree subject;

    @Before
    public void before() {
        subject = new PreOrderBinaryTree();
        subject.add(7);
        subject.add(6);
        subject.add(8);
        subject.add(5);
    }

    @Test
    public void testAdd() {
        BinaryNode root = subject.getRoot();
        BinaryNode currentNode = root;

        BinaryNode left = currentNode.getLeft();
        BinaryNode right = currentNode.getRight();

        assertThat(currentNode.getValue()).isEqualTo(7);
        assertThat(left.getValue()).isEqualTo(6);
        assertThat(right.getValue()).isEqualTo(8);

        currentNode = left;
        left = currentNode.getLeft();
        right = currentNode.getRight();

        assertThat(left.getValue()).isEqualTo(5);
        assertThat(right).isEqualTo(null);
    }

    @Test
    public void testPreOrderIterator() {
        Iterator<Integer> iterator = subject.iterator();
        int[] expectedOrder = {7, 6, 5, 8};
        int expectedIterationCount = expectedOrder.length;
        int index = 0;
        do {
            assertThat(iterator.next()).isEqualTo(expectedOrder[index]);
            index++;
        } while (iterator.hasNext());

        assertThat(index).isEqualTo(expectedIterationCount);
    }

}