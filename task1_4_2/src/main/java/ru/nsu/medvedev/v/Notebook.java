package ru.nsu.medvedev.v;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notebook {
    public List<Note> notebook;

    public Notebook() {
        notebook = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
    }

    public void add(String text) {
        String date = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss").format(new Date());
        Date dateInfo = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Note note = new Note(text, date);
        notebook.add(note);
    }

    public String show() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonlist = mapper.writeValueAsString(notebook);
        return jsonlist;
    }

    public void remove(String textForDel) {
        notebook.removeIf(note -> (note.getText().equals(textForDel)));
    }
}

