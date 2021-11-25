package ru.nsu.medvedev.v;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private String text;
    private Date time;

    public Note(){
        this("", new Date());
    }

    public Note(String text, Date time) {
        this.text = text;
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String fromMilisecsToNormalTime(Date milisec) {
        return new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(milisec);
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "\n" + this.getText() + " " + fromMilisecsToNormalTime(this.getTime()) + "\n";
    }
}
