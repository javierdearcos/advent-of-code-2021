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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Javier de Arcos
 */
public class FileReader {

    public List<SubmarineCommand> read(String filePath) {
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        return bufferedReader.lines()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private SubmarineCommand parseLine(String line) {
        String[] lineParts = line.split(" ");

        if (lineParts.length != 2) {
            throw new IllegalArgumentException("Invalid file");
        }

        return new SubmarineCommand(Direction.parse(lineParts[0]), Integer.parseInt(lineParts[1]));
    }
}
