package ru.nsu.medvedev.v;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileProcessing {
    /**
     * method to get class from file
     * @return List of notes
     * @throws IOException
     */
    public List<Note> getClassFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Paths.get("notes.json").toFile(), Note[].class));
    }

    /**
     * method to write to file
     * @param notes - list of notes
     * @throws IOException
     */
    public void changeNotebook(List<Note> notes) throws IOException {
        ObjectWriter writer = new ObjectMapper().writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("notes.json").toFile(), notes);
    }
}