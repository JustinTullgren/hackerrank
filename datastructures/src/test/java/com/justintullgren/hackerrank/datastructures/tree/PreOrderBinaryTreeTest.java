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
        subject.add(4);
        subject.add(1);
        subject.add(6);
        subject.add(5);
        subject.add(3);
        subject.add(2);
        subject.add(12);
        subject.add(9);
        subject.add(8);
        subject.add(10);


        /*
                        7
                       / \
                      4   -------12
                     / \         /\
           1---------   6       9
            \          /       / \
             3         5      8  10
            /
           2

           preOrder = 7,4,1,3,2,6,5,12,9,8,10
        */
    }

    @Test
    public void testAdd() {
        BinaryNode root = subject.getRoot();
        BinaryNode currentNode = root;

        BinaryNode left = currentNode.getLeft();
        BinaryNode right = currentNode.getRight();

        assertThat(currentNode.getValue()).isEqualTo(7);
        assertThat(left.getValue()).isEqualTo(4);
        assertThat(right.getValue()).isEqualTo(12);

        currentNode = left;
        left = currentNode.getLeft();
        right = currentNode.getRight();

        assertThat(left.getValue()).isEqualTo(1);
        assertThat(right.getValue()).isEqualTo(6);
    }

    @Test
    public void testPreOrderIterator() {
        Iterator<Integer> iterator = subject.iterator();
        int[] expectedOrder = {7, 4, 1, 3, 2, 6, 5, 12, 9, 8, 10};
        int expectedIterationCount = expectedOrder.length;
        int index = 0;
        do {
            assertThat(iterator.next()).isEqualTo(expectedOrder[index]);
            index++;
        } while (iterator.hasNext());

        assertThat(index).isEqualTo(expectedIterationCount);
    }

}