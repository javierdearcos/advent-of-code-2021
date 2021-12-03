package es.javierdearcos.adventofcode2021.day2;

import java.util.Objects;

public class SubmarineCommand {

    private final Direction direction;
    private final int quantity;

    public SubmarineCommand(Direction direction, int quantity) {
        this.direction = direction;
        this.quantity = quantity;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getQuantity() {
        return quantity;
    }

    public static SubmarineCommand parseCommand(String command) {
        String[] commandParts = command.split(" ");

        if (commandParts.length != 2) {
            throw new IllegalArgumentException("Invalid command");
        }

        return new SubmarineCommand(Direction.parse(commandParts[0]), Integer.parseInt(commandParts[1]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmarineCommand that = (SubmarineCommand) o;
        return quantity == that.quantity && direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, quantity);
    }
}
