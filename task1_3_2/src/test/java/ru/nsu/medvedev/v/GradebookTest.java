package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GradebookTest {
    Gradebook valdemar;

    @BeforeEach
    private void setStudent() {
        valdemar = new Gradebook(20214, "Medvedev", 0);
        valdemar.setGrade(1, 4, "Math");
        valdemar.setGrade(1, 5, "ProgaC");
        valdemar.setGrade(1, 4, "Haskellll");
        valdemar.setGrade(1, 5, "History");
        valdemar.setGrade(1, 4, "Logic");
        valdemar.setGrade(2, 5, "SQL");
        valdemar.setGrade(2, 4, "CP");
        valdemar.setGrade(2, 5, "trees");
    }

    @Test
    public void avg_test() {
        ArrayList<Integer> marks = valdemar.getAllGrades();
        double grade = valdemar.avgGrade(marks);
        Assertions.assertEquals(4.5, grade);
    }

    @Test
    public void reddiploma_test() {
        valdemar.setQualWork(5);
        Assertions.assertFalse(valdemar.reddiplomaCheck());
    }

    @Test
    public void reddiploma_test_genius() {
        Gradebook valdemar1;
        valdemar1 = new Gradebook(20214, "Medvedevv", 0);
        valdemar1.setGrade(1, 5, "Math");
        valdemar1.setGrade(1, 5, "ProgaC");
        valdemar1.setGrade(1, 5, "Haskellll");
        valdemar1.setGrade(1, 5, "History");
        valdemar1.setGrade(1, 4, "Logic");
        valdemar1.setGrade(2, 5, "SQL");
        valdemar1.setGrade(2, 5, "CP");
        valdemar1.setGrade(2, 5, "trees");
        valdemar1.setQualWork(5);
        Assertions.assertTrue(valdemar1.reddiplomaCheck());
    }

    @Test
    public void moneyflex_test_true() {
        Gradebook valdemar2;
        valdemar2 = new Gradebook(20214, "Medvedevv", 0);
        valdemar2.setGrade(1, 5, "Math");
        valdemar2.setGrade(1, 5, "ProgaC");
        valdemar2.setGrade(1, 5, "Haskellll");
        valdemar2.setGrade(1, 5, "History");
        valdemar2.setGrade(1, 5, "Logic");
        valdemar2.setGrade(2, 5, "SQL");
        valdemar2.setGrade(2, 5, "CP");
        valdemar2.setGrade(2, 5, "trees");
        Assertions.assertTrue(valdemar2.HighScholarshipCheck(2));
    }

    @Test
    public void moneyflex_test_false() {
        Gradebook valdemar3;
        valdemar3 = new Gradebook(20214, "Medvedevv", 0);
        valdemar3.setGrade(1, 5, "Math");
        valdemar3.setGrade(1, 5, "ProgaC");
        valdemar3.setGrade(1, 4, "Haskellll");
        valdemar3.setGrade(1, 5, "History");
        valdemar3.setGrade(1, 5, "Logic");
        valdemar3.setGrade(2, 5, "SQL");
        valdemar3.setGrade(2, 5, "CP");
        valdemar3.setGrade(2, 5, "trees");
        Assertions.assertFalse(valdemar3.HighScholarshipCheck(1));
    }
}