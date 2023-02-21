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
