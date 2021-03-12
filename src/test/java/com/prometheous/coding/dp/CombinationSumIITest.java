package com.prometheous.coding.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CombinationSumIITest {

    public static Stream<Arguments> all() {
        return Stream.of(Arguments.of(new int[]{1, 2}, 4));
    }

    @ParameterizedTest
    @MethodSource(value = "all")
    public void test(int[] a, int t) {
        CombinationSumII.combinationSum2(a, t);
        List<List<Integer>> res = CombinationSumII.ret;
        for (List<Integer> l : res) {
            l.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

}
