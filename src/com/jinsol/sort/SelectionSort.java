package com.jinsol.sort;

/**
 * Created by jaejo on 5/23/16.
 */
public class SelectionSort extends AbstractSort {

    public static void main(String[] args) {

//        int[] inputIntArray = {6, 11, 9, 8, 7};
//        SelectionSort.sort(inputIntArray);

        SelectionSort mySort = new SelectionSort();
        mySort.testSort();
    }


    void sort(int[] input) {

        if ( input == null || input.length == 0 ) {
            return;
        }

        // perform selection sort
        // 1) find the lowest
        // 2) and put the lowest value into the most left unsorted portion
        // 3) repeat 1-2) for the unsorted portion

        for (int outerLoopIndex = 0; outerLoopIndex < input.length; outerLoopIndex++) {

            // find the lowest
            int lowestIndex = outerLoopIndex;
            for (int innerLoopIndex = outerLoopIndex+1; innerLoopIndex < input.length; innerLoopIndex++) {

                if ( input[innerLoopIndex] < input[lowestIndex]) {
                    lowestIndex = innerLoopIndex;
                }
            }

            // always swap
            int temp = input[outerLoopIndex];
            input[outerLoopIndex] = input[lowestIndex];
            input[lowestIndex] = temp;
        }

        printList(input);
    }
}
