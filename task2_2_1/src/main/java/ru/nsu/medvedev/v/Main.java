package ru.nsu.medvedev.v;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arrays = {1,2,3,4};
        List<Integer> arr = Arrays.stream(arrays).boxed().collect(Collectors.toList());
        Producer producer = new Producer(arr);
        Thread thread = new Thread(producer);
        thread.start();
    }
}
