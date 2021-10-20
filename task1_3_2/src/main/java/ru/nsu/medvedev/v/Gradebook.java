package ru.nsu.medvedev.v;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Gradebook {
    private int group;
    private static int qualWork;
    private String name;
    final private int SEMNUM = 8;
    private final Semester[] semester = new Semester[SEMNUM];


    public Gradebook(int group, String name, int grade) {
        this.group = group;
        this.name = name;
        qualWork = grade;
        for (int i = 1; i <= SEMNUM; i++) {
            Semester sem = new Semester();
            semester[i] = sem;
        }
    }

    public void setQualWork(int grade) {
        qualWork = grade;
    }

    public void setGrade(int sem, int grade, String subject) {
        semester[sem].addGrade(grade, subject);
    }

    public Collection<Integer> getSemGrade(int sem) {
        return semester[sem].getGrades();
    }

    public ArrayList<Integer> getAllGrades() {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 0; i <= SEMNUM; i++) {
            grades.addAll(semester[i].getGrades());
        }
        return grades;
    }

    public static double avg_grade(ArrayList<Integer> marks) {
        double res = 0;
        for (int i = 0; i < marks.size(); i++) {
            res += marks.get(i);
        }
        res /= marks.size();
        return res;
    }

    public static boolean reddiploma(Gradebook gradebook) {
        ArrayList<Integer> marks = gradebook.getAllGrades();
        double grade5_cnt = 0;
        int allcnt = 0;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) == 3) {
                return false;
            } else if (marks.get(i) == 4) {
                allcnt++;
            } else if (marks.get(i) == 5) {
                allcnt++;
                grade5_cnt++;
            }
        }
        if ((grade5_cnt / allcnt > 0.75) && qualWork == 5) {
            return true;
        }
        return false;
    }

    public boolean moneyflex(Gradebook gradebook, int sem) {
        Collection<Integer> marks = gradebook.getSemGrade(sem);
        int grade5_cnt = 0;
        int allcnt = 0;
        for (int mark : marks) {
            if (mark == 5) {
                grade5_cnt++;
                allcnt++;
            } else {
                return false;
            }
        }
        return allcnt == grade5_cnt;
    }

}

class Semester {
    Map<String, Integer> semester = new HashMap<>();

    public void addGrade(int grade, String subject) {
        this.semester.put(subject, grade);
    }

    public Collection<Integer> getGrades() {
        return semester.values();
    }
}

