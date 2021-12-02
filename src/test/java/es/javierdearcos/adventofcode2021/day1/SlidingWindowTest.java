package es.javierdearcos.adventofcode2021.day1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingWindowTest {

    @Test
    public void testSlidingWindowIsFullWithOneMeasure() {
        SlidingWindow oneMeasureSlidingWindow = new SlidingWindow(1);

        assertFalse(oneMeasureSlidingWindow.isFull());

        oneMeasureSlidingWindow.addMeasure(5);

        assertTrue(oneMeasureSlidingWindow.isFull());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingSlidingWindowWithInvalidNumberOfMeasures() {
        new SlidingWindow(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingSlidingWindowWithZeroMeasures() {
        new SlidingWindow(0);
    }

    @Test
    public void testAddMeasureAndSumWithOneMeasureSlidingWindow() {
        SlidingWindow slidingWindow = new SlidingWindow(1);

        slidingWindow.addMeasure(5);

        assertEquals(5, slidingWindow.sum());
    }

    @Test
    public void testAddMeasureANdSumWithMoreThanOneMeasureSlidingWindow() {
        SlidingWindow slidingWindow = new SlidingWindow(3);

        slidingWindow.addMeasure(1);
        slidingWindow.addMeasure(2);
        slidingWindow.addMeasure(3);

        assertEquals(6, slidingWindow.sum());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddMeasuresOverCapacity() {
        SlidingWindow slidingWindow = new SlidingWindow(3);

        slidingWindow.addMeasure(1);
        slidingWindow.addMeasure(1);
        slidingWindow.addMeasure(1);
        slidingWindow.addMeasure(1);
    }
}