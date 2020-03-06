package ua.sonnet.controller.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortSearchResultMapTest {

    private Map<String, Integer> testMap;

    @BeforeEach
    private void setUp() {
        testMap = new HashMap<>();
        testMap.put("mama", 1);
        testMap.put("mila", 2);
        testMap.put("ramu", 3);
    }

    @Test
    public void shouldReturnSortedMap() {

        Map<String, Integer> actual = SortSearchResultMap.sortMapByValue(testMap);

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("ramu", 3);
        expected.put("mila", 2);
        expected.put("mama", 1);

        assertIterableEquals(expected.entrySet(), actual.entrySet());
    }

}