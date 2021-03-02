package com.prometheous.coding.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapWaterTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1,0,2,1,0,1,3,2,1,2,1:6;4,2,0,3,2,5:9"}, delimiter = ';')
    public void testWater(String waters) {
        String[] inputs = waters.split(":");
        String expected = inputs[1];
        int[] water = Arrays.asList(inputs[0].split(",")).stream().mapToInt(Integer::parseInt).toArray();

        assertEquals(Integer.parseInt(expected), TrapWater.trap(water));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,0,2,1,0,1,3,2,1,2,1:6;4,2,0,3,2,5:9"}, delimiter = ';')
    public void testWaterEff(String waters) {
        String[] inputs = waters.split(":");
        String expected = inputs[1];
        int[] water = Arrays.asList(inputs[0].split(",")).stream().mapToInt(Integer::parseInt).toArray();

        assertEquals(Integer.parseInt(expected), TrapWater.trapEff(water));
    }
}