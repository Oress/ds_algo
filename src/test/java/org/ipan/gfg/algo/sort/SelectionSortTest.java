package org.ipan.gfg.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SelectionSortTest {
    SelectionSort<Integer> selectionSort = new SelectionSort<>();

    @Test
    public void simple_test() {
        Integer[] arr = {64, 25, 12, 22, 11};
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
