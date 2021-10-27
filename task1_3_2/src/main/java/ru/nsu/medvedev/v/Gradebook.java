package ru.nsu.medvedev.v;

import java.util.ArrayList;
import java.util.Collection;

public class Gradebook {
    /**
     * group - number of group
     * qualificationWorkGrade - grade of qualified work
     * name - name of person
     * SEMNUM - number of semester
     */
    private int group;
    private static int qualificationWorkGrade;
    private String name;
    final private int SEMNUM = 8;
    private final Semester[] semester = new Semester[SEMNUM];

    /**
     * @param group - number of group
     * @param name  - person name
     * @param grade - grade
     */
    public Gradebook(int group, String name, int grade) {
        this.group = group;
        this.name = name;
        qualificationWorkGrade = grade;
        for (int i = 1; i < SEMNUM; i++) {
            semester[i] = new Semester();
        }
    }

    /**
     * method to set qualification work grade
     *
     * @param grade - grade of qualification work
     */
    public void setQualWork(int grade) {
        qualificationWorkGrade = grade;
    }

    /**
     * method to set grade
     *
     * @param sem     - num of semester
     * @param grade   - grade
     * @param subject - name of subject
     */
    public void setGrade(int sem, int grade, String subject) {
        semester[sem].addGrade(grade, subject);
    }

    /**
     * method to get grades of chosen semester
     *
     * @param sem - num of sem
     * @return grades of semester sem
     */
    public Collection<Integer> getSemGrade(int sem) {
        return semester[sem].getGrades();
    }

    /**
     * method to get group number
     *
     * @return group number
     */
    public int getGroup() {
        return group;
    }

    /**
     * method to get gradebook holder name
     *
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * method to get grade of qualification work
     *
     * @return grade of qualification work
     */
    public static int getQualificationWorkGrade() {
        return qualificationWorkGrade;
    }

    /**
     * method to set group number
     *
     * @param group - number of group
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * method to set gradebook holder name
     *
     * @param name - person's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to set grade of qualification work
     *
     * @param qualificationWorkGrade - grade of qualification work
     */
    public static void setQualificationWorkGrade(int qualificationWorkGrade) {
        Gradebook.qualificationWorkGrade = qualificationWorkGrade;
    }

    /**
     * method to get all grades of all years
     *
     * @return - list of grades
     */
    public ArrayList<Integer> getAllGrades() {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 1; i < SEMNUM; i++) {
            grades.addAll(semester[i].getGrades());
        }
        return grades;
    }

    /**
     * method to calculate average grade
     *
     * @param marks - list of grades
     * @return calculated average number
     */
    public double avgGrade(ArrayList<Integer> marks) {
        double res = 0;
        for (Integer mark : marks) {
            res += mark;
        }
        res /= marks.size();
        return res;
    }

    /**
     * method to check if student have red diploma
     *
     * @return true if person have red diploma; false if person doesn't have red diploma
     */
    public boolean reddiplomaCheck() {
        ArrayList<Integer> marks = getAllGrades();
        double grade5_cnt = 0;
        int allcnt = 0;
        for (Integer mark : marks) {
            if (mark == 3) {
                return false;
            } else if (mark == 4) {
                allcnt++;
            } else if (mark == 5) {
                allcnt++;
                grade5_cnt++;
            }
        }
        return (grade5_cnt / allcnt > 0.75) && qualificationWorkGrade == 5;
    }

    /**
     * method to check if student have high scholarship
     *
     * @param sem - number of semester
     * @return true if student have high scholarship; false if student doesn't have high scholarship
     */
    public boolean highScholarshipCheck(int sem) {
        Collection<Integer> marks = getSemGrade(sem);
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