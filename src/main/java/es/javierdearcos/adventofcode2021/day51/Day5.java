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

import es.javierdearcos.adventofcode2021.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Javier de Arcos
 */
public class Day5 {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        List<Optional<Line>> optionalLines = fileReader.read("/day5/sample.txt", Day5::parseLine);

        List<Line> lines =
                optionalLines.stream()
                        .filter(optional -> !optional.isEmpty())
                        .map(Optional::get)
                        .collect(Collectors.toList());

        Map<Point, Integer> pointCounters = new HashMap<>();

        for (Line line: lines) {
            List<Point> points = line.getPoints();

            for(Point point: points) {

                pointCounters.merge(point, 1, Integer::sum);
            }
        }

        int result = 0;

        for (Integer counter: pointCounters.values()) {
            if (counter > 1) {
                result++;
            }
        }

        System.out.println("Solution: " + result);
    }

    private static Optional<Line> parseLine(String line) {
        // 0,9 -> 5,9
        String[] lineParts = line.split(" -> ");

        String[] pointsFrom = lineParts[0].split(",");
        String[] pointsTo = lineParts[1].split(",");

        try {
            return Optional.of(Line.create(new Point(Integer.parseInt(pointsFrom[0]), Integer.parseInt(pointsFrom[1])),
                    new Point(Integer.parseInt(pointsTo[0]), Integer.parseInt(pointsTo[1]))));
        } catch (IllegalArgumentException exception) {
            return Optional.empty();
        }
    }
}
