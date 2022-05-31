package ru.nsu.medvedev.v;

import java.util.Random;

public class Customers implements Producer {
    public final DataQueue orderQueue;
    private final String orderProduceStatus;
    private final Random random = new Random();
    private int orderCount;
    private volatile boolean processing;
    private int processingTime = 0;

    public Customers(DataQueue orderQueue) {
        orderProduceStatus = "Processing";
        this.orderQueue = orderQueue;
        processing = true;
    }

    @Override
    public void run() {
        while (isProcessing()) {
            producer();
        }
    }

    /**
     * method to check if program is running
     *
     * @return precessing flag
     */
    public boolean isProcessing() {
        return processing;
    }

    @Override
    public void producer() {
        while (orderQueue.isFull()) {
            try {
                orderQueue.waitOnFull();
            } catch (InterruptedException e) {
                break;
            }
        }
        if (!isProcessing()) {
            return;
        }
        Order order = generateOrder();
        orderQueue.add(order);
        orderQueue.notifyAllForEmpty();
        try {
            Thread.sleep(random.nextInt(processingTime));
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * method to create new order
     *
     * @return order
     */
    public Order generateOrder() {
        Order order = new Order();
        orderCount++;
        order.setOrderStatus(orderProduceStatus);
        order.setOrderNumber(orderCount);
        System.out.println("Order[" + orderCount + "] is " + orderProduceStatus);
        return order;
    }

    /**
     * method to change processing time
     *
     * @param time - delay
     */
    public void changeProcessingTime(int time) {
        processingTime = time;
    }


    @Override
    public void stopProduce() {
        processing = false;
        orderQueue.notifyAllForFull();
    }
}

