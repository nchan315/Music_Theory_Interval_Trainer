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
        assertTrue("G" == kb.getNoteName(12));
        assertTrue("G" == kb.getNoteName(24));
        assertTrue("C#" == kb.getNoteName(6));
        assertTrue("B" == kb.getNoteName(16));
    }


}
