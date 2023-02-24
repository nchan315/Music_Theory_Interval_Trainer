package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalListTest {
    private IntervalList intervals;

    @BeforeEach
    public void setup() {
        intervals = new IntervalList();
    }

    @Test
    public void testIntervalList() {
        assertEquals(0, intervals.getLength());
    }

    @Test
    public void testAddAllIntervals() {
        intervals.addAllIntervals();
        assertEquals(13, intervals.getLength());
        assertTrue(intervals.inList("min2"));
        assertTrue(intervals.inList("maj2"));
        assertTrue(intervals.inList("min3"));
        assertTrue(intervals.inList("maj3"));
        assertTrue(intervals.inList("p4"));
        assertTrue(intervals.inList("aug4"));
        assertTrue(intervals.inList("dim5"));
        assertTrue(intervals.inList("p5"));
        assertTrue(intervals.inList("min6"));
        assertTrue(intervals.inList("maj6"));
        assertTrue(intervals.inList("min7"));
        assertTrue(intervals.inList("maj7"));
        assertTrue(intervals.inList("p8"));
    }

    @Test
    public void testAddOneInterval() {
        intervals.addInterval("min2");
        assertEquals(1, intervals.getLength());
        assertTrue(intervals.inList("min2"));
    }

    @Test
    public void testAddManyInterval() {
        intervals.addInterval("min2");
        intervals.addInterval("p4");
        intervals.addInterval("maj6");
        assertEquals(3, intervals.getLength());
        assertTrue(intervals.inList("min2"));
        assertTrue(intervals.inList("p4"));
        assertTrue(intervals.inList("maj6"));
    }

    @Test
    public void testAllIntervalName() {
        intervals.addInterval("min2");
        intervals.addInterval("p4");
        intervals.addInterval("maj6");
        String s = intervals.allIntervalNames();
        assertEquals("min2 p4 maj6 ", s);
    }

    @Test
    public void testGetAt() {
        intervals.addAllIntervals();
        assertEquals("min2", intervals.getAt(0));
        assertEquals("maj7", intervals.getAt(11));
        assertEquals("dim5", intervals.getAt(6));
    }

    @Test
    public void testGetLength() {
        assertEquals(0, intervals.getLength());
        intervals.addInterval("min3");
        assertEquals(1, intervals.getLength());
        intervals.addInterval("maj3");
        assertEquals(2, intervals.getLength());
    }

    @Test
    public void testInList() {
        intervals.addInterval("min3");
        assertTrue(intervals.inList("min3"));
        assertFalse(intervals.inList("p8"));
    }

}
