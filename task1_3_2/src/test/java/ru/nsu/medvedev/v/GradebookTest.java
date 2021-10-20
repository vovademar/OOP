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
    void avg_test() {
        ArrayList<Integer> marks = valdemar.getAllGrades();
        double grade = Gradebook.avg_grade(marks);
        Assertions.assertEquals(4.5, grade);
    }

    @Test
    void reddiploma_test() {
        valdemar.setQualWork(5);
        Assertions.assertFalse(Gradebook.reddiploma(valdemar));
    }

    @Test
    public void moneyflex_test_false() {
        Assertions.assertFalse(valdemar.moneyflex(valdemar, 1));
    }

}