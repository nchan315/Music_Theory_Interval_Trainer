// Based on code from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import model.IntervalList;
import model.StatsPage;
import org.json.*;
import ui.IntervalTrainer;

// Represents a reader that reads interval trainer from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads interval trainer from file and returns it;
    // throws IOException if an error occurs reading data from file
    public StatsPage readStats() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseStats(jsonObject);
    }

//    // EFFECTS: reads interval trainer from file and returns it;
//    // throws IOException if an error occurs reading data from file
//    public IntervalList readIntervals() throws IOException {
//        String jsonData = readFile(source);
//        JSONObject jsonObject = new JSONObject(jsonData);
//        return parseIntervals(jsonObject);
//    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses interval trainer from JSON object and returns it
    private StatsPage parseStats(JSONObject jsonObject) throws FileNotFoundException {
        int correct = jsonObject.getInt("Correct");
        int total = jsonObject.getInt("Total");
        StatsPage stats = new StatsPage();
        stats.setCorrect(correct);
        stats.setTotal(total);
        return stats;
    }

}
