package ru.nsu.medvedev.v;

import java.util.*;
import java.util.stream.*;

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
     * @param arr array of numbers
     * @return true if array has non prime number
     * @return false if array has prime number
     * @throws InterruptedException
     */
    public boolean threadPrime(int[] arr) throws InterruptedException {
        int threadsCount = Runtime.getRuntime().availableProcessors();
        int repeats = arr.length / threadsCount;
        int sizeOfa = arr.length;
        int count = 0;
        int val = 0;
        for (int i = 0; i <= threadsCount - 1; i++) {
            Thread searcher;
            if (i == threadsCount - 1) {
                Searcher foo = new Searcher(i * repeats, sizeOfa - 1, arr, count);
                searcher = new Thread(foo);
                searcher.start();
                searcher.join();
                val += foo.getCountOfPrimes();
            } else {
                Searcher foo1 = new Searcher(i * repeats, i * repeats + repeats - 1, arr, count);
                searcher = new Thread(foo1);
                searcher.start();
                searcher.join();
                val += foo1.getCountOfPrimes();
            }
            if (val > 0) {
                return false;
            }
        }
        return true;
    }

    public class Searcher implements Runnable {
        private int startIndex;
        private int endIndex;
        private int[] arrayToSearchIn;
        private int countOfPrimes;

        public Searcher(int s, int e, int[] a, int count) {
            startIndex = s;
            endIndex = e;
            arrayToSearchIn = a;
            countOfPrimes = count;
        }

        public void run() {
            for (int i = startIndex; i <= endIndex; i++) {
                if (isPrime(arrayToSearchIn[i])) {
                    setCountOfPrimes(1);
                }
            }
        }

        public void setCountOfPrimes(int countOfPrimes) {
            this.countOfPrimes = countOfPrimes;
        }

        public int getCountOfPrimes() {
            return countOfPrimes;
        }
    }
}

