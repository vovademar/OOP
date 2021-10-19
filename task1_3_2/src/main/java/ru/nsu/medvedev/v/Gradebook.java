package ru.nsu.medvedev.v;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Gradebook {

    public static double avg_grade(ArrayList<Integer> marks) {
        double res = 0;
        for (int i = 0; i < marks.size(); i++) {
            res += marks.get(i);
        }
        res /= marks.size();
        return res;
    }

    public static boolean reddiploma(ArrayList<Integer> marks) {
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
        if (grade5_cnt / allcnt > 0.75) {
            return true;
        }
        return false;
    }

    public static boolean moneyflex(ArrayList<Integer> marks) {
        int grade5_cnt = 0;
        int allcnt = 0;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) == 5) {
                grade5_cnt++;
                allcnt++;
            } else return false;
        }
        if (allcnt == grade5_cnt) {
            return true;
        }
        return false;
    }
}
