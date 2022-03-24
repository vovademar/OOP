package ru.nsu.medvedev.v;

import java.util.List;
import java.util.stream.*;
import java.util.Arrays;

public class PrimeSearch {
    /**
     * method to chek if number is prime
     *
     * @param n number for check
     * @return true - if a number is prime
     * false - if a number is non prime
     */
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * method to check the array for prime numbers
     *
     * @param arr array of numbers
     * @return true if there is prime number
     * @return false if there is no prime numbers
     */
    public boolean arrPrime(int[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }
        for (int j : arr) {
            if (isPrime(j)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method to check the array for prime number
     *
     * @param arr array of numbers
     * @return true if array has non prime number
     * @return false if there prime number
     */
    public boolean streamPrime(int[] arr) {
        IntStream stream = Arrays.stream(arr);
        return stream.parallel().anyMatch(x -> !isPrime(x));
    }

    /**
     * method to check the array for prime numbers
     *
     * @param arrays array of numbers
     * @return true if array has non prime number
     * @return false if array has prime number
     */
    public boolean threadPrime(int[] arrays) {
        int threadsCount = Runtime.getRuntime().availableProcessors();
        List<Integer> arr = Arrays.stream(arrays).boxed().collect(Collectors.toList());
        int repeats = arr.size() / threadsCount;
        Searcher searcher = new Searcher();
        Searcher[] threads = new Searcher[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Searcher(arr.subList(i * repeats, (i + 1) * repeats));
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean result = false;
        for (int i = 0; i < threadsCount; i++) {
            if (!threads[i].getRes()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public class Searcher extends Thread {
        List<Integer> arr;
        public boolean res = false;

        Searcher(List<Integer> someArr) {
            arr = someArr;
        }

        Searcher() {
        }

        @Override
        public void run() {
            for (Integer num : arr) {
                if (isPrime(num)) {
                    setRes(true);
                }
            }
        }

        public void setRes(boolean res) {
            this.res = res;
        }

        public boolean getRes() {
            return res;
        }
    }
}

