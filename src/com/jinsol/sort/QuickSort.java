package com.jinsol.sort;

/**
 * Created by jaejo on 6/13/16.
 */
public class QuickSort extends AbstractSort {

    public static void main(String[] args) {

        QuickSort mySort = new QuickSort();
        mySort.testSort();
    }


    private int[] intArray;


    void sort(int[] input) {

        if ( input == null || input.length == 0 ) {
            return;
        }

        intArray = input;
        sortQuick(0, input.length-1);
        printList(intArray);
    }


    private void sortQuick(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivotIndex = lowerIndex + (higherIndex - lowerIndex)/2;
        int pivot = intArray[pivotIndex];

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

        if ( lowerIndex < j ) {
            sortQuick(lowerIndex, j);
        }
        if ( i < higherIndex ) {
            sortQuick(i, higherIndex);
        }
    }


    private void swapTwoValues(int index1, int index2) {

        int tempValue = intArray[index1];
        intArray[index1] = intArray[index2];
        intArray[index2] = tempValue;
    }
}
