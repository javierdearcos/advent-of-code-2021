package es.javierdearcos.adventofcode2021.day2;

import es.javierdearcos.adventofcode2021.util.FileReader;

import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Submarine submarine = new Submarine();

        List<SubmarineCommand> commands = fileReader.read("/day2/sample.txt", SubmarineCommand::parseCommand);
        submarine.execute(commands);

        System.out.println("Solution Part1: " + submarine.getHorizontalPosition() * submarine.getDepth());

        SubmarineV2 submarineV2 = new SubmarineV2();

        submarineV2.execute(commands);

        System.out.println("Solution Part2: " + submarineV2.getHorizontalPosition() * submarineV2.getDepth());
    }
}
