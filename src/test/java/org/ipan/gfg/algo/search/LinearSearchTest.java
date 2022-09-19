package org.ipan.gfg.algo.search;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinearSearchTest {

    @Test
    public void search_int() {
        LinearSearch<Integer> linearSearch = new LinearSearch<>();

        assertTrue(linearSearch.search(new Integer[]{1,2,3,4,5,6}, 1));
    }

    @Test
    public void search_int_index() {
        LinearSearch<Integer> linearSearch = new LinearSearch<>();

        assertEquals(0, linearSearch.searchIndex(new Integer[]{1,2,3,4,5,6}, 1));
    }

    @Test
    public void search_int_index_non_existing() {
        LinearSearch<Integer> linearSearch = new LinearSearch<>();

        assertEquals(-1, linearSearch.searchIndex(new Integer[]{1,2,3,4,5,6}, 10));
    }
}
