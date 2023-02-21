package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntervalTest {
    private Interval maj3;
    private Interval min6;

    @BeforeEach
    public void setup() {
        maj3 = new Interval("maj3");
        min6 = new Interval("min6");
    }

    @Test
    public void testInterval() {
        Interval min2 = new Interval("min2");
        assertEquals("min2", min2.getIntervalName());
        assertEquals(1, min2.getIntervalDistance());
    }

    @Test
    public void testGetDistance() {
        assertEquals(1, maj3.getDistance("min2"));
        assertEquals(2, maj3.getDistance("maj2"));
        assertEquals(3, maj3.getDistance("min3"));
        assertEquals(4, maj3.getDistance("maj3"));
        assertEquals(5, maj3.getDistance("p4"));
        assertEquals(6, maj3.getDistance("aug4"));
        assertEquals(6, maj3.getDistance("dim5"));
        assertEquals(7, maj3.getDistance("p5"));
        assertEquals(8, maj3.getDistance("min6"));
        assertEquals(9, maj3.getDistance("maj6"));
        assertEquals(10, maj3.getDistance("min7"));
        assertEquals(11, maj3.getDistance("maj7"));
        assertEquals(12, maj3.getDistance("p8"));
    }

    @Test
    public void testGetIntervalName() {
        assertEquals("maj3", maj3.getIntervalName());
        assertEquals("min6", min6.getIntervalName());
    }

    @Test
    public void testGetIntervalDistance() {
        assertEquals(4, maj3.getIntervalDistance());
        assertEquals(8, min6.getIntervalDistance());
    }
}
