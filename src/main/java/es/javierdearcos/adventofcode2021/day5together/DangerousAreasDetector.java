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

package es.javierdearcos.adventofcode2021.day5together;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Javier de Arcos
 */
public class DangerousAreasDetector {

    public int countDangerousAreas(List<Line> lines) {
        Map<Point, Integer> pointCounters = new HashMap<>();

        for (Line line: lines) {
            List<Point> points = line.getPoints();

            for(Point point: points) {

                pointCounters.merge(point, 1, Integer::sum);
            }
        }

        return (int) pointCounters.values().stream()
                .filter(counter -> counter > 1)
                .count();
    }
}
