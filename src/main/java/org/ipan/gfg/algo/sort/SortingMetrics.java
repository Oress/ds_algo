package org.ipan.gfg.algo.sort;

public class SortingMetrics {
    private int n = -1;
    private int referenceCount = 0;

    public SortingMetrics() {
    }

    public SortingMetrics(int n) {
        this.n = n;
    }

    public void increaseReferenceCount(int count) {
        referenceCount += count;
    }

    public int getN() {
        return n;
    }

    public int getReferenceCount() {
        return referenceCount;
    }
}
