package es.javierdearcos.adventofcode2021.day1;

import org.junit.Test;

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

}