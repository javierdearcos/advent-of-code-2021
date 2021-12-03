package es.javierdearcos.adventofcode2021.day2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubmarineTest {

    @Test
    public void executeForwardDirectionShouldMoveSubmarineHorizontalPosition() {
        Submarine submarine = new Submarine();
        SubmarineCommand forwardCommand = new SubmarineCommand(Direction.FORWARD, 2);

        submarine.execute(forwardCommand);

        assertEquals(2, submarine.getHorizontalPosition());
    }

    @Test
    public void executeUpDirectionShouldMoveSubmarineDepth() {
        Submarine submarine = new Submarine();
        SubmarineCommand upCommand = new SubmarineCommand(Direction.UP, 2);

        submarine.execute(upCommand);

        assertEquals(-2, submarine.getDepth());
    }

    @Test
    public void executeDownDirectionShouldMoveSubmarineDepth() {
        Submarine submarine = new Submarine();
        SubmarineCommand downCommand = new SubmarineCommand(Direction.DOWN, 2);

        submarine.execute(downCommand);

        assertEquals(2, submarine.getDepth());
    }

    @Test
    public void executeListOfCommandsShouldExecuteEachCommand() {
        Submarine submarine = new Submarine();
        List<SubmarineCommand> commands =
                List.of(
                        new SubmarineCommand(Direction.DOWN, 5),
                        new SubmarineCommand(Direction.FORWARD, 5),
                        new SubmarineCommand(Direction.UP, 2));

        submarine.execute(commands);

        assertEquals(5, submarine.getHorizontalPosition());
        assertEquals(3, submarine.getDepth());
    }
}