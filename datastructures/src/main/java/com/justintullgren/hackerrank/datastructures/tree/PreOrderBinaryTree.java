package com.justintullgren.hackerrank.datastructures.tree;

import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

public class PreOrderBinaryTree implements Iterable<Integer> {
    private BinaryNode root;

    public BinaryNode getRoot() {
        return root;
    }

    public void add(int value) {
        root = add(root, value);
    }

    private BinaryNode add(BinaryNode root, int value) {
        if (root == null) {
            root = new BinaryNode(value);
        } else if (value < root.getValue()) {
            root.setLeft(add(root.getLeft(), value));
        } else {
            root.setRight(add(root.getRight(), value));
        }
        return root;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new PreOrderIterator(root);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (Integer it : this) {
            action.accept(it);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        throw new NotImplementedException();
    }

    private class PreOrderIterator implements Iterator<Integer> {
        private Stack<BinaryNode> stack;

        PreOrderIterator(BinaryNode root) {
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            BinaryNode node = stack.pop();
            Integer value = node.getValue();
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            return value;
        }
    }
}
