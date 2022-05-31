package ru.nsu.medvedev.v;

public interface Consumer extends Runnable {

    void run();

    void consumer();

    void stopConsume();
}
