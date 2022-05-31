package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PizzeriaTest {
    @Test
    void bakerTest() throws InterruptedException {
        DataQueue ordersQueue = new DataQueue(3);
        DataQueue deliveryQueue = new DataQueue(3);
        Order order = new Order();
        order.setOrderStatus("mem");
        order.setOrderNumber(15);
        while (!ordersQueue.isFull()) {
            ordersQueue.add(order);
        }
        Baker baker = new Baker(ordersQueue, deliveryQueue);
        baker.changeProcessingTime(1000);
        Thread bakerThread = new Thread(baker);
        bakerThread.start();
        while (!deliveryQueue.isFull()) {
        }
        Thread.sleep(3000);
        baker.stopConsume();
        baker.stopProduce();
        while (!deliveryQueue.isEmpty()) {
            order = deliveryQueue.remove();
            assertEquals("On the Way", order.getOrderStatus());
            assertEquals(15, order.getOrderNumber());
        }
    }

    @Test
    void customerTest() throws InterruptedException {
        DataQueue ordersQueue = new DataQueue(5);
        Customers customers = new Customers(ordersQueue);
        customers.changeProcessingTime(1000);

        Thread customersThread = new Thread(customers);
        customersThread.start();
        while (!ordersQueue.isFull()) {
        }
        Thread.sleep(3000);
        customers.stopProduce();
        while (!ordersQueue.isEmpty()) {
            assertEquals("Processing", ordersQueue.remove().getOrderStatus());
        }
        Thread.sleep(3000);
    }

    @Test
    void deliveryGuyTest() throws InterruptedException {
        DataQueue deliveryQueue = new DataQueue(3);
        Order order = new Order();
        order.setOrderNumber(15);
        order.setOrderStatus("mem");
        while (!deliveryQueue.isFull()) {
            deliveryQueue.add(order);
        }
        DeliveryClub deliveryGuy = new DeliveryClub(deliveryQueue, 2);
        deliveryGuy.changeProcessingTime(1000);
        Thread delivererThread = new Thread(deliveryGuy);
        delivererThread.start();
        Thread.sleep(3000);
        deliveryGuy.stopConsume();
        assertTrue(deliveryQueue.isEmpty());
    }
}
