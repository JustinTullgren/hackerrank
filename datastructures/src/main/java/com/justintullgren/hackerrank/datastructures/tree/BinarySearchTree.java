package com.justintullgren.hackerrank.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root = null;

    public void add(T value) {
        root = add(root, value);
    }

    public Node<T> search(T value) {
        return search(root, value);
    }

    public void delete(T value) {
        if (root == null) {
            return;
        }
        root = delete(root, value);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        print(root, sb);
        System.out.println(sb.toString());
    }

    public int distance(T x, T y) {
        if (root == null) {
            return -1;
        }

        Node<T> lca = findAncestor(x, y);
        if (lca == null) {
            return -1;
        }

        int ancestorDepth = findDepth(root, lca.getValue(), -1);
        int xDepth = findDepth(root, x, -1);
        int yDepth = findDepth(root, y, -1);

        return (xDepth + yDepth) - (2 * ancestorDepth);
    }

    private int findDepth(Node<T> root, T value, int depth) {
        if (root == null) {
            return depth;
        }
        T nodeVal = root.getValue();
        if (nodeVal.equals(value)) {
            return depth;
        }
        if (nodeVal.compareTo(value) > 0) {
            return findDepth(root.getLeft(), value, depth + 1);
        } else {
            return findDepth(root.getRight(), value, depth + 1);
        }
    }

    private Node<T> findAncestor(T x, T y) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            T value = node.getValue();
            if (x.compareTo(value) < 0
                    && y.compareTo(value) > 0) {
                return node;
            }
            if (x.compareTo(value) > 0
                    && y.compareTo(value) < 0) {
                return node;
            }
            if (x.equals(value)) {
                if (value.compareTo(y) > 0 && node.getLeft() != null) {
                    return node;
                }
                if (value.compareTo(y) < 0 && node.getRight() != null) {
                    return node;
                }
            }

            if (y.equals(value)) {
                if (value.compareTo(x) > 0 && node.getLeft() != null) {
                    return node;
                }
                if (value.compareTo(x) < 0 && node.getRight() != null) {
                    return node;
                }
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return null;
    }


    private void print(Node<T> root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.getValue())
                .append("\n");
        print(root.getLeft(), sb);
        print(root.getRight(), sb);
    }

    private Node<T> delete(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        if (value.equals(root.getValue())) {
            return (root.getLeft() != null) ? root.getLeft() : root.getRight();
        }

        root.setLeft(delete(root.getLeft(), value));
        root.setRight(delete(root.getRight(), value));

        return root;
    }

    private Node<T> search(Node<T> root, T value) {
        if (root == null) {
            return null;
        }
        if (value.equals(root.getValue())) {
            return root;
        }

        if (value.compareTo(root.getValue()) < 0) {
            return search(root.getLeft(), value);
        }
        if (value.compareTo(root.getValue()) > 0) {
            return search(root.getRight(), value);
        }
        return null;
    }

    private Node<T> add(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(add(root.getLeft(), value));
        }
        if (value.compareTo(root.getValue()) > 0) {
            root.setRight(add(root.getRight(), value));
        }
        return root;
    }

    public static class Node<V extends Comparable<V>> {
        private Node<V> left, right;
        private V value;

        public Node(V value) {
            this.value = value;
            left = right = null;
        }

        public Node<V> getLeft() {
            return left;
        }

        public void setLeft(Node<V> left) {
            this.left = left;
        }

        public Node<V> getRight() {
            return right;
        }

        public void setRight(Node<V> right) {
            this.right = right;
        }

        public V getValue() {
            return value;
        }
    }
}
