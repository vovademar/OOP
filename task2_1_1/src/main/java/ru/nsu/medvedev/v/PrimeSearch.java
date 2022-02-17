package ru.nsu.medvedev.v;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PrimeSearch {
    private boolean isPrime(int n) {
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

    public boolean arrPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean streamPrime(int[] arr) {
        int countPrimes = 0;
        IntStream stream = Arrays.stream(arr);
        countPrimes = (int) stream.filter(this::isPrime).count();
        if (countPrimes == 0) {
            return false;
        }
        return true;
    }

 
}
