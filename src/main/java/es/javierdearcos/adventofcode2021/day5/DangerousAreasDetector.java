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

import java.util.HashSet;
import java.util.List;

/**
 * @author Javier de Arcos
 */
public class DangerousAreasDetector {

    public int countDangerousAreas(List<Line> lines) {
        HashSet<Point> overlappedPoints = new HashSet<>();

        for (int i = 0; i < lines.size() - 1; i++) {
            Line line = lines.get(i);
            for (int j = i + 1; j < lines.size(); j++) {
                overlappedPoints.addAll(line.getOverlappingPoints(lines.get(j)));
            }
        }

        return overlappedPoints.size();
    }
}
