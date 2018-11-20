package com.justintullgren.hackerrank.datastructures.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DoubleLinkedListNode<T extends Comparable<T>> {
    private DoubleLinkedListNode head, tail;
    private T value;

    public DoubleLinkedListNode(T value) {
        this.value = value;
        this.head = tail = null;
    }

    public T getValue() {
        return this.value;
    }

    public void add(T value) {
        if (tail != null) {
            tail.add(value);
        } else {
            tail = new DoubleLinkedListNode(value);
            tail.head = this;
        }
    }

    public DoubleLinkedListNode<T> search(T value) {
        if (this.value.equals(value)) {
            return this;
        } else if (tail != null) {
            return tail.search(value);
        } else {
            return null;
        }
    }

    public void delete(DoubleLinkedListNode<T> node) {
        if (node == this) {
            if (head != null) {
                head.tail = tail;
            }
            if (tail != null) {
                tail.head = head;
            }
        } else if (tail != null) {
            tail.delete(node);
        }

    }

    public void removeDuplicates() {
        Set<T> seen = new HashSet<>();
        removeDuplicates(this, seen);
    }

    private void removeDuplicates(DoubleLinkedListNode<T> node, Set<T> seen) {
        if (node == null) {
            return;
        }
        if (!seen.add(node.value)) {
            if (node.head != null) {
                node.head.tail = node.tail;
            }
            if (node.tail != null) {
                node.tail.head = node.head;
            }

        }
        removeDuplicates(node.tail, seen);
    }

    public int size() {
        int result = 0;
        DoubleLinkedListNode node = this;
        while (node != null) {
            result++;
            node = node.tail;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleLinkedListNode current = this;
        while (current != null) {
            sb.append("{");
            if (current.head != null) {
                sb.append(" head: " + String.valueOf(current.head.getValue()));
            }
            sb.append(" value: " + String.valueOf(current.value));
            if (current.tail != null) {
                sb.append(" tail: " + String.valueOf(current.tail.getValue()));
            }
            sb.append("}");
            current = current.tail;
        }
        return sb.toString();
    }

}
