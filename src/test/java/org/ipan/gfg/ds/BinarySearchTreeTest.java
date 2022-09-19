package org.ipan.gfg.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTreeTest {
    @Test
    public void insertTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
        bt.insert(100);
        bt.insert(20);
        bt.insert(10);
        bt.insert(30);
        bt.insert(40);
        bt.insert(500);
    }

    @Test
    public void uniqunesTest() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
        bt.insert(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bt.insert(1));
    }

    @Test
    public void inorder() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
        bt.insert(100);
        bt.insert(20);
        bt.insert(10);
        bt.insert(30);
        bt.insert(40);
        bt.insert(500);
        int[] arr = new int[6];

        int ind = 0;
        for (BinarySearchTree<Integer>.InOrderTraversalIterator it = bt.inOrderTraversal(); it.hasNext(); ind++) {
            Integer i = it.next();
            arr[ind] = i;
        }
        Assertions.assertArrayEquals(new int[]{10,20,30,40,100,500}, arr);
    }
}
