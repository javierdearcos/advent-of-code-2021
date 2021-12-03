package es.javierdearcos.adventofcode2021.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubmarineCommandTest {

    @Test
    public void parseForwardCommand() {
        String forwardCommand = "forward 5";
        SubmarineCommand expectedCommand = new SubmarineCommand(Direction.FORWARD, 5);

        SubmarineCommand result = SubmarineCommand.parseCommand(forwardCommand);

        assertEquals(expectedCommand, result);
    }

    @Test
    public void parseUpCommand() {
        String upCommand = "up 2";
        SubmarineCommand expectedCommand = new SubmarineCommand(Direction.UP, 2);

        SubmarineCommand result = SubmarineCommand.parseCommand(upCommand);

        assertEquals(expectedCommand, result);
    }

    @Test
    public void parseDownCommand() {
        String downCommand = "down 3";
        SubmarineCommand expectedCommand = new SubmarineCommand(Direction.DOWN, 3);

        SubmarineCommand result = SubmarineCommand.parseCommand(downCommand);

        assertEquals(expectedCommand, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseInvalidCommand() {
        String invalidCommand = "invalid 2";

        SubmarineCommand.parseCommand(invalidCommand);
    }
}