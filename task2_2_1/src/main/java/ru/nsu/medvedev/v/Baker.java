package ru.nsu.medvedev.v;

import java.util.Random;

public class Baker implements Consumer, Producer {
    public final DataQueue orderQueue;
    private final String orderProduceStatus;
    private final DataQueue deliveryQueue;
    private final String orderConsumeStatus;
    private final Random random = new Random();
    private int deliveryCounter;
    private volatile boolean processing;
    private int processingTime = 0;

    public Baker(DataQueue orderQueue, DataQueue deliveryQueue) {
        orderConsumeStatus = "Cooking";
        orderProduceStatus = "On the Way";
        this.orderQueue = orderQueue;
        this.deliveryQueue = deliveryQueue;
        processing = true;
    }

    @Override
    public void run() {
        while (isProcessing()) {
            consumer();
            producer();
        }
    }

    @Override
    public void consumer() {
        while (orderQueue.isEmpty()) {
            if (!processing) {
                return;
            }
            try {
                orderQueue.waitOnEmpty();
            } catch (InterruptedException ignored) {
            }
        }
        if (!processing) {
            return;
        }
        Order order = orderQueue.remove();
        deliveryCounter = order.getOrderNumber();
        orderQueue.notifyAllForFull();
    }

    /**
     * method to create new order
     *
     * @return order
     */
    public Order generateDelivery() {
        Order order = new Order();
        order.setOrderStatus(orderConsumeStatus);
        order.setOrderNumber(deliveryCounter);
        System.out.println("Order[" + deliveryCounter + "] is " + orderConsumeStatus);
        return order;
    }

    /**
     * method to check if program is working
     *
     * @return precessing flag
     */
    public boolean isProcessing() {
        return processing;
    }

    /**
     * method to stop consuming orders
     */
    @Override
    public void stopConsume() {
        processing = false;
        orderQueue.notifyAllForEmpty();
    }

    @Override
    public void producer() {
        while (deliveryQueue.isFull()) {
            if (!isProcessing()) {
                return;
            }
            try {
                deliveryQueue.waitOnFull();
            } catch (InterruptedException e) {
                break;
            }
        }
        if (!isProcessing()) {
            return;
        }
        Order delivery = generateDelivery();
        try {
            Thread.sleep(random.nextInt(processingTime));
        } catch (InterruptedException ignored) {
        }
        changeOrderStatus(delivery, orderProduceStatus);
        deliveryQueue.add(delivery);
        deliveryQueue.notifyAllForEmpty();
    }

    /**
     * method to change time, which baker can spend on cooking
     *
     * @param time - time ti cook pizza
     */
    public void changeProcessingTime(int time) {
        processingTime = time;
    }

    /**
     * method to change status of order
     *
     * @param order  - the order you want to change
     * @param status - the new status you want to set
     */
    public void changeOrderStatus(Order order, String status) {
        order.setOrderStatus(status);
        System.out.println("Order[" + order.getOrderNumber() + "] is " + status);
    }

    @Override
    public void stopProduce() {
        processing = false;
        deliveryQueue.notifyAllForFull();
        orderQueue.notifyAllForEmpty();
    }
}
