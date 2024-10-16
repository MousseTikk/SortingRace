package esi.atl.g56583.sortingrace.model;

import esi.atl.g54027.sortingrace.model.sorts.*;
import esi.atl.g56583.sortingrace.model.sorts.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortsTest {

    @Test
    public void testMergeSortEmptyArray() {
        int[] array = {};
        new Merge().sort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortOneElement() {
        int[] array = {1};
        new Merge().sort(array);
        int[] expected = {1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortMultipleElementOrder() {
        int[] array = {1, 2, 3, 5, 9, 10};
        new Merge().sort(array);
        int[] expected = {1, 2, 3, 5, 9, 10};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortMultipleElementUnOrder() {
        int[] array = {-15, 5, -17, 9, 10, 1000, -198};
        new Merge().sort(array);
        int[] expected = {-198, -17, -15, 5, 9, 10, 1000};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] array = {};
        new Bubble().sort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortOneElement() {
        int[] array = {1};
        new Bubble().sort(array);
        int[] expected = {1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortMultipleElementOrder() {
        int[] array = {1, 2, 3, 5, 9, 10};
        new Bubble().sort(array);
        int[] expected = {1, 2, 3, 5, 9, 10};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortMultipleElementUnOrder() {
        int[] array = {-15, 5, -17, 9, 10, 1000, -198};
        new Bubble().sort(array);
        int[] expected = {-198, -17, -15, 5, 9, 10, 1000};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortEmptyArray() {
        int[] array = {};
        new Selection().sort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortOneElement() {
        int[] array = {1};
        new Selection().sort(array);
        int[] expected = {1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortMultipleElementOrder() {
        int[] array = {1, 2, 3, 5, 9, 10};
        new Selection().sort(array);
        int[] expected = {1, 2, 3, 5, 9, 10};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortMultipleElementUnOrder() {
        int[] array = {-15, 5, -17, 9, 10, 1000, -198};
        new Selection().sort(array);
        int[] expected = {-198, -17, -15, 5, 9, 10, 1000};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortEmptyArray() {
        int[] array = {};
        new Insertion().sort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortOneElement() {
        int[] array = {1};
        new Insertion().sort(array);
        int[] expected = {1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortMultipleElementOrder() {
        int[] array = {1, 2, 3, 5, 9, 10};
        new Insertion().sort(array);
        int[] expected = {1, 2, 3, 5, 9, 10};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortMultipleElementUnOrder() {
        int[] array = {-15, 5, -17, 9, 10, 1000, -198};
        new Insertion().sort(array);
        int[] expected = {-198, -17, -15, 5, 9, 10, 1000};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortEmptyArray() {
        int[] array = {};
        new Quick().sort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortOneElement() {
        int[] array = {1};
        new Quick().sort(array);
        int[] expected = {1};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortMultipleElementOrder() {
        int[] array = {1, 2, 3, 5, 9, 10};
        new Quick().sort(array);
        int[] expected = {1, 2, 3, 5, 9, 10};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortMultipleElementUnOrder() {
        int[] array = {-15, 5, -17, 9, 10, 1000, -198};
        new Quick().sort(array);
        int[] expected = {-198, -17, -15, 5, 9, 10, 1000};
        assertArrayEquals(expected, array);
    }
}
