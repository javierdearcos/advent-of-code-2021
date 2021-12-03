package es.javierdearcos.adventofcode2021.day2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    @Test
    public void testRead() {
        List<SubmarineCommand> expectedCommands =
                List.of(
                        new SubmarineCommand(Direction.FORWARD, 5),
                        new SubmarineCommand(Direction.DOWN, 5),
                        new SubmarineCommand(Direction.FORWARD, 8),
                        new SubmarineCommand(Direction.UP, 3),
                        new SubmarineCommand(Direction.DOWN, 8),
                        new SubmarineCommand(Direction.FORWARD, 2));

        List<SubmarineCommand> commands = fileReader.read("/day2/fileReaderSample.txt");

        assertEquals(expectedCommands, commands);
    }
}