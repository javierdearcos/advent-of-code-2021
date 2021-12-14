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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Javier de Arcos
 */
public class LineParser {

    private final Pattern pattern = Pattern.compile("^(\\d),(\\d) -> (\\d),(\\d)$");

    public Line parse(String line) {
        Matcher matcher = pattern.matcher(line);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Line format is invalid");
        }

        return Line.create(createPoint(matcher.group(1), matcher.group(2)), createPoint(matcher.group(3), matcher.group(4)));
    }

    private Point createPoint(String x, String y) {
        return new Point(Integer.parseInt(x), Integer.parseInt(y));
    }
}
