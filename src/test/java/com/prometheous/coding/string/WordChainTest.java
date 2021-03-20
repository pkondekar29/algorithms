package com.prometheous.coding.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordChainTest {

    public static Stream<Arguments> all() {
        return Stream.of(
            Arguments.of(new String[] {"ams", "pqa", "swwmpa"}, true),
            Arguments.of(new String[] {"ams", "pqa", "bwwmpa"}, false),
            Arguments.of(new String[] {"ams", "pqa", "cwwmpa"}, false),
            Arguments.of(new String[] {"rqwrrwq", "qdkljp", "pqa", "awwmpa"}, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test(String[] words, boolean possible) {
        assertEquals(WordChain.isPossible(words), possible);
    }


}
