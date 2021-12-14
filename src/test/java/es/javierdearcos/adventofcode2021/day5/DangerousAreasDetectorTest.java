package es.javierdearcos.adventofcode2021.day5;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DangerousAreasDetectorTest {

    private final DangerousAreasDetector dangerousAreasDetector = new DangerousAreasDetector();

    @Test
    public void testCountDangerousAreas() {
        List<Line> lines = List.of(
                Line.create(new Point(0, 9), new Point(5, 9)),
                Line.create(new Point(9, 4), new Point(3, 4)),
                Line.create(new Point(2, 2), new Point(2, 1)),
                Line.create(new Point(7, 0), new Point(7, 4)),
                Line.create(new Point(0, 9), new Point(2, 9)),
                Line.create(new Point(3, 4), new Point(1, 4)));

        int result = dangerousAreasDetector.countDangerousAreas(lines);

        assertEquals(5, result);
    }

    @Test
    public void testCountDangerousAreasWithDiagonalLines() {
        List<Line> lines = List.of(
                Line.create(new Point(0, 9), new Point(5, 9)),
                Line.create(new Point(8, 0), new Point(0, 8)),
                Line.create(new Point(9, 4), new Point(3, 4)),
                Line.create(new Point(2, 2), new Point(2, 1)),
                Line.create(new Point(7, 0), new Point(7, 4)),
                Line.create(new Point(0, 9), new Point(2, 9)),
                Line.create(new Point(6, 4), new Point(2, 0)),
                Line.create(new Point(3, 4), new Point(1, 4)),
                Line.create(new Point(0, 0), new Point(8, 8)),
                Line.create(new Point(5, 5), new Point(8, 2)));

        int result = dangerousAreasDetector.countDangerousAreas(lines);

        assertEquals(12, result);
    }
}