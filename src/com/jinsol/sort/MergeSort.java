package com.jinsol.sort;

import java.util.Arrays;

/**
 * Created by jaejo on 5/24/16.
 */
public class MergeSort extends AbstractSort {

    public static void main(String[] args) {

        MergeSort mySort = new MergeSort();
        mySort.testSort();
    }


    void sort(int[] input) {

        if ( input == null || input.length == 0 ) {
            return;
        }

        printList(sortMerged(input));
    }


    // because of return type (int []), created another method to sort
    int[] sortMerged(int[] input) {

        // first split the list into partitions
        int middleIndex = input.length / 2;
        //System.out.println("middleIndex = " + middleIndex);
        if ( middleIndex == 0 ) {
            // list w/ one entry, so stop
            return input;
        }
        else {
            int[] leftArray = Arrays.copyOfRange(input, 0, middleIndex);
            int[] rightArray = Arrays.copyOfRange(input, middleIndex, input.length);
            int[] sortedLeftArray = sortMerged(leftArray);
            int[] sortedRightArray = sortMerged(rightArray);
            int[] newArray = merge(sortedLeftArray, sortedRightArray);
            return newArray;
        }
    }

    //
    // precondition: both left and right lists are already sorted

    int[] merge(int[] leftList, int[] rightList) {

        int[] returnList = new int[leftList.length + rightList.length];
        int returnIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // go through both left & right lists, and fill in the return list w/ a smaller value
        while ( leftIndex < leftList.length && rightIndex < rightList.length ) {

            if ( leftList[leftIndex] < rightList[rightIndex] ) {
                returnList[returnIndex++] = leftList[leftIndex++];
            }
            else {
                returnList[returnIndex++] = rightList[rightIndex++];
            }
        }

        // either list would have hit the end, so fill in the rest if they exists
        while ( leftIndex < leftList.length ) {
            returnList[returnIndex++] = leftList[leftIndex++];
        }
        while ( rightIndex < rightList.length ) {
            returnList[returnIndex++] = rightList[rightIndex++];
        }

        return returnList;
    }
}
