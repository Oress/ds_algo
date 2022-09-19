package org.ipan.gfg.algo.search;

public class LinearSearch<T> implements SearchAlgorithm<T> {

    @Override
    public int searchIndex(T[] arr, T value) {
        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            if (value.equals(arr[i])){
                result = i;
                break;
            }

        }

        return result;
    }
}
