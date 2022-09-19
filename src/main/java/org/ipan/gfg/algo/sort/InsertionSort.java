package org.ipan.gfg.algo.sort;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T current = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                    arr[j] = current;
                }
            }
        }
    }
}
