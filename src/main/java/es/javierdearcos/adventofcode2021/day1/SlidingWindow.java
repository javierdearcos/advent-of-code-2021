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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier de Arcos
 */
public class SlidingWindow {

    private final int capacity;
    private final List<Integer> measures = new ArrayList<>();

    public SlidingWindow(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than 0");
        }

        this.capacity = capacity;
    }

    public boolean isFull() {
        return measures.size() == capacity;
    }

    public void addMeasure(int measure) {
        if (measures.size() == capacity) {
            throw new IllegalStateException("Sliding window capacity has been exceeded");
        }

        measures.add(measure);
    }

    public int sum() {
        return measures.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
