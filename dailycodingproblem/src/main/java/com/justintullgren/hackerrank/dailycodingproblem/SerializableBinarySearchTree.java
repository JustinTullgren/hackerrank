package com.justintullgren.hackerrank.dailycodingproblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializableBinarySearchTree {
    private Node root = null;

    public void add(String value) {
        this.root = add(root, value);
    }

    public String serialize() {
        StringBuilder stringBuilder = new StringBuilder();
        serialize(root, stringBuilder);

        return stringBuilder.toString();
    }

    private void serialize(Node root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("?").append(",");
            return;
        }
        stringBuilder.append(root.getValue()).append(",");
        serialize(root.getLeft(), stringBuilder);
        serialize(root.getRight(), stringBuilder);
    }


    private Node add(Node root, String value) {
        Node node = new Node(value);
        if (root == null) {
            return node;
        }
        if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(add(root.getLeft(), value));
        } else {
            root.setRight(add(root.getRight(), value));
        }

        return root;
    }

    public Node deserialize(String serializedTree) {
        String[] values = serializedTree.split(",");
        Queue<String> valuesQueue = new LinkedList<>(Arrays.asList(values));
        return deserialize(valuesQueue);
    }

    private Node deserialize(Queue<String> valuesQueue) {
        if (!valuesQueue.isEmpty()) {
            String value = valuesQueue.remove();
            if (value.equals("?")) {
                return null;
            }
            Node node = new Node(value);
            node.setLeft(deserialize(valuesQueue));
            node.setRight(deserialize(valuesQueue));
            return node;
        }
        return null;
    }

    public static class Node {
        private Node left = null;
        private Node right = null;
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
