package ru.nsu.medvedev.v;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Notebook {
    public List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
    }

    public void add(String text) throws IOException {
        Date date = new Date(System.currentTimeMillis());
        Note note = new Note(text, date);
        add(note);
    }

    public void add(Note note) throws IOException {
        notes.add(note);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("notes.json").toFile(), notes);
    }

    public String show() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Note> notesFromFile = Arrays.asList(mapper.readValue(Paths.get("notes.json").toFile(), Note[].class));
        List<Note> sortedNotes = notesFromFile.stream()
                .sorted(Comparator.comparing(Note::getTime, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        System.out.println(sortedNotes.toString());
        return sortedNotes.toString();
    }

    public String show(Date from, Date till, String text) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Note> notesFromFile = Arrays.asList(mapper.readValue(Paths.get("notes.json").toFile(), Note[].class));
        List<Note> filteredNotes = notesFromFile.stream()
                .sorted(Comparator.comparing(Note::getTime, Comparator.nullsLast(Comparator.naturalOrder())))
                .filter(v -> v.getTime().after(from))
                .filter(v -> v.getTime().before(till))
                .filter(v -> v.getText().contains(text))
                .collect(Collectors.toList());
        System.out.println(filteredNotes.toString());
        return filteredNotes.toString();
    }

    public void remove(String textForDel) throws IOException {
        notes.removeIf(note -> (note.getText().equals(textForDel)));
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("notes.json").toFile(), notes);
    }
}
