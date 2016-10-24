package com.jinsol.misc;

import java.util.Random;

/**
 * Created by jaejo on 7/2/16.
 */
public class FindNthSmallestUsingSelectionSort {


    public static void main(String[] args) {

        FindNthSmallestUsingSelectionSort mine = new FindNthSmallestUsingSelectionSort();

        int[] testdata1 = {5, 4, 1, 2, 3};
        //findNthSmallest.find(testdata1, 2);
        int k = 5;
        int kthLargest = mine.quickselect(testdata1, k);
        System.out.println(k + "st/nd/th smallest number is " + kthLargest);
    }


    private int[] intArray;


    int quickselect(int[] input, int k) {
        return selectK(input, 0, input.length - 1, k - 1);
    }


    private int selectK(int[] myArray, int first, int last, int k) {

        if ( first <= last ) {

            int pivot = partition(myArray, first, last);
            if ( pivot == k ) {
                return myArray[k];
            }
            if ( pivot > k ) {
                return selectK(myArray, first, pivot - 1, k);
            }
            return selectK(myArray, pivot + 1, last, k);
        }

        return Integer.MIN_VALUE;
    }


    // quick select chooses pivot randomly
    // vs. median-of-medians selects pivot as median
    private int partition(int[] G, int first, int last) {

        int pivot = first + new Random().nextInt(last - first + 1);
        //int pivot = 1;
        swap(G, last, pivot);
        for ( int i = first; i < last; i++ ) {
            if (G[i] > G[last]) {
                swap(G, i, first);
                first++;
            }
        }
        swap(G, first, last);
        return first;
    }


    private void swap(int[] G, int x, int y) {
        int tmp = G[x];
        G[x] = G[y];
        G[y] = tmp;
    }


}
