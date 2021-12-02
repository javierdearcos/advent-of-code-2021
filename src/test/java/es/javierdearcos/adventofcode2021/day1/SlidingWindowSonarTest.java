package es.javierdearcos.adventofcode2021.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SlidingWindowSonarTest {

    @Mock
    private Sonar sonar;

    @Test
    public void testSweep() {
        SlidingWindowSonar slidingWindowSonar = new SlidingWindowSonar(3, sonar);
        List<Integer> sample = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        slidingWindowSonar.sweep(sample);

        Mockito.verify(sonar).sweep(List.of(6, 9, 12, 15, 18, 21, 24, 17, 9));
    }
}