package com.prometheous.coding.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JustifyStringsTest {

    @Test
    public void test1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> justified = JustifyStrings.justify(words, 16);
//        assertEquals(justified.stream().peek(System.out::println).map(String::length).filter(i -> i != 16).count(), 0);
        assertEquals("This    is    an", justified.get(0));
        assertEquals("example  of text", justified.get(1));
        assertEquals("justification.  ", justified.get(2));
    }
}
