package ru.nsu.medvedev.v;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileProcessing {


    private String fileExtension = ".json";
    private String filename;

    /**
     * method to set name of file
     *
     * @param name - name of file
     */
    public FileProcessing(String name) {
        filename = name + fileExtension;
    }

    /**
     * method to get class from file
     *
     * @return List of notes
     * @throws IOException
     */

    public List<Note> getClassFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(Paths.get(filename).toFile(), Note[].class));
    }

    /**
     * method to write to file
     *
     * @param notes - list of notes
     * @throws IOException
     */
    public void changeNotebook(List<Note> notes) throws IOException {
        ObjectWriter writer = new ObjectMapper().writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get(filename).toFile(), notes);
    }


}