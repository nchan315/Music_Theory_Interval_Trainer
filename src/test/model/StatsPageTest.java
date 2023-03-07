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
        stats.incorrectInterval("min2");
        assertEquals(0, stats.getCorrect());
        assertEquals(1, stats.getTotal());
    }

    @Test
    public void displayStatsTest() {
        assertEquals("No summary stats to display yet", stats.displayStats());
        stats.correctInterval();
        assertEquals("Accuracy: 100.0%", stats.displayStats());
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
