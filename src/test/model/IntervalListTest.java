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
        intervals.addInterval("min2");
        assertEquals(3,intervals.getLength());
    }

    @Test
    public void testRemoveInterval() {
        intervals.addAllIntervals();
        assertEquals(13, intervals.getLength());
        intervals.removeInterval("min2");
        assertEquals(12, intervals.getLength());
        intervals.removeInterval("min2");
        intervals.removeInterval("maj6");
        intervals.removeInterval("p8");
        assertEquals(10, intervals.getLength());
    }

    @Test
    public void testAllIntervalNames() {
        intervals.addInterval("min2");
        intervals.addInterval("p4");
        intervals.addInterval("maj6");
        String s = intervals.allIntervalNames();
        assertEquals("min2 p4 maj6 ", s);
    }

    @Test
    public void testRemoveAllIntervals() {
        intervals.removeAllIntervals();
        assertEquals(0, intervals.getLength());
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

    @Test
    public void testIsValid() {
        assertTrue(intervals.isValid("min2"));
        assertTrue(intervals.isValid("maj2"));
        assertTrue(intervals.isValid("min3"));
        assertTrue(intervals.isValid("maj3"));
        assertTrue(intervals.isValid("p4"));
        assertTrue(intervals.isValid("aug4"));
        assertTrue(intervals.isValid("dim5"));
        assertTrue(intervals.isValid("p5"));
        assertTrue(intervals.isValid("min6"));
        assertTrue(intervals.isValid("maj6"));
        assertTrue(intervals.isValid("min7"));
        assertTrue(intervals.isValid("maj7"));
        assertTrue(intervals.isValid("p8"));
        assertFalse(intervals.isValid("asdf"));
    }

    @Test
    public void testToStrJson() {
        assertEquals("{\"itv\":\"min2\"}", intervals.toStrJson("min2").toString());
    }

    @Test
    public void testIntervalsToJson() {
        intervals.addInterval("min2");
        intervals.addInterval("p4");
        intervals.addInterval("maj6");
        assertEquals("[{\"itv\":\"min2\"},{\"itv\":\"p4\"},{\"itv\":\"maj6\"}]",
                intervals.intervalsToJson().toString());
    }

    @Test
    public void testToJson() {
        intervals.addInterval("min2");
        intervals.addInterval("p4");
        intervals.addInterval("maj6");
        assertEquals("{\"intervals\":[{\"itv\":\"min2\"},{\"itv\":\"p4\"},{\"itv\":\"maj6\"}]}",
                intervals.toJson().toString());
    }

}
