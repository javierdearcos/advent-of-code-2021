package es.javierdearcos.adventofcode2021.day1;

import java.util.List;
import java.util.stream.IntStream;

public class Sonar {

    public int sweep(List<Integer> measures) {

        return (int) IntStream.range(1, measures.size())
                .mapToObj(index -> createMeasurePair(measures.get(index - 1), measures.get(index)))
                .filter(this::isPairIncreasing)
                .count();
    }

    private IntPair createMeasurePair(int firstMeasure, int secondMeasure) {
        return new IntPair(firstMeasure, secondMeasure);
    }

    private boolean isPairIncreasing(IntPair pair) {
        return pair.getSecondElement() > pair.getFirstElement();
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
