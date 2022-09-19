package org.ipan.gfg.ds;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Min heap -> parent <= children
// Max heap -> parent >= children
public class BinaryHeap<KEY> {
    private final Comparator<KEY> comparator;
    private final List<KEY> items;
    private final boolean isMaxHeap;

    public static <KEY> BinaryHeap<KEY> maxBinaryHeap(Comparator<KEY> comparator) {
        return new BinaryHeap<>(comparator, true);
    }

    public static <KEY> BinaryHeap<KEY> minBinaryHeap(Comparator<KEY> comparator) {
        return new BinaryHeap<>(comparator, false);
    }

    private BinaryHeap(Comparator<KEY> comparator, boolean isMaxHeap) {
        this.comparator = comparator;
        this.items = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    private int getParentIndex(int ind) {
        return ind / 2;
    }

    private int getLeftChildIndex(int ind) {
        return 2 * ind + 1;
    }

    private int getRightChildIndex(int ind) {
        return 2 * ind + 1;
    }

    public KEY getParent(KEY val) {
        KEY result = null;
        for (int i = 0; i < items.size(); i++) {
            if(val.equals(items.get(i))) {
                result = items.get(getParentIndex(i));
                break;
            }
        }

        return result;
    }

    public KEY getLeftChild(KEY val) {
        KEY result = null;
        for (int i = 0; i < items.size(); i++) {
            if (val.equals(items.get(i))) {
                int leftIndex = getLeftChildIndex(i);
                if (leftIndex < items.size()) {
                    result = items.get(leftIndex);
                }
                break;
            }
        }

        return result;
    }

    public KEY getRightChild(KEY val) {
        KEY result = null;
        for (int i = 0; i < items.size(); i++) {
            if (val.equals(items.get(i))) {
                int rightIndex = getRightChildIndex(i);
                if (rightIndex < items.size()) {
                    result = items.get(rightIndex);
                }
                break;
            }
        }

        return result;
    }

    public int getSize() {
        return items.size();
    }

    private void maxHeapify(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        int largest = index;

        int size = getSize();
        if (left < size && comparator.compare(items.get(left), items.get(index)) > 0) {
            largest = left;
        }
        if (left < size && comparator.compare(items.get(right), items.get(largest)) > 0) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int index1, int index2) {
        KEY temp = items.get(index2);
        items.set(index2, items.get(index1));
        items.set(index1, temp);
    }

    public KEY getMin() {
        KEY result = null;
        if (isMaxHeap) {

        } else {
            result = items.get(0);
        }
        return result;
    }

    public KEY getMax() {
        KEY result = null;
        if (isMaxHeap) {
            result = items.get(0);
        } else {

        }
        return result;
    }

    public KEY getRoot() {
        return items.get(0);
    }

    public KEY extractMax() {
        if (items.size() < 1) {
            throw new BufferUnderflowException();
        }
        KEY max = getRoot();
        items.set(0, items.remove(items.size() - 1));
        maxHeapify(0);
        return max;
    }

    public KEY decreaseKey() {}
    public KEY insert() {}
    public KEY delete() {}



}
