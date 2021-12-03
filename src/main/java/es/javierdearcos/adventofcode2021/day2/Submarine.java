/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package es.javierdearcos.adventofcode2021.day2;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntConsumer;

/**
 * @author Javier de Arcos
 */
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
