package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardMatchingTest {

   public static Stream<Arguments> all() {

      return Stream.of(Arguments.of("aa", "a*", true), Arguments.of("ab", "ab", true), Arguments.of("abc", "?*", true),
            Arguments.of("aab", "c*a*b*", false), Arguments.of("aab", "ca*b*", false), Arguments.of("", "?", false),
            Arguments.of("aabbdeh", "aab*eh*", true), Arguments.of("aabbdeh", "aad*eh*", false),
            Arguments.of("aabbdeh", "aay*eh*", false), Arguments.of("adceb", "*a*b", true),
            Arguments.of("mississippi", "mis*is*p*?", true), Arguments.of("mississippi", "mis*is*ip*?", true));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void test1(String str, String pattern, boolean isMatch) {

      assertEquals(isMatch, WildcardMatching.isMatch(str, pattern));
   }

   @ParameterizedTest
   @MethodSource(value = "all")
   public void test2(String str, String pattern, boolean isMatch) {

      assertEquals(isMatch, WildcardMatching.isMatchDP(str, pattern));
   }

}
