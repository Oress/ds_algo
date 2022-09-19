package org.ipan.gfg.algo.search;

public interface SearchAlgorithm<T> {
    default boolean search(T[] arr, T value) {return this.searchIndex(arr, value) != -1;}
    default int searchIndex(T[] arr, T value) {return -1;}
}
