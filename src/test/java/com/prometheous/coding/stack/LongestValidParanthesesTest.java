package com.prometheous.coding.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParanthesesTest {

    @ParameterizedTest
    @CsvSource(value = {"((),2", ")()()),4", ")((())()())((),10"})
    public void testParantheses(String str, String value) {
        assertEquals(Integer.parseInt(value), LongestValidParantheses.findLongestValidParanthes(str));
    }

    @ParameterizedTest
    @CsvSource(value = {")((())()())((),10"})
    public void testParanthesesEff(String str, String value) {
        assertEquals(Integer.parseInt(value), LongestValidParantheses.findLongestValidParanthesEff(str));
    }
}
