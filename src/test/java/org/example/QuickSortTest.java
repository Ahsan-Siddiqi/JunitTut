package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testSortWithRandomPivot() {
        Integer[] input = {8, 3, 7, 4, 9, 1};
        Integer[] expected = {1, 3, 4, 7, 8, 9};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortWithMiddlePivot() {
        Integer[] input = {10, 5, 3, 8, 2};
        Integer[] expected = {2, 3, 5, 8, 10};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortWithFirstPivot() {
        Integer[] input = {6, 2, 8, 4, 1};
        Integer[] expected = {1, 2, 4, 6, 8};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseSingleElement() {
        Integer[] input = {42};
        Integer[] expected = {42};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseReversedArray() {
        Integer[] input = {9, 8, 7, 6, 5};
        Integer[] expected = {5, 6, 7, 8, 9};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortWithDuplicates() {
        Integer[] input = {4, 4, 2, 3, 3, 1};
        Integer[] expected = {1, 2, 3, 3, 4, 4};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortStrings() {
        String[] input = {"pear", "apple", "orange", "banana"};
        String[] expected = {"apple", "banana", "orange", "pear"};
        String[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortNegativeNumbers() {
        Integer[] input = {0, -3, -1, -2, -5};
        Integer[] expected = {-5, -3, -2, -1, 0};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result);
    }

}