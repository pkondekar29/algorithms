package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsInGridTest {

    private static Stream<Arguments> all() {
        return Stream.of(Arguments.of(1, 1, 1),
                Arguments.of(3, 2, 3),
                Arguments.of(3, 7, 28)
        );
    }

    @MethodSource(value = "all")
    @ParameterizedTest
    public void test(int m, int n, int paths) {
        assertEquals(paths, UniquePathsInGrid.findPaths(m, n));
    }
}
