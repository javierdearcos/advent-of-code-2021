package es.javierdearcos.adventofcode2021.day2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubmarineV2Test {

    @Test
    public void executeForwardDirectionShouldMoveSubmarineHorizontalPosition() {
        SubmarineV2 submarine = new SubmarineV2();
        SubmarineCommand forwardCommand = new SubmarineCommand(Direction.FORWARD, 2);

        submarine.execute(forwardCommand);

        assertEquals(2, submarine.getHorizontalPosition());
    }

    @Test
    public void executeUpDirectionShouldNotMoveSubmarineUntilMovingForward() {
        SubmarineV2 submarine = new SubmarineV2();
        SubmarineCommand upCommand = new SubmarineCommand(Direction.UP, 2);
        SubmarineCommand forwardCommand = new SubmarineCommand(Direction.FORWARD, 2);

        submarine.execute(upCommand);

        assertEquals(0, submarine.getDepth());

        submarine.execute(forwardCommand);

        assertEquals(-4, submarine.getDepth());
    }

    @Test
    public void executeUpDirectionShouldNotMoveSubmarineUntilMovingDown() {
        SubmarineV2 submarine = new SubmarineV2();
        SubmarineCommand downCommand = new SubmarineCommand(Direction.DOWN, 2);
        SubmarineCommand forwardCommand = new SubmarineCommand(Direction.FORWARD, 2);

        submarine.execute(downCommand);

        assertEquals(0, submarine.getDepth());

        submarine.execute(forwardCommand);

        assertEquals(4, submarine.getDepth());
    }

    @Test
    public void executeListOfCommandsShouldExecuteEachCommand() {
        SubmarineV2 submarine = new SubmarineV2();
        List<SubmarineCommand> commands =
                List.of(
                        new SubmarineCommand(Direction.DOWN, 5),
                        new SubmarineCommand(Direction.FORWARD, 5),
                        new SubmarineCommand(Direction.UP, 2),
                        new SubmarineCommand(Direction.FORWARD, 3));

        submarine.execute(commands);

        assertEquals(8, submarine.getHorizontalPosition());
        assertEquals(34, submarine.getDepth());
    }

}