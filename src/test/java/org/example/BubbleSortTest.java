package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void testSortRegularCase() {
        Integer[] input = {4, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 4, 5, 6, 9};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseSingleElement() {
        Integer[] input = {42};
        Integer[] expected = {42};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortEdgeCaseReversedArray() {
        Integer[] input = {9, 8, 7, 6, 5};
        Integer[] expected = {5, 6, 7, 8, 9};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortWithDuplicates() {
        Integer[] input = {3, 3, 1, 2, 2, 1};
        Integer[] expected = {1, 1, 2, 2, 3, 3};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortStrings() {
        String[] input = {"apple", "orange", "banana", "grape"};
        String[] expected = {"apple", "banana", "grape", "orange"};
        String[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortNegativeNumbers() {
        Integer[] input = {0, -1, -3, -2, -5};
        Integer[] expected = {-5, -3, -2, -1, 0};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result);
    }

}