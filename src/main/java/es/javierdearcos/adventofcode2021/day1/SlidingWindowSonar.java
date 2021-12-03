package es.javierdearcos.adventofcode2021.day1;

import java.util.List;

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
