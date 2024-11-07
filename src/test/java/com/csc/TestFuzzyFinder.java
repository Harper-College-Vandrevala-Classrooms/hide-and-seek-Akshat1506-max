package com.csc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

    FuzzyFinder finder;
    FuzzyListGenerator generator;

    @BeforeEach
    void setUp() {
        finder = new FuzzyFinder();
        generator = new FuzzyListGenerator();
    }

    @Test
    void testLinearSearchForGolden() {
        List<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
        int index = finder.linearSearchForGolden(fuzzies);
        assertTrue(index >= 0, "Golden fuzzy not found in randomized list using linear search");
        assertEquals("gold", fuzzies.get(index).color);
    }

    @Test
    void testBinarySearchForGolden() {
        List<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
        int index = finder.binarySearchForGolden(fuzzies);
        assertTrue(index >= 0, "Golden fuzzy not found in sorted list using binary search");
        assertEquals("gold", fuzzies.get(index).color);
    }
}