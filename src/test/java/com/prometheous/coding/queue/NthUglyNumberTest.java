package com.prometheous.coding.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NthUglyNumberTest {

   private static Stream<Arguments> all() {

      return Stream
            .of(Arguments.of(1, 1), Arguments.of(2, 2), Arguments.of(3, 3), Arguments.of(7, 8), Arguments.of(9, 10),
                  Arguments.of(10, 12), Arguments.of(11, 15), Arguments.of(12, 16), Arguments.of(39, 135));
   }

   @MethodSource(value = "all")
   @ParameterizedTest
   public void test2(int n, int nNum) {

      assertEquals(nNum, NthUglyNumber.findNthUglyNumberEff(n));
   }

}
