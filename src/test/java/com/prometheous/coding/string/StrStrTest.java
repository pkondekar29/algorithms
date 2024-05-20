package com.prometheous.coding.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrStrTest {

   @ParameterizedTest
   @CsvSource({ "Hello, ll, 2", "Wassup, February, -1", "Modelpondel, elpo, 3", " \"\", \"\", 0" })
   public void test(String s1, String s2, int index) {

      assertEquals(index, StrStr.strstr(s1, s2));
   }

}