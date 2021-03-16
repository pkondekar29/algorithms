package com.prometheous.coding.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplifyPathTest {

    @ParameterizedTest
    @CsvSource({
            "/home/, /home",
            "/../, /",
            "/home//foo/, /home/foo",
            "/a/./b/../../c/, /c"
    })
    public void test1(String path, String simplified) {
        assertEquals(simplified, SimplifyPath.simplify(path));
    }
}
