package com.justintullgren.hackerrank.datastructures;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LinkNodesInTreeTest {

    @Test
    public void testLink() {
        LinkNodesInTree.BinaryLinkNode root = new LinkNodesInTree.BinaryLinkNode(5);
        root.left = new LinkNodesInTree.BinaryLinkNode(2);
        root.left.left = new LinkNodesInTree.BinaryLinkNode(1);
        root.left.right = new LinkNodesInTree.BinaryLinkNode(3);
        root.right = new LinkNodesInTree.BinaryLinkNode(7);
        root.right.left = new LinkNodesInTree.BinaryLinkNode(6);
        root.right.right = new LinkNodesInTree.BinaryLinkNode(8);

        root = LinkNodesInTree.linkNodes(root);

        assertThat(root).isNotNull();
        assertThat(root.next).isNull();

        assertThat(root.left.next).isEqualTo(root.right);
        assertThat(root.right.next).isNull();

        assertThat(root.left.left.next).isEqualTo(root.left.right);
        assertThat(root.left.right.next).isEqualTo(root.right.left);
        assertThat(root.right.left.next).isEqualTo(root.right.right);
        assertThat(root.right.right.next).isNull();
    }

}