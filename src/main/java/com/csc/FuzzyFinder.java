package com.csc;

import java.util.List;

public class FuzzyFinder {

    // Linear search to find the index of the "gold" fuzzy
    public int linearSearchForGolden(List<Fuzzy> fuzzies) {
        for (int i = 0; i < fuzzies.size(); i++) {
            if (fuzzies.get(i).color.equals("gold")) {
                return i;
            }
        }
        return -1;
    }

    // Binary search to find the index of the "gold" fuzzy in a sorted list
    public int binarySearchForGolden(List<Fuzzy> fuzzies) {
        int left = 0;
        int right = fuzzies.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Fuzzy midFuzzy = fuzzies.get(mid);
            
            if (midFuzzy.color.equals("gold")) {
                return mid;
            } else if (midFuzzy.color.compareTo("gold") < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        FuzzyFinder finder = new FuzzyFinder();
        FuzzyListGenerator generator = new FuzzyListGenerator();

        List<Fuzzy> randomizedFuzzies = generator.randomizedRainbowFuzzies();
        List<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();

        // Run and print the results of linear search on randomized list
        int linearIndex = finder.linearSearchForGolden(randomizedFuzzies);
        System.out.println("Linear Search Result (Randomized): " + linearIndex);

        // Run and print the results of binary search on sorted list
        int binaryIndex = finder.binarySearchForGolden(sortedFuzzies);
        System.out.println("Binary Search Result (Sorted): " + binaryIndex);
    }
}

/**
 * ANALYSIS
 *
 * 1. Linear Search Analysis:
 *    - Linear search scans each element in the list sequentially.
 *    - Worst-case scenario: If the list has `n` elements, and the target element (e.g., the "gold" fuzzy)
 *      is at the last position or not present at all, linear search will perform `n` comparisons.
 *    - Time Complexity: O(n).
 *    - Explanation: In the worst-case scenario, the algorithm needs to check every item in the list.
 *
 * 2. Binary Search Analysis:
 *    - Binary search operates by repeatedly dividing a sorted list in half to locate the target.
 *    - Since binary search only works on sorted lists, the list must be sorted beforehand.
 *    - Worst-case scenario: If the list has `n` elements, binary search will take approximately
 *      `log2(n)` comparisons to find the element or determine it’s not in the list.
 *    - Time Complexity: O(log n).
 *    - Explanation: In the worst case, each step of the binary search reduces the list size by half.
 *      For example, with a list of 1 billion elements, binary search would take approximately 30 iterations.
 */
