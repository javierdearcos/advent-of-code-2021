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
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Javier de Arcos
 */
public class SlidingWindowCollector implements Collector<Integer, List<SlidingWindow>, List<Integer>> {

    private final int slidingWindowCapacity;

    public static SlidingWindowCollector of(int slidingWindowCapacity) {
        return new SlidingWindowCollector(slidingWindowCapacity);
    }

    private SlidingWindowCollector(int slidingWindowCapacity) {
        this.slidingWindowCapacity = slidingWindowCapacity;
    }

    @Override
    public Supplier<List<SlidingWindow>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<SlidingWindow>, Integer> accumulator() {
        return (slidingWindows, measure) -> {
            slidingWindows.stream()
                    .dropWhile(SlidingWindow::isFull)
                    .forEach(slidingWindow -> {
                        slidingWindow.addMeasure(measure);
                    });

            SlidingWindow slidingWindow = new SlidingWindow(slidingWindowCapacity);
            slidingWindow.addMeasure(measure);
            slidingWindows.add(slidingWindow);
        };
    }

    @Override
    public BinaryOperator<List<SlidingWindow>> combiner() {
        return (slidingWindows1, slidingWindows2) -> {
            List<SlidingWindow> combinedSlidingWindows = new ArrayList<>(slidingWindows1);
            combinedSlidingWindows.addAll(slidingWindows2);
            return combinedSlidingWindows;
        };
    }

    @Override
    public Function<List<SlidingWindow>, List<Integer>> finisher() {
        return slidingWindows -> slidingWindows.stream()
                .map(SlidingWindow::sum)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
