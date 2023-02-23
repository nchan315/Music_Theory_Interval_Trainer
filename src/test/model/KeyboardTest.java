package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeyboardTest {

    private Keyboard kb;

    @BeforeEach
    public void setup() {
        kb = new Keyboard();
    }

    @Test
    public void testKeyboard() {
        assertEquals(12, kb.intervalRef.size());
    }

    @Test
    public void getIntervalRefTest() {
        assertEquals(0, kb.getIntervalRef("min2"));
        assertEquals(1, kb.getIntervalRef("maj2"));
        assertEquals(2, kb.getIntervalRef("min3"));
        assertEquals(3, kb.getIntervalRef("maj3"));
        assertEquals(4, kb.getIntervalRef("p4"));
        assertEquals(5, kb.getIntervalRef("aug4"));
        assertEquals(6, kb.getIntervalRef("dim5"));
        assertEquals(7, kb.getIntervalRef("p5"));
        assertEquals(8, kb.getIntervalRef("min6"));
        assertEquals(9, kb.getIntervalRef("maj6"));
        assertEquals(10, kb.getIntervalRef("min7"));
        assertEquals(11, kb.getIntervalRef("maj7"));
        assertEquals(12, kb.getIntervalRef("p8"));
    }

    @Test
    public void getNoteRefTest() {
        assertEquals(0, kb.getNoteRef("G"));
        assertEquals(1, kb.getNoteRef("G#"));
        assertEquals(2, kb.getNoteRef("A"));
        assertEquals(3, kb.getNoteRef("Bb"));
        assertEquals(4, kb.getNoteRef("B"));
        assertEquals(5, kb.getNoteRef("C"));
        assertEquals(6, kb.getNoteRef("C#"));
        assertEquals(7, kb.getNoteRef("D"));
        assertEquals(8, kb.getNoteRef("Eb"));
        assertEquals(9, kb.getNoteRef("E"));
        assertEquals(10, kb.getNoteRef("F"));
        assertEquals(11, kb.getNoteRef("F#"));
    }

    @Test
    public void getNoteNameTest() {
        assertTrue("G" == kb.getNoteName(0));
        assertTrue("G#" == kb.getNoteName(1));
        assertTrue("A" == kb.getNoteName(2));
        assertTrue("Bb" == kb.getNoteName(3));
        assertTrue("B" == kb.getNoteName(4));
        assertTrue("C" == kb.getNoteName(5));
        assertTrue("C#" == kb.getNoteName(6));
        assertTrue("D" == kb.getNoteName(7));
        assertTrue("Eb" == kb.getNoteName(8));
        assertTrue("E" == kb.getNoteName(9));
        assertTrue("F" == kb.getNoteName(10));
        assertTrue("F#" == kb.getNoteName(11));
        assertTrue("G" == kb.getNoteName(12));
        assertTrue("G#" == kb.getNoteName(13));
        assertTrue("A" == kb.getNoteName(14));
        assertTrue("Bb" == kb.getNoteName(15));
    }

    @Test
    public void getNextNoteTest() {
        assertEquals("E", kb.getNextNote("C", "maj3"));
        assertEquals("F#", kb.getNextNote("G", "maj7"));
        assertEquals("Fx", kb.getNextNote("G#", "maj7"));
        assertEquals("Eb", kb.getNextNote("Bb", "p4"));
        assertEquals("B", kb.getNextNote("D", "maj6"));
        assertEquals("Bbb", kb.getNextNote("Eb", "dim5"));
    }

}
