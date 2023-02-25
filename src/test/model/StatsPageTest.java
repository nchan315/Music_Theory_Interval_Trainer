package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatsPageTest {

    private StatsPage stats;

    @BeforeEach
    public void setup() {
        stats = new StatsPage();
    }

    @Test
    public void testStatsPageConstructor() {
        assertEquals(0, stats.getCorrect());
        assertEquals(0, stats.getTotal());
    }

    @Test
    public void makeFreshRecordTest() {
        assertEquals(0, stats.getFromRecord("min2"));
        assertEquals(0, stats.getFromRecord("maj2"));
        assertEquals(0, stats.getFromRecord("min3"));
        assertEquals(0, stats.getFromRecord("maj3"));
        assertEquals(0, stats.getFromRecord("p4"));
        assertEquals(0, stats.getFromRecord("aug4"));
        assertEquals(0, stats.getFromRecord("dim5"));
        assertEquals(0, stats.getFromRecord("p5"));
        assertEquals(0, stats.getFromRecord("min6"));
        assertEquals(0, stats.getFromRecord("maj6"));
        assertEquals(0, stats.getFromRecord("min7"));
        assertEquals(0, stats.getFromRecord("maj7"));
        assertEquals(0, stats.getFromRecord("p8"));
    }

    @Test
    public void correctIntervalTest() {
        assertEquals(0, stats.getCorrect());
        assertEquals(0, stats.getTotal());
        stats.correctInterval();
        assertEquals(1, stats.getCorrect());
        assertEquals(1, stats.getTotal());
        stats.correctInterval();
        assertEquals(2, stats.getCorrect());
        assertEquals(2, stats.getTotal());
    }

    @Test
    public void incorrectIntervalTest() {
        assertEquals(0, stats.getCorrect());
        assertEquals(0, stats.getTotal());
        assertEquals(0, stats.getFromRecord("min2"));
        stats.incorrectInterval("min2");
        assertEquals(0, stats.getCorrect());
        assertEquals(1, stats.getTotal());
        assertEquals(1, stats.getFromRecord("min2"));
        assertEquals(0, stats.getFromRecord("maj2"));
    }

    @Test
    public void displayStatsTest() {
        assertEquals("No summary stats to display yet", stats.displayStats());
        stats.correctInterval();
        assertEquals("Accuracy: 100.0%", stats.displayStats());
    }

    @Test
    public void getFromRecordTest() {
        assertEquals(0, stats.getFromRecord("min2"));
        assertEquals(0, stats.getFromRecord("p8"));
    }

    @Test
    public void getCorrectTest() {
        assertEquals(0, stats.getCorrect());
    }

    @Test
    public void getTotalTest() {
        assertEquals(0, stats.getTotal());
    }

}
