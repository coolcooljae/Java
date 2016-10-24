package com.jinsol.misc;

/**
 * Created by jaejo on 7/3/16.
 *
 * working!!! 7/4 5pm
 * based on algorithm from https://en.wikipedia.org/wiki/Quickselect
 */

public class FindNthUsingQuickSelect {


    public static void main(String[] args) {

        int[] testdata1 = {3, 5, 12, 9, 1, 2, 15, 22, 4, 23, 6, 7};
        int[] testdata2 = {5, 1, 3, 2, 4};

        FindNthUsingQuickSelect mine = new FindNthUsingQuickSelect();
        int[] testInputArray = testdata2;
        int nthValue = mine.selectNth(testInputArray, 0, testInputArray.length-1, 4);
        System.out.println("nth value is " + nthValue);
    }


    // n is 1-based, 1..n
    int selectNth(int[] inputArray, int left, int right, int n) {

        if ( inputArray == null || inputArray.length <= n ) {
            throw new Error();
        }

        if ( left == right ) {
            return inputArray[left];
        }

        //todo: could change this later such as randomize
        int tempPivotIndex = left + (right - left)/2;

        int pivotIndex = partition(inputArray, left, right, tempPivotIndex);
        if ( (n-1) == pivotIndex ) {
            return inputArray[pivotIndex];
        }
        else if ( (n-1) < pivotIndex ) {
            return selectNth(inputArray, left, pivotIndex - 1, n);
        }
        //else if ( (n-1) > pivotIndex ) {
        else {
            return selectNth(inputArray, pivotIndex + 1, right, n);
        }
    }


    // find and return index where the pivot exists in order
    private int partition(int[] input, int left, int right, int pivotIndex) {

        int pivotValue = input[pivotIndex];

        // temp move the pivot value to the end
        swap(input, pivotIndex, right);

        // this index will eventually point to where the pivot should exists in order
        int tempIndex = left;

        for (int i = left; i < right; i++) {
            if ( input[i] < pivotValue ) {
                swap(input, i, tempIndex);
                tempIndex++;
            }
        }

        // move back the pivot value into the right spot
        swap(input, tempIndex, right);

        return tempIndex;
    }


    private void swap(int[] valueArray, int index1, int index2) {

        int tempValue = valueArray[index1];
        valueArray[index1] = valueArray[index2];
        valueArray[index2] = tempValue;
    }


}
