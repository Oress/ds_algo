package org.ipan.gfg.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    MergeSort<Integer> mergeSort = new MergeSort<>();

    @Test
    public void simple_test() {
        Integer[] arr = {64, 25, 12, 22, 11};
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
