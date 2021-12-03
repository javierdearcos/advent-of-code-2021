package es.javierdearcos.adventofcode2021.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    @Test
    public void testRead() {
        List<Integer> expectedMeasures = List.of(199, 200, 208, 210, 200, 207, 240, 269, 260 ,263);

        List<Integer> readMeasures = fileReader.read("/fileReaderSample.txt", Integer::parseInt);

        assertEquals(expectedMeasures, readMeasures);
    }
}
