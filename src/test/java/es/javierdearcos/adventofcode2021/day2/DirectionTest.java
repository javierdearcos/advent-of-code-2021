package es.javierdearcos.adventofcode2021.day2;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void parseForwardShouldReturnForwardDirection() {
        assertEquals(Direction.FORWARD, Direction.parse("forward"));
    }

    @Test
    public void parseUpShouldReturnForwardDirection() {
        assertEquals(Direction.UP, Direction.parse("up"));
    }

    @Test
    public void parseDownShouldReturnForwardDirection() {
        assertEquals(Direction.DOWN, Direction.parse("down"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseInvalidValueShouldThrowIllegalArgumentException() {
        Direction.parse("invalid");
    }
}