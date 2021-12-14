package es.javierdearcos.adventofcode2021.day5;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testCreateHorizontalLine() {
        Line line = Line.create(new Point(5, 1), new Point(10,1));

        assertNotNull(line);
        assertEquals(6, line.length());

        line = Line.create(new Point(10, 1), new Point(5,1));

        assertNotNull(line);
        assertEquals(6, line.length());
    }

    @Test
    public void testCreateVerticalLine() {
        Line line = Line.create(new Point(5, 1), new Point(5,10));

        assertNotNull(line);
        assertEquals(10, line.length());

        line = Line.create(new Point(5, 10), new Point(5,1));

        assertNotNull(line);
        assertEquals(10, line.length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNonVerticalNonHorizontalLineShouldThrowException() {
        Line.create(new Point(5, 1), new Point(10,10));
    }

    @Test
    public void testGetOverlappingPointsVerticalLines() {
        Line line1 = Line.create(new Point(1, 1), new Point(1, 10));
        Line line2 = Line.create(new Point(1, 5), new Point(1, 6));

        List<Point> result = line1.getOverlappingPoints(line2);

        assertEquals(List.of(new Point(1, 5), new Point(1, 6)), result);
    }

    @Test
    public void testGetOverlappingPointsCrossedLines() {
        Line line1 = Line.create(new Point(1, 1), new Point(1, 10));
        Line line2 = Line.create(new Point(0, 5), new Point(10, 5));

        List<Point> result = line1.getOverlappingPoints(line2);

        assertEquals(Collections.singletonList(new Point(1, 5)), result);
    }
}