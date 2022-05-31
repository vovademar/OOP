package ru.nsu.medvedev.v;

import java.util.ArrayDeque;
import java.util.Random;

public class DeliveryClub implements Consumer {
    private final DataQueue deliveryQueue;
    private final String orderConsumeStatus;
    private final ArrayDeque<Order> trunk = new ArrayDeque<>();
    private final int trunkSize;
    private final Random random = new Random();
    private volatile boolean processing;
    private int processingTime = 0;

    public DeliveryClub(DataQueue deliveryQueue, int trunkSize) {
        orderConsumeStatus = "Delivered";
        this.deliveryQueue = deliveryQueue;
        this.trunkSize = trunkSize;
        processing = true;
    }

    @Override
    public void run() {
        while (getFlag()) {
            consumer();
        }
    }

    @Override
    public void consumer() {
        for (int i = 0; i < trunkSize; i++) {
            while (deliveryQueue.isEmpty()) {
                if (!processing) {
                    return;
                }
                try {
                    deliveryQueue.waitOnEmpty();
                } catch (InterruptedException ignored) {
                }
            }
            if (!processing) {
                return;
            }
            if (!deliveryQueue.isEmpty()) {
                Order order = deliveryQueue.remove();
                trunk.add(order);
                deliveryQueue.notifyAllForFull();
            }
        }
        while (!trunk.isEmpty()) {
            try {
                Thread.sleep(random.nextInt(processingTime));
            } catch (InterruptedException ignored) {
            }
            changeOrderStatus(trunk.remove(), orderConsumeStatus);
        }
    }

    /**
     * method to check if program is working
     *
     * @return processing flag
     */
    public boolean getFlag() {
        return processing;
    }

    @Override
    public void stopConsume() {
        processing = false;
        deliveryQueue.notifyAllForEmpty();
    }

    /**
     * method to change time, which deliver can spend on delivering
     *
     * @param time - time to deliver
     */
    public void changeProcessingTime(int time) {
        processingTime = time;
    }

    /**
     * method to change order status
     *
     * @param order  - the order you want to change
     * @param status - the new status you want to set
     */
    public void changeOrderStatus(Order order, String status) {
        order.setOrderStatus(status);
        System.out.println("Order[" + order.getOrderNumber() + "] is " + status);
    }
}
