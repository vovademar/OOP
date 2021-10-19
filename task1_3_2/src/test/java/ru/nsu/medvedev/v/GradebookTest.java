package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GradebookTest {


    @Test
    void avg_test() {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(5);
        marks.add(4);
        double grade = Gradebook.avg_grade(marks);
        Assertions.assertEquals(4.5, grade);
    }

    @Test
    void reddiploma_test() {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(5);
        marks.add(5);
        marks.add(5);
        marks.add(5);
        marks.add(5);
        marks.add(4);
        Assertions.assertTrue(Gradebook.reddiploma(marks));
    }

    @Test
    void moneyflex_test_false() {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(5);
        marks.add(3);
        Assertions.assertFalse(Gradebook.moneyflex(marks));
    }

    @Test
    void moneyflex_test_true() {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(5);
        marks.add(5);
        Assertions.assertTrue(Gradebook.moneyflex(marks));
    }
}