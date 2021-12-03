package es.javierdearcos.adventofcode2021.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileReader {

    public <T> List<T> read(String filePath, Function<String, T> lineFunction) {
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        return bufferedReader.lines()
                .map(lineFunction)
                .collect(Collectors.toList());
    }
}
