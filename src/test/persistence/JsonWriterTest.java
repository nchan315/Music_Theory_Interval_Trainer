// Based on code from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;

import model.IntervalList;
import model.StatsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {
    private IntervalList intervals;
    private StatsPage stats;

    @BeforeEach
    void setup() {
        intervals = new IntervalList();
        intervals.addInterval("min2");
        stats = new StatsPage();
        stats.setCorrect(2);
        stats.setTotal(3);
    }

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
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(intervals, stats);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            stats = reader.readStats();
            assertEquals(2, stats.getCorrect());
            assertEquals(3, stats.getTotal());
            intervals = reader.readIntervals();
            assertTrue(intervals.inList("min2"));
            assertFalse(intervals.inList("maj3"));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            intervals.addInterval("maj3");
            stats.setTotal(4);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(intervals, stats);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            stats = reader.readStats();
            assertEquals(2, stats.getCorrect());
            assertEquals(4, stats.getTotal());
            intervals = reader.readIntervals();
            assertTrue(intervals.inList("min2"));
            assertTrue(intervals.inList("maj3"));
            assertFalse(intervals.inList("p8"));
            assertEquals(2, intervals.getLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
