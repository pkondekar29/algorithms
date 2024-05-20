package com.prometheous.coding.array;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationsTest {

   @Test
   public void test1() {

      int[] nums = { 1, 2, 3 };
      List<List<Integer>> l = Permutations.findPermutations(nums);

      assertEquals("1 2 3\n1 3 2\n",
            l.stream().map(el -> el.stream().map(String::valueOf).collect(Collectors.joining(" ")))
                  .collect(Collectors.joining("\n")));
   }

}
