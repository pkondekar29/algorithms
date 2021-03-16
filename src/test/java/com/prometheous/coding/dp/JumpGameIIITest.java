package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGameIIITest {

    public static Stream<Arguments> all() {
        return Stream.of(
            Arguments.of(new int[]{4,2,3,0,3,1,2}, 5, true),
            Arguments.of(new int[]{4,2,3,0,3,1,2}, 0, true),
            Arguments.of(new int[]{3,0,2,1,2}, 2, false),
            Arguments.of(new int[]{0,1}, 1, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void testEff(int[] a, int s, boolean possible) {
        assertEquals(JumpGameIII.canReachEff(a, s), possible);
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test(int[] a, int s, boolean possible) {
        assertEquals(JumpGameIII.isPossible(a, s), possible);
    }

}
