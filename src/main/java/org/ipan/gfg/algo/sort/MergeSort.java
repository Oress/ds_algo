package org.ipan.gfg.algo.sort;

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] arr) {
        sort(arr, new SortingMetrics(-1));
    }

    @Override
    public void sort(T[] arr, SortingMetrics metrics) {
        T[] sortedArr = mergeSort(arr, 0, arr.length - 1, metrics);
        System.arraycopy(sortedArr, 0, arr, 0, arr.length);
    }

    private T[] mergeSort(T[] arr, int start, int end, SortingMetrics metrics) {
        int length = end - start + 1;
        metrics.increaseReferenceCount(length);

        T[] sortedArr = (T[]) Array.newInstance(arr[0].getClass(), length);

        if (length == 1) {
            sortedArr[0] = arr[start];
            return sortedArr;
        }

//        [1,2,3] -> [1,2], [3]
//        [1,2,3,4] -> [1,2], [3, 4]
        int mid = (start + end) / 2;
        T[] leftPart = mergeSort(arr, start, mid, metrics);
        T[] rightPart = mergeSort(arr, mid + 1, end, metrics);

        int currentLeftIndex = 0;
        int currentRightIndex = 0;

        for (int i = 0; i < length; i++) {
            if (currentRightIndex == rightPart.length
                    || (currentLeftIndex != leftPart.length && leftPart[currentLeftIndex].compareTo(rightPart[currentRightIndex]) < 0)) {
                sortedArr[i] = leftPart[currentLeftIndex];
                currentLeftIndex++;
            } else {
                sortedArr[i] = rightPart[currentRightIndex];
                currentRightIndex++;
            }
        }

        return sortedArr;
    }
}

