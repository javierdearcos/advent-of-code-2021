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

import es.javierdearcos.adventofcode2021.util.FileReader;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Javier de Arcos
 */
public class Day5 {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        LineParser lineParser = new LineParser();
        DangerousAreasDetector dangerousAreasDetector = new DangerousAreasDetector();

        List<Optional<Line>> optionalLines =
                fileReader.read("/day5/sample.txt", lineParser::tryParse);

        List<Line> lines = optionalLines.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("Solution: " + dangerousAreasDetector.countDangerousAreas(lines));
    }
}
