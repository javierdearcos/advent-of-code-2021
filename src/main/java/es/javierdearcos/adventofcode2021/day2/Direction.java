package es.javierdearcos.adventofcode2021.day2;

import java.util.Map;
import java.util.Optional;

public enum Direction {

    FORWARD,
    UP,
    DOWN;

    private static final Map<String, Direction> stringValues =
            Map.of("forward", FORWARD, "up", UP, "down", DOWN);

    public static Direction parse(String value) {
        return Optional.ofNullable(stringValues.get(value))
                .orElseThrow(() -> new IllegalArgumentException("Invalid direction value"));
    }
}
