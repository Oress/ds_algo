package org.ipan.gfg.algo.search;

public class BinarySearch<T extends Comparable<T>> implements SearchAlgorithm<T> {
    @Override
    public int searchIndex(T[] arr, T value) {
        int result = -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compResult = value.compareTo(arr[mid]);
            if (compResult == 0) {
                result = mid;
                break;
            } else if (compResult > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
