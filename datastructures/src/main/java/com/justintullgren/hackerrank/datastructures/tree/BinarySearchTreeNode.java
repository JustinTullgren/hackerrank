package com.justintullgren.hackerrank.datastructures.tree;

public class BinarySearchTreeNode<T extends Comparable<T>> {
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;
    private T value;

    public BinarySearchTreeNode(T value) {
        this.value = value;
    }

    public static <D extends Comparable<D>> BinarySearchTreeNode<D> createFromSorted(D[] sorted) {
        int midpoint = (sorted.length - 1) / 2;
        D rootValue = sorted[midpoint];
        BinarySearchTreeNode<D> root = new BinarySearchTreeNode<>(rootValue);
        for (int i = 0; i < midpoint; i++) {
            root.add(sorted[i]);
        }
        for (int i = midpoint + 1; i < sorted.length; i++) {
            root.add(sorted[i]);
        }
        return root;
    }

    public T getValue() {
        return value;
    }

    public BinarySearchTreeNode<T> getLeft() {
        return left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return right;
    }

    public void add(T value) {
        if (value.compareTo(this.value) < 0) {
            if (left == null) {
                left = new BinarySearchTreeNode<>(value);
            } else {
                left.add(value);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTreeNode<>(value);
            } else {
                right.add(value);
            }
        }
    }

    public BinarySearchTreeNode<T> find(T value) {
        if (value.compareTo(this.value) == 0) {
            return this;
        }
        BinarySearchTreeNode<T> maybeLeft = null;
        BinarySearchTreeNode<T> maybeRight = null;

        if (left != null) {
            maybeLeft = left.find(value);
        }

        if (maybeLeft != null) {
            return maybeLeft;
        }

        if (right != null) {
            maybeRight = right.find(value);
        }
        return maybeRight;
    }

    public void print() {
        if (left != null) {
            left.print();
        }
        System.out.print("{ " + String.valueOf(value) + " }");
        if (right != null) {
            right.print();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    private void toString(StringBuilder sb) {
        if (left != null) {
            left.toString(sb);
        }
        sb.append("{ " + String.valueOf(value) + " }");
        if (right != null) {
            right.toString(sb);
        }
    }

}
