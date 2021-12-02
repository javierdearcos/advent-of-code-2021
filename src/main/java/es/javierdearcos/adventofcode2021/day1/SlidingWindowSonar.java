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

package es.javierdearcos.adventofcode2021.day1;

import java.util.List;

/**
 * @author Javier de Arcos
 */
public class SlidingWindowSonar {

    private final int numberOfMeasuresPerWindow;
    private final Sonar sonar;

    public SlidingWindowSonar(int numberOfMeasuresPerWindow, Sonar sonar) {
        this.numberOfMeasuresPerWindow = numberOfMeasuresPerWindow;
        this.sonar = sonar;
    }

    public int sweep(List<Integer> measures) {
        List<Integer> sumOfSlidingWindows =
                measures.stream()
                        .collect(SlidingWindowCollector.of(numberOfMeasuresPerWindow));

        return sonar.sweep(sumOfSlidingWindows);
    }
}