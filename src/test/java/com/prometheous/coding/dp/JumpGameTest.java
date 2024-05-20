package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGameTest {

   public static Stream<Arguments> all() {

      return Stream
            .of(Arguments.of(new int[] { 2, 3, 1, 1, 4 }, true), Arguments.of(new int[] { 3, 2, 1, 0, 4 }, false),
                  Arguments.of(new int[] { 2, 0 }, true));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void test(int[] a, boolean possible) {

      assertEquals(JumpGame.canJump(a), possible);
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void testRec(int[] a, boolean possible) {

      assertEquals(JumpGame.canJumpRec(a), possible);
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void testEff(int[] a, boolean possible) {

      assertEquals(JumpGame.canJumpEff(a), possible);
   }

}
