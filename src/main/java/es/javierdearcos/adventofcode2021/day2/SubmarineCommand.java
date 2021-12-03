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

import java.util.Objects;

/**
 * @author Javier de Arcos
 */
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
