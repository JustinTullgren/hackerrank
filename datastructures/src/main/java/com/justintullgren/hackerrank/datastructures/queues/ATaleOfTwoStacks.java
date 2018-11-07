package com.justintullgren.hackerrank.datastructures.queues;

import java.util.Stack;

/**
 * @see <a href="https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem">Problem</a>
 */
public class ATaleOfTwoStacks {

    static class MyQueue<T> {
        private Stack<T> oldestOnTop = new Stack<>();
        private Stack<T> newestOnTop = new Stack<>();

        public void enqueue(T value) {
            newestOnTop.push(value);
        }

        public T dequeue() {
            moveNewestIntoOldest();
            return oldestOnTop.pop();
        }

        public T peek() {
            moveNewestIntoOldest();
            return oldestOnTop.peek();
        }

        private void moveNewestIntoOldest() {
            if (oldestOnTop.isEmpty()) {
                while (!newestOnTop.isEmpty()) {
                    oldestOnTop.push(newestOnTop.pop());
                }
            }
        }
    }

    // region old
    static class Node<T> {
        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


    }

    static class MyQueueOld<T> {
        private Node<T> head;
        private Node<T> rear;

        public void enqueue(T value) {
            Node<T> node = new Node<>(value);
            if (rear == null) {
                head = rear = node;
            } else {
                rear.setNext(node);
                rear = node;
            }
        }

        public T dequeue() {
            if (head == null) {
                return null;
            }
            Node<T> node = head;
            head = head.getNext();
            if (head == null) {
                rear = null;
            }
            return node.getValue();
        }

        public T peek() {
            if (head != null) {
                return head.getValue();
            } else {
                return null;
            }

        }
    }
    // endregion
}
