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

package es.javierdearcos.adventofcode2021.day51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier de Arcos
 */
public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(Point from, Point to) {
        List<Point> points = new ArrayList<>();

        if (from.getX() == to.getX()) {
            int x = from.getX();

            for (int y = from.getY(); y <= to.getY(); y++) {
                points.add(new Point(x, y));
            }
        }
        else if (from.getY() == to.getY()) {
            int y = from.getY();

            for (int x = from.getX(); x <= to.getX(); x++) {
                points.add(new Point(x, y));
            }
        }
        else {
            throw new IllegalArgumentException("Not horizontal or vertical lines are not supported");
        }

        return new Line(points);
    }

    public List<Point> getPoints() {
        return this.points;
    }
}
