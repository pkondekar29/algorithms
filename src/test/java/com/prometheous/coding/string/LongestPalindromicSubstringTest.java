package com.prometheous.coding.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestPalindromicSubstringTest {

    public static Stream<Arguments> all() {
        return Stream.of(
                Arguments.of("babab", 5),
                Arguments.of("babac", 3),
                Arguments.of("asdbajep", 1),
                Arguments.of("asdbjkffccffajlk", 6),
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test1(String str, int length) {
        String palindrome = LongestPalindromicSubstring.findLongestPalindromicSubstring(str);
        assertEquals(palindrome.length(), length);
        assertTrue(IsPalindrome.isPalindrome(palindrome));
    }

}
