package ru.nsu.medvedev.v.json;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonProcessing {
    /**
     * method to take json data from file
     *
     * @return parameters for pizzeria
     */
    public JsonPizzeria jsonHandle() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("PizzeriaData.json"));
        JsonPizzeria pizzeria = gson.fromJson(reader, JsonPizzeria.class);
        reader.close();
        return pizzeria;
    }
}
