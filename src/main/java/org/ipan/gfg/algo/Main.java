package org.ipan.gfg.algo;

import org.ipan.gfg.algo.sort.MergeSort;
import org.ipan.gfg.algo.sort.SortingMetrics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(100);
        List<SortingMetrics> metrics = new ArrayList<>();

        MergeSort<Integer> mergeSort = new MergeSort<>();

        for (int i = 1; i < 5; i++) {
            int base = (int) Math.pow(10, i);
            for (int j = 1; j <= 10; j++) {
                int arrCount = base * j;
                SortingMetrics metrics1 = new SortingMetrics(arrCount);
                metrics.add(metrics1);
                Integer[] sampleArr = createArray(arrCount);
                Runnable runnable = () -> mergeSort.sort(sampleArr, metrics1);
                Thread t = new Thread(runnable);
                threads.add(t);
                t.start();
            }
        }
        try {
            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try(OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream("data.csv"))) {
            os.append("N,ReferenceCount\n");

            for (SortingMetrics metric : metrics) {
                os.append(String.format("%1$s,%2$s\n", metric.getN(), metric.getReferenceCount()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private static Integer[] createArray(int n) {
        Integer[] result = new Integer[n];
        for (int i = n; i > 0 ; i--) {
            result[n - i] = i;
        }
        return result;
    }
}
