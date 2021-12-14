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

package es.javierdearcos.adventofcode2021.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        if (Objects.equals(from.getX(), to.getX())) {
            int x = from.getX();
            for (int y = from.getY(); y <= to.getY(); y++) {
                points.add(new Point(x, y));
            }
        }
        else {
            int y = from.getY();
            for (int x = from.getX(); x <= to.getX(); x++) {
                points.add(new Point(x, y));
            }
        }

        return new Line(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points.get(0), line.points.get(0)) &&
                Objects.equals(points.get(points.size() - 1), line.points.get(line.points.size() - 1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
