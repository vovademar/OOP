package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PrimeTest {
    PrimeSearch primeSearch;

    @BeforeEach
    public void initEach() {
        primeSearch = new PrimeSearch();
    }

    @Test
    public void arrTest() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertTrue(primeSearch.arrPrime(arr));
    }

    @Test
    public void arrTestLargeNum() {
        int[] arr = {1073676287};
        Assertions.assertTrue(primeSearch.arrPrime(arr));
    }

    @Test
    public void arrSearchLarge() {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 0, size, 1877);
        Assertions.assertTrue(primeSearch.arrPrime(array));
    }

    @Test
    public void streamTestFalse() {
        int arr[] = {7, 7, 7};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertFalse(primeSearch.streamPrime(arr));
    }

    @Test
    public void streamTestTrue() {
        int arr[] = {4, 6, 8, 10};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertTrue(primeSearch.streamPrime(arr));
    }

    @Test
    public void streamTest() {
        int arr[] = {1073676287};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertFalse(primeSearch.streamPrime(arr));
    }

    @Test
    public void streamSearchLarge() {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 0, size, 1877);
        Assertions.assertFalse(primeSearch.streamPrime(array));
    }

    @Test
    public void threadTest() {
        int arr[] = {7, 7, 7};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertFalse(primeSearch.threadPrime(arr));
    }

    @Test
    public void threadSearchLarge() {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 0, size, 1877);
        Assertions.assertFalse(primeSearch.threadPrime(array));
    }

    @Test
    public void threadTrue() {
        int arr[] = {7, 7, 7, 8};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertFalse(primeSearch.threadPrime(arr));
    }

}
