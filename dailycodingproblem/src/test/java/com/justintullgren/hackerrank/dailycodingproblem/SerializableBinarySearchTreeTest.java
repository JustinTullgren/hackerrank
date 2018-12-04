package com.justintullgren.hackerrank.dailycodingproblem;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializableBinarySearchTreeTest {

    private SerializableBinarySearchTree subject;

    @Before
    public void before() {
        subject = new SerializableBinarySearchTree();
        subject.add("D");
        subject.add("B");
        subject.add("A");
        subject.add("C");
        subject.add("F");
        subject.add("E");
        subject.add("G");
        /*
                      D
                   /     \
                  B       F
                 / \     / \
                A   C   E   G
         */
    }

    @Test
    public void testSerializeBreadthFirst() {
        String result = subject.serialize();
        assertThat(result)
                .isEqualToIgnoringNewLines("D");
    }

    @Test
    public void testDeserialize() {
        SerializableBinarySearchTree.Node node = subject.deserialize(subject.serialize());
        assertThat(node.getLeft().getLeft().getValue()).isEqualTo("A");
        assertThat(node.getRight().getRight().getValue()).isEqualTo("G");
        assertThat(node.getRight().getRight().getRight()).isNull();
    }

}