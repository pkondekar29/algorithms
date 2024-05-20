package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTest {

   public static Stream<Arguments> all() {

      return Stream.of(Arguments.of(new int[] { 10, 9, 2, 5, 3, 7, 1, 2 }, 3),
            Arguments.of(new int[] { 10, 9, 2, 5, 3, 7, 101, 110 }, 5),
            Arguments.of(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }, 4), Arguments.of(new int[] { 7, 3, 2, 1 }, 1),
            Arguments.of(new int[] { 87, 7, 7, 7 }, 1), Arguments.of(new int[] { 7, 7, 7, 7 }, 1));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void testLISMemo(int[] nums, int lic) {

      assertEquals(lic, LongestIncreasingSubsequence.findLongestIncreasingSubsequenceLengthMemo(nums));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void testLISDP(int[] nums, int lic) {

      assertEquals(lic, LongestIncreasingSubsequence.findLongestIncreasingSubsequenceLengthDP(nums));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void testLISDPEff(int[] nums, int lic) {

      assertEquals(lic, LongestIncreasingSubsequence.findLongestIncreasingSubsequenceLengthDPEff(nums));
   }

}
