package es.javierdearcos.adventofcode2021.day1;

import es.javierdearcos.adventofcode2021.util.FileReader;

import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Sonar sonar = new Sonar();

        List<Integer> measures = fileReader.read("/day1/sample.txt", Integer::parseInt);

        int solution = sonar.sweep(measures);

        System.out.println("Solution Part 1: " + solution);

        SlidingWindowSonar slidingWindowSonar = new SlidingWindowSonar(3, sonar);

        solution = slidingWindowSonar.sweep(measures);

        System.out.println("Solution Part 2: " + solution);
    }
}
