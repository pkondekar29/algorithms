package com.prometheous.coding.design;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LRUCacheTest {

   public static Stream<Arguments> all() {

      return Stream.of(Arguments.of('p', 1, 1, -1), Arguments.of('p', 2, 2, -1), Arguments.of('g', 1, null, 1),
            Arguments.of('p', 3, 3, -1), Arguments.of('g', 2, null, 2), Arguments.of('p', 4, 1, -1),
            Arguments.of('p', 1, 1, -1));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void testCache(Character type, int k, Integer v, Integer expected) {

      LRUCache cache = new LRUCache(2);
   }
}
