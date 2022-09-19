package org.ipan.gfg.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {

    @Test
    void rotate() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        ArrayTools.reverse(arr);
        assertArrayEquals(arr, new Integer[]{5, 4, 3, 2, 1});

        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5, 6};
        ArrayTools.reverse(arr1);

        assertArrayEquals(arr1, new Integer[]{6, 5, 4, 3, 2, 1});
    }

    @Test
    void testRotate() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        ArrayTools.rotate(arr, 3);
        assertArrayEquals(arr, new Integer[]{3, 4, 5, 1, 2});
    }

    @Test
    void moveZerosToTheRight() {
        int[] arr = new int[]{1, 2, 0, 0, 0, 3, 6};
        ArrayTools.moveZerosToTheRight(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 6, 0, 0, 0,});
    }
}