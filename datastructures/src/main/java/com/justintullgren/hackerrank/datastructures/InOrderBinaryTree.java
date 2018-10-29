package com.justintullgren.hackerrank.datastructures;

import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

public class InOrderBinaryTree implements Iterable<Integer> {
    private BinaryNode root;

    public BinaryNode add(int value) {
        root = add(root, value);
        return root;
    }

    BinaryNode getRoot() {
        return root;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new InOrderIterator(root);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        throw new NotImplementedException();
    }

    private BinaryNode add(BinaryNode root, int value) {
        if (root == null) {
            return new BinaryNode(value);
        } else if (value < root.value) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }


    class BinaryNode {
        private BinaryNode left;
        private BinaryNode right;

        private int value;

        BinaryNode(int value) {
            this.value = value;
            left = right = null;
        }

        BinaryNode getLeft() {
            return left;
        }

        BinaryNode getRight() {
            return right;
        }

        int getValue() {
            return value;
        }
    }

    private class InOrderIterator implements Iterator<Integer> {
        private Stack<BinaryNode> stack;

        InOrderIterator(BinaryNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            BinaryNode node = stack.pop();
            Integer result = node.value;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }
}
