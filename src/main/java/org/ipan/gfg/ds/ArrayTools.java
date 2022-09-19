package org.ipan.gfg.ds;

import java.util.concurrent.Future;

public class ArrayTools {

    public static <T> void reverse(T[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            T temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }

    // Option 1: Temp array
    // Option 2: move one by one
    // Option 3: TODO Approach 3 (A Juggling Algorithm): This is an extension of method 2.
    // https://www.geeksforgeeks.org/array-rotation/
    public static <T> void rotate(T[] array, int steps) {
        int length = array.length;
        int actualSteps = steps % length;

        T temp1 = null, temp2 = null;
        for (int i = 0; i < length; i++) {
            int newPos = (i + actualSteps) % length;
            temp1 = array[newPos];
            array[newPos] = temp2 == null ? array[i] : temp2;
            temp2 = temp1;
        }
    }

    // Option 1: nested loop try every element with each other. O(n^2)
    // Option 2: hashmap - for each number m calculate sum - m and check whether it's in the hashmap O(n)
    // Option 3: sort array than ???
    public static boolean hasSum(int[] array, int sum) {
        Future<Integer> a
        return false;
    }

    // Option 1: For each element compare it with element to the right if it is a zero swap them O(n^2) - time O(1)
    // Option 2: Create temp arr. initialize it with 0. Copy all non zero values from init. to the first available position of copy. O(n), O(n)
    // Option 3: The one I didn't think of
    public static void moveZerosToTheRight(int[] array) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;

        while (true) {
            if (array[zeroIndex] != 0) {
                while (zeroIndex < array.length && array[zeroIndex] != 0) zeroIndex++;
            }
        }


    }
}
