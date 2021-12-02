package es.javierdearcos.adventofcode2021.day1;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SlidingWindowCollectorTest {

    @Test
    public void testCollect() {
        List<Integer> sample = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> result = sample.stream().collect(SlidingWindowCollector.of(3));

        assertEquals(List.of(6, 9, 12, 15, 18, 21, 24, 17, 9), result);
    }
}