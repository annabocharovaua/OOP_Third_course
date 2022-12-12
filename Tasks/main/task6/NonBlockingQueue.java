package org.example.task6;

import java.util.concurrent.atomic.AtomicReference;

public class NonBlockingQueue<T> {
    private final AtomicReference<Node<T>> head;
    private final AtomicReference<Node<T>> tail;

    public NonBlockingQueue() {
        Node<T> dummyNode = new Node<T>();
        this.head = new AtomicReference<Node<T>> (dummyNode);
        this.tail = new AtomicReference<Node<T>> (dummyNode);
    }

    private static class Node<T> {
        T value;
        AtomicReference<Node<T>> nextNode;

        Node() {
            this.nextNode = new AtomicReference<Node<T>>();
        }

        Node(T value) {
            this.value = value;
            this.nextNode = new AtomicReference<Node<T>>();
        }

    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        Node<T> currentTail;
        Node<T> currentNext;

        while(true) {
            currentTail = tail.get();
            currentNext = currentTail.nextNode.get();

            if(currentTail == tail.get()) {
                if(currentNext == null) {
                    if(currentTail.nextNode.compareAndSet(null, newNode)){
                        break;
                    }
                } else {
                    tail.compareAndSet(currentTail, currentNext);
                }
            }
        }

        tail.compareAndSet(currentTail, newNode);

    }

    public T pop() {
        T result;
        Node<T> currentHead;
        Node<T> currentTail;
        Node<T> currentNext;

        while(true) {
            currentHead = head.get();
            currentTail = tail.get();
            currentNext = currentHead.nextNode.get();

            if(currentHead == head.get()){
                if(currentHead == currentTail) {
                    if(currentNext == null) {
                        return null;
                    }
                    tail.compareAndSet(currentTail, currentNext);
                } else {

                    result = currentNext.value;

                    if(head.compareAndSet(currentHead, currentNext)){
                        break;
                    }
                }
            }
        }

        return result;
    }

}
