package com.prometheous.coding.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterleavingWordsTest {

    public static Stream<Arguments> all() {
        return Stream.of(
            Arguments.of("aabcc", "dbbca", "aadbbcbcac", true),
            Arguments.of("", "b", "b", true),
            Arguments.of("", "", "", true),
            Arguments.of("aabcc", "dbbca", "bbcbcac", false),
            Arguments.of("aabcc", "dbbca", "aadbbcbcax", false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test(String s1, String s2, String s3, boolean possible) {
        assertEquals(InterleavingString.isInterLeave(s1, s2, s3), possible);
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void testMemo(String s1, String s2, String s3, boolean possible) {
        assertEquals(InterleavingString.isInterLeaveMemo(s1, s2, s3), possible);
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void testDP(String s1, String s2, String s3, boolean possible) {
        assertEquals(InterleavingString.isInterLeaveDP(s1, s2, s3), possible);
    }

}
