package org.ipan.gfg.algo.search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    BinarySearch<Integer> binarySearch = new BinarySearch<>();

    @Test
    public void search_int() {

        assertTrue(binarySearch.search(new Integer[]{10, 20, 30, 50, 60, 80, 110, 130, 140, 170}, 110));
        assertFalse(binarySearch.search(new Integer[]{10, 20, 30, 40, 60, 110, 120, 130, 170}, 175));
    }

    @Test
    public void search_int_index() {
        assertEquals(0, binarySearch.searchIndex(new Integer[]{1,2,3,4,5,6}, 1));
    }

    @Test
    public void search_int_index_non_existing() {
        assertEquals(-1, binarySearch.searchIndex(new Integer[]{1,2,3,4,5,6}, 10));
    }
}
