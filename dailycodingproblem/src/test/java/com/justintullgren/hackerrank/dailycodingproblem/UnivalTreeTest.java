package com.justintullgren.hackerrank.dailycodingproblem;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnivalTreeTest {

    @Test
    public void test() {
        UnivalTree.Node root = new UnivalTree.Node(0);
        UnivalTree.Node left = new UnivalTree.Node(1);
        UnivalTree.Node right = new UnivalTree.Node(0);
        root.left = left;
        root.right = right;

        root.right.left = new UnivalTree.Node(1);
        root.right.left.left = new UnivalTree.Node(1);
        root.right.left.right = new UnivalTree.Node(1);
        root.right.right = new UnivalTree.Node(0);

        int result = UnivalTree.count(root);
        assertThat(result).isEqualTo(5);

    }

}