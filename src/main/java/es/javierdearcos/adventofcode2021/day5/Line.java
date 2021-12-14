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
import java.util.stream.Collectors;

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

        /* Vertical line */
        if (from.getX() == to.getX()) {
            int x = from.getX();
            int yMax = Math.max(from.getY(), to.getY());

            for (int y = Math.min(from.getY(), to.getY()); y <= yMax; y++) {
                points.add(new Point(x, y));
            }
        }
        /* Horizontal line */
        else if (from.getY() == to.getY()){
            int y = from.getY();
            int xMax = Math.max(from.getX(), to.getX());

            for (int x = Math.min(from.getX(), to.getX()); x <= xMax; x++) {
                points.add(new Point(x, y));
            }
        }
        /* 45 degrees Diagonal line */
        else if (Math.abs(from.getX() - to.getX())/Math.abs(from.getY() - to.getY()) == 1) {
            Point initialPoint;
            Point endPoint;

            if (from.getX() <= to.getX()) {
                initialPoint = from;
                endPoint = to;
            } else {
                initialPoint = to;
                endPoint = from;
            }

            int yIncrement = initialPoint.getY() <= endPoint.getY() ? 1 : -1;

            for (int x = initialPoint.getX(), y = initialPoint.getY(); x <= endPoint.getX(); x++, y += yIncrement) {
                points.add(new Point(x, y));
            }
        }
        else {
            throw new IllegalArgumentException("Only horizontal, vertical and 45 degrees diagonal lines are supported");
        }

        return new Line(points);
    }

    public int length() {
        return points.size();
    }

    public List<Point> getOverlappingPoints(Line line) {
        return points.stream()
                .filter(line.points::contains)
                .collect(Collectors.toList());
    }
}
