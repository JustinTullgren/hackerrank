package com.justintullgren.hackerrank.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;


public class InOrderBinaryTreeTest {

    private InOrderBinaryTree subject;

    @Before
    public void before() {
        subject = new InOrderBinaryTree();
        subject.add(7);
        subject.add(6);
        subject.add(8);
        subject.add(5);
    }

    @Test
    public void testAdd() {
        InOrderBinaryTree.BinaryNode root = subject.getRoot();
        InOrderBinaryTree.BinaryNode currentNode = root;

        InOrderBinaryTree.BinaryNode left = currentNode.getLeft();
        InOrderBinaryTree.BinaryNode right = currentNode.getRight();

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
    public void testInOrderIterator() {
        Iterator<Integer> iterator = subject.iterator();
        int[] expectedOrder = {5, 6, 7, 8};
        int expectedIterationCount = expectedOrder.length;
        int index = 0;
        do {
            assertThat(iterator.next()).isEqualTo(expectedOrder[index]);
            index++;
        } while (iterator.hasNext());

        assertThat(index).isEqualTo(expectedIterationCount);
    }

}