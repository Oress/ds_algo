package org.ipan.gfg.ds;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class BinaryTreeTest {
    @Test
    public void fromHeapTest() {
        BinaryTree<Integer> bt = BinaryTree.fromHeapArray(new Integer[]{1,2,3,4,5,6,7,8});
        System.out.println(bt);
        for (Iterator<Integer> it = bt.preOrderTraversal(); it.hasNext(); ) {
            Integer i = it.next();
            System.out.println(i.toString());
        }
    }
}
