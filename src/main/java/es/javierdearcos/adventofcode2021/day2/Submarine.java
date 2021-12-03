package es.javierdearcos.adventofcode2021.day2;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntConsumer;

public class Submarine {

    private int horizontalPosition = 0;
    private int depth = 0;

    private final Map<Direction, IntConsumer> directionConsumers =
            Map.of(Direction.FORWARD, this::moveForward, Direction.UP, this::moveUp, Direction.DOWN, this::moveDown);

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void execute(List<SubmarineCommand> commands) {
        commands.forEach(this::execute);
    }

    public void execute(SubmarineCommand command) {
        IntConsumer directionConsumer =
                Optional.ofNullable(directionConsumers.get(command.getDirection()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid direction in command " + command));

        directionConsumer.accept(command.getQuantity());
    }

    private void moveForward(int quantity) {
        horizontalPosition += quantity;
    }

    private void moveUp(int quantity) {
        depth -= quantity;
    }

    private void moveDown(int quantity) {
        depth += quantity;
    }
}
