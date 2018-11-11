package com.justintullgren.hackerrank.datastructures.LinkedList;

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

    static class Node<V> {
        Node<V> next;
        V value;

        Node(V value) {
            this.value = value;
        }
    }
}
