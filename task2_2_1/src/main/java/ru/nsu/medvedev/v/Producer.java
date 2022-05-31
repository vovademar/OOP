package ru.nsu.medvedev.v;

public interface Producer extends Runnable {
    void run();

    void producer();

    void stopProduce();

}