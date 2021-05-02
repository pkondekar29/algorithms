package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTest {

    public static Stream<Arguments> all1() {
        return Stream.of(
                Arguments.of(new int[]{2,7,9,3,1}, 12),
                Arguments.of(new int[]{1,2,3,1}, 4)
        );
    }

    public static Stream<Arguments> all2() {
        return Stream.of(
                Arguments.of(new int[]{2,7,9,3,1}, 11),
                Arguments.of(new int[]{1,2,3}, 3),
                Arguments.of(new int[]{2,3,2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all1")
    public void test1(int[] a, int robbed) {
        assertEquals(HouseRobber.robI(a), robbed);
    }

    @ParameterizedTest
    @MethodSource(value = "all2")
    public void test2(int[] a, int robbed) {
        assertEquals(HouseRobber.robII(a), robbed);
    }

}
