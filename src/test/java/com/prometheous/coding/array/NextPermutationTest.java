package com.prometheous.coding.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextPermutationTest {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        assertEquals("1 3 2", Arrays.stream(NextPermutation.nextPermutation(nums)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    @Test
    public void test3() {
        int[] nums = {8, 5, 4, 3, 2};
        assertEquals("2 3 4 5 8", Arrays.stream(NextPermutation.nextPermutation(nums)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    @Test
    public void test2() {
        int[] nums = {4, 5, 8, 3, 2};
        assertEquals("4 8 2 3 5", Arrays.stream(NextPermutation.nextPermutation(nums)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
