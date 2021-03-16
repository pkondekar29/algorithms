package com.prometheous.coding.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchIn2DMatrixTest {

    static Stream<Arguments> arrayStream() {
        return Stream.of(
                Arguments.of(new int[][] { {1,3,5,7}, {10,11,16,20}, {23,30,34,60} }, 3, true),
                Arguments.of(new int[][] { {1,3,5,7}, {10,11,16,20}, {23,30,34,60} }, 13, false),
                Arguments.of(new int[][] { {1,3,5,7}, {10,11,16,20}, {23,30,34,60} }, 10, true),
                Arguments.of(new int[][] { {1,3,5,7}, {10,11,16,20}, {23,30,34,60} }, 60, true)
            );
    }

    static Stream<Arguments> arrayStreamSingle() {
        return Stream.of(
                Arguments.of(new int[][] { {1,3,5,7}, {10,11,16,20}, {23,30,34,60} }, 13, false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "arrayStream")
    public void test(int [][] a, int target, boolean expected) {
        assertEquals(SearchIn2DMatrix.search(a, target), expected);
    }

    @ParameterizedTest
    @MethodSource(value = "arrayStreamSingle")
    public void testSingle(int [][] a, int target, boolean expected) {
        assertEquals(SearchIn2DMatrix.search(a, target), expected);
    }

}
