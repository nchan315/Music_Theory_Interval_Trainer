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
    public void testAddOneInterval() {
        Interval min2 = new Interval("min2");
        intervals.addInterval(min2);
        assertEquals(1, intervals.getLength());
        assertTrue(intervals.inList(min2));
    }

    @Test
    public void testAddManyInterval() {
        Interval min2 = new Interval("min2");
        Interval p4 = new Interval("p4");
        Interval maj6 = new Interval("maj6");
        intervals.addInterval(min2);
        intervals.addInterval(p4);
        intervals.addInterval(maj6);
        assertEquals(3, intervals.getLength());
        assertTrue(intervals.inList(min2));
        assertTrue(intervals.inList(p4));
        assertTrue(intervals.inList(maj6));
    }

    @Test
    public void testAddAllIntervals() {
        intervals.addAllIntervals();
        assertEquals(12, intervals.getLength());
    }

    @Test
    public void testGetIntervalDistAll() {
        intervals.addAllIntervals();
        assertEquals(1, intervals.getIntervalDist(0));
        assertEquals(6, intervals.getIntervalDist(5));
        assertEquals(12, intervals.getIntervalDist(11));
    }

    @Test
    public void testAllIntervalNames() {
        intervals.addInterval(new Interval("maj3"));
        intervals.addInterval(new Interval("min3"));
        intervals.addInterval(new Interval("p5"));
        String s = intervals.allIntervalNames();
        assertEquals("maj3 min3 p5 ", s);
    }

    @Test
    public void testGetIntervalName() {
        intervals.addInterval(new Interval("maj3"));
        intervals.addInterval(new Interval("min3"));
        intervals.addInterval(new Interval("p5"));
        assertEquals("maj3", intervals.getIntervalName(0));
        assertEquals("min3", intervals.getIntervalName(1));
        assertEquals("p5", intervals.getIntervalName(2));
    }

    @Test
    public void testGetIntervalDist() {
        intervals.addInterval(new Interval("maj3"));
        intervals.addInterval(new Interval("min3"));
        intervals.addInterval(new Interval("p5"));
        assertEquals(4, intervals.getIntervalDist(0));
        assertEquals(3, intervals.getIntervalDist(1));
        assertEquals(7, intervals.getIntervalDist(2));
    }

    @Test
    public void testGetLength() {
        intervals.addInterval(new Interval("p5"));
        assertEquals(1, intervals.getLength());
        intervals.addInterval(new Interval("maj7"));
        assertEquals(2, intervals.getLength());
        intervals.addInterval(new Interval("min3"));
        intervals.addInterval(new Interval("p8"));
        assertEquals(4, intervals.getLength());
    }

    @Test
    public void testInList() {
        Interval min3 = new Interval("min3");
        Interval p8 = new Interval("p8");
        intervals.addInterval(min3);
        assertTrue(intervals.inList(min3));
        assertFalse(intervals.inList(p8));
    }

}
