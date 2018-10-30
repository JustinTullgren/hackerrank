package com.justintullgren.hackerrank.datastructures.tree;

import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

public class InOrderBinaryTree implements Iterable<Integer> {
    private BinaryNode root;

    public void add(int value) {
        root = add(root, value);
    }

    public BinaryNode getRoot() {
        return root;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new InOrderIterator(root);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (Integer integer : this) {
            action.accept(integer);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        throw new NotImplementedException();
    }

    private BinaryNode add(BinaryNode root, int value) {
        if (root == null) {
            return new BinaryNode(value);
        } else if (value < root.getValue()) {
            root.setLeft(add(root.getLeft(), value));
        } else {
            root.setRight(add(root.getRight(), value));
        }
        return root;
    }


    private class InOrderIterator implements Iterator<Integer> {
        private Stack<BinaryNode> stack;

        InOrderIterator(BinaryNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            BinaryNode node = stack.pop();
            Integer result = node.getValue();
            if (node.getRight() != null) {
                node = node.getRight();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
            return result;
        }
    }
}
