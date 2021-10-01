package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ZFuncTest {
    @Test
    void find_some() {
        String text = "ban";
        String niddle = "an";
        ArrayList<Integer> result = new ArrayList<>();
        ZFunc.search(text, niddle, result);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void find_void() {
        String text = "ban";
        String niddle = " ";
        ArrayList<Integer> result = new ArrayList<>();
        ZFunc.search(text, niddle, result);
        ArrayList<Integer> expected = new ArrayList<>();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void find_somemore() {
        String text = "bananananan";
        String niddle = "na";
        ArrayList<Integer> result = new ArrayList<>();
        ZFunc.search(text, niddle, result);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(8);
        Assertions.assertEquals(expected, result);
    }
}