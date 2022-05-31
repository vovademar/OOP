package ru.nsu.medvedev.v;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private final List<Baker> bakers;
    private final List<DeliveryClub> deliverers;
    private final Customers customers;

    public Pizzeria(int bakersAmount, int[] bakersProductivity, int deliverersAmount, int[] deliverersProductivity, int storageSize, int[] trunkSizes, int ordersDelay) {
        DataQueue deliveryQueue = new DataQueue(storageSize);
        deliverers = new ArrayList<>();
        for (int i = 0; i < deliverersAmount; i++) {
            DeliveryClub deliverer = new DeliveryClub(deliveryQueue, trunkSizes[i]);
            deliverer.changeProcessingTime(deliverersProductivity[i]);
            deliverers.add(deliverer);
        }

        DataQueue ordersQueue = new DataQueue();
        bakers = new ArrayList<>();
        for (int i = 0; i < bakersAmount; i++) {
            Baker baker = new Baker(ordersQueue, deliveryQueue);
            baker.changeProcessingTime(bakersProductivity[i]);
            bakers.add(baker);
        }
        customers = new Customers(ordersQueue);
        customers.changeProcessingTime(ordersDelay);
    }

    /**
     * method to start threads
     */
    public void pizzeriaStart() {
        Thread customersThread = new Thread(customers);
        customersThread.start();
        for (Baker baker : bakers) {
            Thread thread = new Thread(baker);
            thread.start();
        }
        for (DeliveryClub deliverer : deliverers) {
            Thread thread = new Thread(deliverer);
            thread.start();
        }
    }

    /**
     * method to stop pizzeria work
     **/
    public void pizzeriaStop() throws InterruptedException {
        customers.stopProduce();
        Thread.sleep(100000);
        for (Baker baker : bakers) {
            baker.stopConsume();
        }
        for (Baker baker : bakers) {
            baker.stopProduce();
        }
        Thread.sleep(100000 * 2);
        for (DeliveryClub deliverer : deliverers) {
            deliverer.stopConsume();
        }
    }
}
