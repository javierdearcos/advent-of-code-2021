package es.javierdearcos.adventofcode2021.day1;

import java.util.ArrayList;
import java.util.List;

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
