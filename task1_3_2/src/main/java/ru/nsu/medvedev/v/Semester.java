package ru.nsu.medvedev.v;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Semester {
    Map<String, Integer> semester = new HashMap<>();

    /**
     * method to add grade with key: subject
     *
     * @param grade   - grade
     * @param subject - subject
     */
    public void addGrade(int grade, String subject) {
        this.semester.put(subject, grade);
    }

    /**
     * method to get grades
     *
     * @return grades
     */
    public Collection<Integer> getGrades() {
        return semester.values();
    }
}
