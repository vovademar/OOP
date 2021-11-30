package ru.nsu.medvedev.v;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private String name;
    private String text;
    private Date time;

    public Note() {
        this("", "", new Date());
    }

    /**
     *
     * @param name - name of note
     * @param text - text of note
     * @param time - time of note
     */
    public Note(String name, String text, Date time) {
        this.text = text;
        this.time = time;
        this.name = name;
    }

    /**
     * method to get name of note
     * @return name
     */
    public String getName() {
        return name;
    }

    /** method to set name of note
     * @param name - name of note
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to set text
     * @param text - text of note
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * method to set time
     * @param time - time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * method to get text of note
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * method to get time of note
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * overriding toString method
     * @return string
     */
    @Override
    public String toString() {
        return "\n" + "Title: " + this.getName() + "\nNote: " + this.getText() + "\nTime: "
                + new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format((this.getTime())) + "\n";
    }
}
