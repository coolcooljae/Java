package com.jinsol.misc;

import java.util.Random;

/**
 * Created by jaejo on 7/2/16.
 */
public class FindNthSmallestUsingQuickSort {


    public static void main(String[] args) {

        FindNthSmallestUsingQuickSort findNthSmallest = new FindNthSmallestUsingQuickSort();

        int[] testdata1 = {5, 4, 1, 2, 3};
        //findNthSmallest.find(testdata1, 2);
        int k = 3;
        int kthLargest = findNthSmallest.quickselect(testdata1, k);
        System.out.println(k + "st/nd/th largest number is " + kthLargest);
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


    private int partition(int[] G, int first, int last) {

        int pivot = first + new Random().nextInt(last - first + 1);
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




    //
    // mine


    void find(int[] input, int n) {

        if ( input == null || input.length == 0 ) {
            return;
        }

        if ( n < 1 || n > input.length ) {
            return;
        }

        intArray = input;
        findNthSmallest(0, input.length-1, n);
        //printList();
    }


    // pivotIndex is 1 based, 1..n
    private void findNthSmallest(int lowerIndex, int higherIndex, int pivotIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        //int pivotIndex = lowerIndex + (higherIndex - lowerIndex)/2;
        int pivot = intArray[pivotIndex-1];

        // look for a number from left side of pivot which is > pivot
        // look for a number from right side of pivot which is < pivot
        // then swap these two
        while ( i <= j ) {

            while ( intArray[i] < pivot ) {
                i++;
            }
            while ( intArray[j] > pivot ) {
                j--;
            }

            if ( i <= j ) {
                swapTwoValues(i, j);
                i++;
                j--;
            }
        }

        printList();

//        if ( lowerIndex < j ) {
//            findNthSmallest(lowerIndex, j);
//        }
//        if ( i < higherIndex ) {
//            findNthSmallest(i, higherIndex);
//        }
    }


    private void swapTwoValues(int index1, int index2) {

        int tempValue = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = tempValue;
    }


    private void printList() {

        for(int i: this.intArray) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}
