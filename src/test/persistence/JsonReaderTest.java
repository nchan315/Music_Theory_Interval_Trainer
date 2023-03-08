// Based on code from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;

import model.IntervalList;
import model.StatsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            StatsPage stats = reader.readStats();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFile.json");
        try {
            StatsPage stats = reader.readStats();
            assertEquals(0, stats.getCorrect());
            assertEquals(0, stats.getTotal());
            IntervalList intervals = reader.readIntervals();
            assertFalse(intervals.inList("min2"));
            assertFalse(intervals.inList("maj2"));
            assertEquals(0, intervals.getLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFile.json");
        try {
            StatsPage stats = reader.readStats();
            assertEquals(2, stats.getCorrect());
            assertEquals(4, stats.getTotal());
            IntervalList intervals = reader.readIntervals();
            assertTrue(intervals.inList("min2"));
            assertFalse(intervals.inList("maj2"));
            assertEquals(2, intervals.getLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
