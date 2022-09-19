package org.ipan.gfg.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortTest {
    InsertionSort<Integer> insertionSort = new InsertionSort<>();

    @Test
    public void simple_test() {
        Integer[] arr = {64, 25, 12, 22, 11};
        insertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
