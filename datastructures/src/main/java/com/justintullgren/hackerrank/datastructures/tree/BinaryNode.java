package com.justintullgren.hackerrank.datastructures.tree;

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

    void setLeft(BinaryNode left) {
        this.left = left;
    }

    BinaryNode getRight() {
        return right;
    }

    void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }
}
