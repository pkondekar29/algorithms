package com.prometheous.coding.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchIn2DMatrixTest {

   static Stream<Arguments> arrayStream() {

      return Stream.of(Arguments.of(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 3, true),
            Arguments.of(new int[][] { { 1, 3, 5, 7, 9 }, { 10, 11, 16, 20, 22 }, { 23, 30, 34, 60, 90 } }, 7, true),
            Arguments.of(new int[][] { { 1, 3, 5, 7, 9 }, { 10, 11, 16, 20, 22 }, { 23, 30, 34, 60, 90 } }, 100, false),
            Arguments.of(new int[][] { { 1, 3, 5, 7, 9 }, { 10, 11, 16, 20, 22 }, { 23, 30, 34, 60, 90 } }, 0, false),
            Arguments.of(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 11, true),
            Arguments.of(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 60, true),
            Arguments.of(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 100, false),
            Arguments.of(new int[][] { { 1, 3 } }, 3, true), Arguments.of(new int[][] { { 1, 3 } }, 0, false));
   }

   @ParameterizedTest
   @MethodSource(value = "arrayStream")
   public void test(int[][] a, int target, boolean expected) {

      assertEquals(SearchIn2DMatrix.search(a, target), expected);
   }

   @ParameterizedTest
   @MethodSource(value = "arrayStream")
   public void testB(int[][] a, int target, boolean expected) {

      assertEquals(SearchIn2DMatrix.bSearch(a, target), expected);
   }
}
