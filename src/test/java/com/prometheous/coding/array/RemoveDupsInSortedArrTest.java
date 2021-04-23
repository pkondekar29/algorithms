package com.prometheous.coding.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDupsInSortedArrTest {

    public static Stream<Arguments> all() {
        return Stream.of(
                Arguments.of(new int[]{1,1,1,2,2,3,4,5}, 5, new int[]{1,2,3,4,5}),
                Arguments.of(new int[]{1,1,3,4,4,4,5}, 4, new int[]{1,3,4,5}),
                Arguments.of(new int[]{1,1,1,1,5}, 2, new int[]{1,5}),
                Arguments.of(new int[]{1,1,2,2,3,3,4,4}, 4, new int[]{1,2,3,4}),
                Arguments.of(new int[]{}, 0, new int[]{}),
                Arguments.of(new int[]{1,2,3,4,5}, 5, new int[]{1,2,3,4,5})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test(int[] a, int c, int[] res) {
        assertEquals(RemoveDupsInSortedArry.removeDuplicatesInSortedArr(a), c);
        assertArrayEquals(res, Arrays.copyOfRange(a, 0, c));
    }

}
