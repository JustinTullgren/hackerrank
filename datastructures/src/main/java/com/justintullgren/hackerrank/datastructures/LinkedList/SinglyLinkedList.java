package com.justintullgren.hackerrank.datastructures.LinkedList;

import java.util.HashSet;

public class SinglyLinkedList<T> {

    private Node<T> last;
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (last == null) {
            head = last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public int size() {
        return size;
    }

    public T first() {
        return head.value;
    }

    public T last() {
        return last.value;
    }

    public void remove(T value) {
        if (head.value == value) {
            head = head.next;
            if (head == null) {
                last = null;
            }
        } else {
            Node<T> node = head;
            while (node.next != null) {
                if (node.next.value == value) {
                    if (node.next == last) {
                        last = node;
                        last.next = null;
                    } else {
                        node.next = node.next.next;
                    }
                    break;
                }
                node = node.next;
            }
        }

        size--;
    }

    public void clear() {
        size = 0;
        head = last = null;
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        int count = 0;
        Node<T> current = head;
        while (count++ != index) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(size);
        Node<T> node = head;
        while (node != null) {
            sb.append("{ " + String.valueOf(node.value) + " }");
            node = node.next;
        }
        return sb.toString();
    }

    public void removeDuplicatesRecursive() {
        HashSet<T> seen = new HashSet<>();
        seen.add(head.value);
        removeDuplicatesRecursive(head, head.next, seen);
    }

    private void removeDuplicatesRecursive(Node<T> last, Node<T> node, HashSet<T> seen) {
        if (last == null || node == null) {
            return;
        }
        if (!seen.add(node.value)) {
            last.next = node.next;
            size--;
            removeDuplicatesRecursive(last, last.next, seen);
        } else {
            removeDuplicatesRecursive(node, node.next, seen);
        }
    }

    public void removeDuplicatesIteration() {
        Node<T> current = head;
        while (current != null) {
            Node<T> runner = current;
            while (runner.next != null) {
                if (current.value == runner.next.value) {
                    runner.next = runner.next.next;
                    size--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public T getKthToLastRecursive(int numberUntilLast) {
        if (head == null) {
            return null;
        }
        return getKthToLastRecursive(head, head, numberUntilLast, 0);
    }

    private T getKthToLastRecursive(Node<T> root, Node<T> kth, int numberUntilLast, int distance) {
        // at end
        if (root.next == null && distance == numberUntilLast) {
            return kth.value;
        } else if (root.next == null) {
            throw new IllegalStateException("Invalid Distance");
        } else if (distance != numberUntilLast) {
            return getKthToLastRecursive(root.next, kth, numberUntilLast, distance + 1);
        } else {
            return getKthToLastRecursive(root.next, kth.next, numberUntilLast, distance);
        }
    }

    public T getKthToLastIterative(int numberUntilLast) {
        Node<T> current = head;
        int distance = 0;
        Node<T> kth = head;
        while (current != null) {
            if (current.next == null && distance != numberUntilLast) {
                throw new IllegalStateException("Invalid Distance");
            } else if (current.next == null) {
                return kth.value;
            } else if (distance == numberUntilLast) {
                kth = kth.next;
            }

            current = current.next;
        }

        return null;
    }


    static class Node<V> {
        Node<V> next;
        V value;

        Node(V value) {
            this.value = value;
        }
    }
}
