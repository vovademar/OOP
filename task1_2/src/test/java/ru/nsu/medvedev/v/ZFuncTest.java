package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ZFuncTest {

    @Test
    void find_empty() throws IOException {
        char[] needle = {'o', 'p'};
        Reader file = new FileReader("test2.txt");
        ArrayList<Integer> res = ZFunc.search(file, needle);
        ArrayList<Integer> excepted = new ArrayList<>();
        Assertions.assertArrayEquals(res.toArray(), excepted.toArray());
    }

    @Test
    void find_some() throws IOException {
        char[] needle = {'r', 'a'};
        Reader file = new FileReader("test3.txt");
        ArrayList<Integer> res = ZFunc.search(file, needle);
        ArrayList<Integer> excepted = new ArrayList<>();
        excepted.add(2);
        Assertions.assertArrayEquals(res.toArray(), excepted.toArray());
    }

    @Test
    void find_large() throws IOException {
        char[] needle = {'o', 'p'};
        Reader file = new FileReader("test1.txt");
        ArrayList<Integer> res = ZFunc.search(file, needle);
        ArrayList<Integer> excepted = new ArrayList<>();
        excepted.add(2);
        excepted.add(131);
        Assertions.assertArrayEquals(res.toArray(), excepted.toArray());
    }
}