package ru.nsu.medvedev.v;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private final Queue<Order> queue = new LinkedList<>();
    private final int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();

    DataQueue() {
        this.maxSize = Integer.MAX_VALUE;
    }

    DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * method to check if queue is available
     */
    public void waitOnFull() throws InterruptedException {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.wait();
        }
    }

    /**
     * method to notify all treads that queue is full
     */
    public void notifyAllForFull() {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.notifyAll();
        }
    }

    /**
     * method to check if queue is available
     */
    public void waitOnEmpty() throws InterruptedException {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.wait();
        }
    }

    /**
     * method to notify all treads that queue is empty
     */
    public void notifyAllForEmpty() {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.notify();
        }
    }

    public void add(Order order) {
        synchronized (queue) {
            queue.add(order);
        }
    }

    public Order remove() {
        synchronized (queue) {
            return queue.poll();
        }
    }

    /**
     * method to check if queue is full
     *
     * @return true - if full, false - otherwise
     */
    public boolean isFull() {
        synchronized (queue) {
            return queue.size() == maxSize;
        }
    }

    /**
     * method to check if queue is empty
     *
     * @return true - if empty, false - otherwise
     */
    public boolean isEmpty() {
        synchronized (queue) {
            return queue.isEmpty();
        }
    }
}