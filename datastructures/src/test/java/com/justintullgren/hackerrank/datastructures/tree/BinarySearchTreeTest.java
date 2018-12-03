package com.justintullgren.hackerrank.datastructures.tree;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> subject;

    @Before
    public void before() {
        subject = new BinarySearchTree<>();
    }

    @Test
    public void testAdd() {
        subject.add(3);
        subject.add(1);
        subject.add(2);
        subject.add(6);
        subject.add(5);
        subject.add(7);
        /*
                     3
                    / \
                   1   ------6
                    \       / \
                     2     5   7
         */
        subject.print();

        int distance = subject.distance(7, 2);
        assertThat(distance).isEqualTo(4);

        distance = subject.distance(1, 2);
        assertThat(distance).isEqualTo(1);

        BinarySearchTree.Node<Integer> result = subject.search(1);

        assertThat(result.getValue()).isEqualTo(1);
        assertThat(result.getRight().getValue()).isEqualTo(2);

        subject.delete(1);

        result = subject.search(1);

        assertThat(result).isNull();

        result = subject.search(3);

        assertThat(result.getLeft().getValue()).isEqualTo(2);

    }

}