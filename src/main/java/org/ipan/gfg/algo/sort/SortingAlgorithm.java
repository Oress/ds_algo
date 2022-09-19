package org.ipan.gfg.algo.sort;

// Bubble sort is a piece of shit and I don't want to know it.
public interface SortingAlgorithm<T extends Comparable<T>> {
    void sort(T[] arr);
    default void sort(T[] arr, SortingMetrics metrics) { sort(arr);};
}
