package ru.nsu.medvedev.v.performanceTest;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ru.nsu.medvedev.v.PrimeSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PerformanceTest {
    private int[] createArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        int[] array = new int[size];
        Arrays.fill(array, 0, size - 1, 1073676287);
        array[size - 1] = 187263196;
        return array;
    }

    private long singleTestForArr(int[] array) throws ExecutionException, InterruptedException {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            long time = System.nanoTime();
            PrimeSearch primeSearch = new PrimeSearch();
            primeSearch.arrPrime(array);
            time = System.nanoTime() - time;
            results.add(time);
        }
        return Collections.min(results);
    }

    private long singleTestForStream(int[] array) throws InterruptedException {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            long time = System.nanoTime();
            PrimeSearch primeSearch = new PrimeSearch();
            primeSearch.streamPrime(array);
            time = System.nanoTime() - time;
            results.add(time);
        }
        return Collections.min(results);
    }

    private long singleTestForThread(int[] array) throws InterruptedException {
        List<Long> results = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            long time = System.nanoTime();
            PrimeSearch primeSearch = new PrimeSearch();
            primeSearch.threadPrime(array);
            time = System.nanoTime() - time;
            results.add(time);
        }
        return Collections.min(results);
    }

    public void performanceTest() throws ExecutionException, InterruptedException, IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("NotPrimeSearch");
        XYSeries series2 = new XYSeries("ThreadNotPrimeSearch");
        XYSeries series3 = new XYSeries("StreamNotPrimeSearch");

        for (int size = 10; size <= 1000000; size *= 10) {
            int[] array = createArray(size);
            long time = singleTestForArr(array);
            series1.add(size, time);
            time = singleTestForThread(array);
            series2.add(size, time);
            time = singleTestForStream(array);
            series3.add(size, time);
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        LineChart chart = new LineChart(dataset);
        chart.createFile();
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        PerformanceTest performanceTest = new PerformanceTest();
        performanceTest.performanceTest();
    }
}
