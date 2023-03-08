// Based on code from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;

import model.IntervalList;
import model.StatsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            IntervalList intervals = new IntervalList();
            StatsPage stats = new StatsPage();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFile.json");
            writer.open();
            writer.write(intervals, stats);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFile.json");
            stats = reader.readStats();
            assertEquals(0, stats.getCorrect());
            assertEquals(0, stats.getTotal());
            intervals = reader.readIntervals();
            assertFalse(intervals.inList("min2"));
            assertFalse(intervals.inList("maj3"));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            IntervalList intervals = new IntervalList();
            intervals.addInterval("min2");
            StatsPage stats = new StatsPage();
            stats.setCorrect(2);
            stats.setTotal(3);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFile.json");
            writer.open();
            writer.write(intervals, stats);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFile.json");
            stats = reader.readStats();
            assertEquals(2, stats.getCorrect());
            assertEquals(3, stats.getTotal());
            intervals = reader.readIntervals();
            assertTrue(intervals.inList("min2"));
            assertFalse(intervals.inList("p8"));
            assertEquals(1, intervals.getLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
