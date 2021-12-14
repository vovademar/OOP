package ru.nsu.medvedev.v;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Notebook {
    private List<Note> notes;
    private FileProcessing fileProcessing;
    String notebookName = "notes";

    public Notebook() {
        fileProcessing = new FileProcessing(notebookName);
        notes = new ArrayList<>();
        try {
            notes.addAll(fileProcessing.getClassFromFile());
        } catch (IOException ignored) {
        }
        ObjectMapper mapper = new ObjectMapper();
    }

    /**
     * method to set new Notebook name
     *
     * @param name - name of file
     */
    public void setNewNotebookName(String name) {
        notebookName = name;
        fileProcessing = new FileProcessing(name);
    }

    /**
     * method to get Notebook name
     *
     * @return Notebook name
     */
    public String getNotebookName() {
        return notebookName;
    }

    /**
     * method to add note to notebook
     *
     * @param name - name of note
     * @param text - text of note
     * @throws IOException
     */
    public void add(String name, String text) throws IOException {
        Date date = new Date(System.currentTimeMillis());
        Note note = new Note(name, text, date);
        add(note);
    }

    /**
     * addition method to add note
     *
     * @param note - note
     * @throws IOException
     */
    public void add(Note note) throws IOException {
        notes.add(note);
        fileProcessing.changeNotebook(notes);
    }

    /**
     * method to show all notes
     *
     * @return List of notes
     * @throws IOException
     */
    public List<Note> show() throws IOException {
        return new ArrayList<>(fileProcessing.getClassFromFile());
    }

    /**
     * method to show notes from date to date
     *
     * @param from - date from
     * @param till - date till
     * @param text - names of notes
     * @return List of notes
     * @throws IOException
     */
    public List<Note> show(Date from, Date till, String[] text) throws IOException {
        List<String> txt = Arrays.stream(text).collect(Collectors.toList());
        List<Note> result = new ArrayList<>();
        fileProcessing.getClassFromFile().stream()
                .sorted(Comparator.comparing(Note::getTime, Comparator.nullsLast(Comparator.naturalOrder())))
                .filter(v -> v.getTime().after(from))
                .filter(v -> v.getTime().before(till))
                .forEach(note -> {
                    if (txt.contains(note.getName())) {
                        result.add(note);
                    }
                });
        return result;
    }

    /**
     * method to remove note from notebook
     *
     * @param nameForDel - name of note to remove
     * @throws IOException
     */
    public void remove(String nameForDel) throws IOException {
        notes.removeIf(note -> (note.getName().equals(nameForDel)));
        fileProcessing.changeNotebook(notes);
    }
}
