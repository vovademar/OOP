package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimeTest {
    @Test
    public void someTest(){
        int arr[] = {1,2,3,4,5};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertTrue(primeSearch.arrPrime(arr));
    }
    @Test
    public void streamTestTrue(){
        int arr[] = {7,8,9,10,13};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertTrue(primeSearch.streamPrime(arr));
    }
    @Test
    public void streamTestFalse(){
        int arr[] = {4,6,8,10};
        PrimeSearch primeSearch = new PrimeSearch();
        Assertions.assertFalse(primeSearch.arrPrime(arr));
    }

}
