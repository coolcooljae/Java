package com.jinsol.sort;

import java.util.Random;

/**
 * Created by jaejo on 7/21/16.
 */
public class QuickSort2 extends AbstractSort {

    public static void main(String[] args) {

        QuickSort2 qsort = new QuickSort2();
        qsort.testSort();
    }

    private Random randomizer = new Random();

    void sort(int[] input) {

        if ( input == null || input.length == 0 ) {
            return;
        }

        if ( input.length > 1 ) {
            myQuickSort(input, 0, input.length-1);
        }
        printList(input);
    }

    // generate a random number between min and max values, both inclusive
    private int getRandomNumber(int min, int max) {

        return min + randomizer.nextInt(max - min +1);
    }

    private void swapTwo(int[] input, int firstIndex, int secondIndex) {

        int temp = input[firstIndex];
        input[firstIndex] = input[secondIndex];
        input[secondIndex] = temp;
    }


    private void myQuickSort(int[] input, int startIndex, int endIndex) {

        // tested randomizer
//        for(int i=0; i< 10; i++) {
//            System.out.println(getRandomNumber(5, 10));
//        }

        int pivot = getRandomNumber(startIndex, endIndex);
        int pivotValue = input[pivot];

        // search from both ends
        int i = startIndex;
        int k = endIndex;
        while ( i <= k ) {

            while ( input[i] < pivotValue ) {
                i++;
            }

            while ( input[k] > pivotValue ) {
                k--;
            }

            if ( i <= k ) {
                swapTwo(input, i, k);
                i++;
                k--;
            }
        }

        if ( i < endIndex ) {
            myQuickSort(input, i, endIndex);
        }
        if ( startIndex < k ) {
            myQuickSort(input, startIndex, k);
        }

    }
}
