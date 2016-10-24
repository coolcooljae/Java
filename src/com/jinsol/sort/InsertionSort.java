package com.jinsol.sort;

public class InsertionSort extends AbstractSort {

    public static void main(String[] args) {

        //int[] inputIntArray = {11, 10, 9, 8, 7};

        InsertionSort mySort = new InsertionSort();
        mySort.testSort();
    }

    void sort(int[] input) {

        if ( input == null || input.length == 0 ) {
            return;
        }

        // (0..index-1) is already sorted
        // find a right spot for input[index] from the biggest value, and insert
        for (int index=1; index < input.length; index++) {

            int currentValue = input[index]; // save this value for later insertion
            int innerIndex = index - 1;
            for (; innerIndex >= 0; innerIndex--) {

                if ( currentValue < input[innerIndex] ) {
                    // move input[innerIndex] to one right
                    input[innerIndex+1] = input[innerIndex];
                    input[innerIndex] = currentValue;
                }
                else {
                    break;
                }
            }

            // insert based on the innerIndex
//            if ( innerIndex != 0 ) {
//                input[innerIndex] = currentValue;
//            }
        }

        printList(input);

//        // print
//        for(int i: input) {
//            System.out.print(i + ", ");
//        }
//        System.out.println();

    }//end of sort()

}
