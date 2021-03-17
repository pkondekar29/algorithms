package com.prometheous.coding.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearchInGridTest {

    public static Stream<Arguments> all() {
        return Stream.of(
            Arguments.of(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE", true),
            Arguments.of(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABFDEE", true),
            Arguments.of(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ASEWIOFDL", false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test(char[][] b, String word, boolean exist) {
        assertEquals(exist, WordSearchInGrid.exist(b, word));
    }

}
