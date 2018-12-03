package com.justintullgren.hackerrank.datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a tree, link the nodes on each level from left to right.
 * Example:
 * a->null
 * /  \
 * b->->c->null
 * /\   /\
 * d->e->f->g->null
 */
public class LinkNodesInTree {

    public static BinaryLinkNode linkNodes(BinaryLinkNode root) {
        Queue<BinaryLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            BinaryLinkNode node = queue.remove();
            if (node != null) {
                node.next = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else if (!queue.isEmpty()) {
                queue.add(null);
            }

        }
        return root;
    }

    public static class BinaryLinkNode {
        public final int value;
        public BinaryLinkNode next;
        public BinaryLinkNode left;
        public BinaryLinkNode right;

        public BinaryLinkNode(int value) {
            this.value = value;
            next = left = right = null;
        }
    }
}
