package es.javierdearcos.adventofcode2021.day1;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SonarTest {

    private final Sonar sonar = new Sonar();

    @Test
    public void testBasicSweep() {
        List<Integer> measures = List.of(199, 200, 208, 210, 200, 207, 240, 269, 260 ,263);

        int result = sonar.sweep(measures);

        assertEquals(7, result);
    }

    @Test
    public void testSweepWithEmptyList() {
        List<Integer> emptyMeasureList = Collections.emptyList();

        int result = sonar.sweep(emptyMeasureList);

        assertEquals(0, result);
    }

    @Test
    public void testSweepWithAllMeasuresIncreasing() {
        List<Integer> increasingMeasureList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result = sonar.sweep(increasingMeasureList);

        assertEquals(increasingMeasureList.size() - 1, result);
    }

    @Test
    public void testSweepWithAllMeasuresDecreasing() {
        List<Integer> decreasingMeasureList = List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);

        int result = sonar.sweep(decreasingMeasureList);

        assertEquals(0, result);
    }
}