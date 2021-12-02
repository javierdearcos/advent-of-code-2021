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
import java.util.stream.IntStream;

/**
 * @author Javier de Arcos
 */
public class Sonar {

    public int sweep(List<Integer> measures) {

        return (int) IntStream.range(1, measures.size())
                .mapToObj(index -> new IntPair(measures.get(index - 1), measures.get(index)))
                .filter(pair -> pair.getSecondElement() > pair.getFirstElement())
                .count();
    }

    private static class IntPair {

        private final int firstElement;
        private final int secondElement;

        public IntPair(int firstElement, int secondElement) {
            this.firstElement = firstElement;
            this.secondElement = secondElement;
        }

        public int getFirstElement() {
            return firstElement;
        }

        public int getSecondElement() {
            return secondElement;
        }
    }
}
