package ru.nsu.medvedev.v;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private final List<Integer> tasks;

    public Producer(List<Integer> orders) {
        this.tasks = orders;
    }

    @Override
    public void run(){
        System.out.println("Produce start");
        while(true){
            try{
                placeOrder();
            } catch (InterruptedException ignored){}
        }
    }

    public void placeOrder() throws InterruptedException {
        synchronized (tasks){
            while (tasks.isEmpty()){
                System.out.println("No orders " + Thread.currentThread().getName() + "is waiting");
                tasks.wait();
            }
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            int i = tasks.remove(0);
            System.out.println("Cooked " + i);
            tasks.notifyAll();
        }
    }
}
