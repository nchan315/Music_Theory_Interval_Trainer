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
    public void getNoteNameTest() {
        assertTrue("G" == kb.getNoteName(0));
        assertTrue("G#" == kb.getNoteName(1));
        assertTrue("A" == kb.getNoteName(2));
        assertTrue("A#" == kb.getNoteName(3));
        assertTrue("B" == kb.getNoteName(4));
        assertTrue("C" == kb.getNoteName(5));
        assertTrue("C#" == kb.getNoteName(6));
        assertTrue("D" == kb.getNoteName(7));
        assertTrue("D#" == kb.getNoteName(8));
        assertTrue("E" == kb.getNoteName(9));
        assertTrue("F" == kb.getNoteName(10));
        assertTrue("F#" == kb.getNoteName(11));
        assertTrue("G" == kb.getNoteName(12));
        assertTrue("G#" == kb.getNoteName(13));
        assertTrue("A" == kb.getNoteName(14));
        assertTrue("A#" == kb.getNoteName(15));
    }

    @Test
    public void getCorrectIntervalTest() {
        assertEquals("min2", kb.getCorrectInterval(3, 4));
        assertEquals("maj2", kb.getCorrectInterval(3, 5));
        assertEquals("min3", kb.getCorrectInterval(3, 6));
        assertEquals("maj3", kb.getCorrectInterval(3, 7));
        assertEquals("p4", kb.getCorrectInterval(3, 8));
        assertEquals("aug4", kb.getCorrectInterval(3, 9));
        assertEquals("p5", kb.getCorrectInterval(3, 10));
        assertEquals("min6", kb.getCorrectInterval(2, 10));
        assertEquals("maj6", kb.getCorrectInterval(1, 10));
        assertEquals("min7", kb.getCorrectInterval(0, 10));
        assertEquals("maj7", kb.getCorrectInterval(0, 11));
        assertEquals("p8", kb.getCorrectInterval(0, 12));
    }

    @Test
    public void getNextNoteTest() {
        assertEquals(6, kb.getNextNote(5, "min2"));
        assertEquals(10, kb.getNextNote(2, "min6"));
        assertEquals(11, kb.getNextNote(5, "dim5"));
        assertEquals(15, kb.getNextNote(3, "p8"));
    }

}
