package ru.nsu.medvedev.v;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private String text;
    private String time;


    public void setText(String text) {
        this.text = text;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }


    Note(String text, String time) {
        this.text = text;
        this.time = time;
    }

}
