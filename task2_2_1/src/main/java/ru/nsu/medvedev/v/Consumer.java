package ru.nsu.medvedev.v;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private final List<Integer> tasks;


    public Consumer(List<Integer> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run(){
        System.out.println("Consumer start");
        while(true){
            try{
                consume();
            } catch (InterruptedException ignored){}
        }
    }

    private void consume() throws InterruptedException{
        synchronized (tasks){
            while (tasks.isEmpty()){
                System.out.println("Storage is empty" + Thread.currentThread().getName() + "is waiting");
                tasks.wait();
            }
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            int i = tasks.remove(0);
            System.out.println("Consumed" + i);
            tasks.notifyAll();
        }
    }
}

