package es.javierdearcos.adventofcode2021.day5;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class LineParserTest {

    private final LineParser lineParser = new LineParser();

    @Test
    public void testParseLine() {
        String line = "0,9 -> 5,9";
        Line expectedLine = Line.create(new Point(0, 9), new Point(5, 9));

        Line result = lineParser.parse(line);

        assertEquals(expectedLine, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseLineWithInvalidInput() {
        lineParser.parse("Invalid input");
    }

    @Test
    public void testTryParseLine() {
        String line = "0,9 -> 5,9";
        Line expectedLine = Line.create(new Point(0, 9), new Point(5, 9));

        Optional<Line> result = lineParser.tryParse(line);

        assertTrue(result.isPresent());
        assertEquals(expectedLine, result.get());
    }

    @Test
    public void testTryParseLineWithInvalidInput() {
        Optional<Line> result = lineParser.tryParse("Invalid input");

        assertTrue(result.isEmpty());
    }
}