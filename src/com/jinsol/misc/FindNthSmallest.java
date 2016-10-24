package com.jinsol.misc;

import java.util.HashSet;

/**
 * Created by jaejo on 6/21/16.
 *
 * luxury solution that sorts the list first using HashSet and picks the nth smallest value
 */
public class FindNthSmallest {


    // n: 1..size of inputValues array
    // using HashSet

    static int findNthSmallestValue(int[] inputValues, int n) {

        if ( inputValues.length <= 0 || n < 0 || n > inputValues.length) {
            // throw exception
            return -1;
        }

        // have a valid input array and nth value
        // first create a HashSet which will be ordered
        HashSet<Integer> myHashset = new HashSet<Integer>();
        for (int index=0; index < inputValues.length; index++) {
            myHashset.add(new Integer(inputValues[index]));
        }

        // find the nth smallest value
        Object[] sortedValues = myHashset.toArray();

        // go through the sorted list
        for (Integer value : myHashset) {
            System.out.print(value + " ");
        }

        int returnValue = ((Integer) sortedValues[n-1]).intValue();
        return returnValue;
    }

    // assumptions
    // - no duplicate numbers exist
    // - numbers are integers, both + and -

    // 1. use HashSet: no space restrictions
    // 2. if n is small enough, use selection sort
    // 3. sort first from small to large using merge sort, and pick th nth smallest value


    public static void main(String[] args) {

        int[] testdata1 = {5, 3, 1, 4, 2};
        int secondSmallest = FindNthSmallest.findNthSmallestValue(testdata1, 2);
        System.out.println("\n2nd smallest valule = " + secondSmallest);

        int[] testdata2 = {2, 3, 5, 4, 1};
        System.out.println("\n5th smallest valule = " + FindNthSmallest.findNthSmallestValue(testdata2, 5));

        System.out.println("\n1st smallest valule = " + FindNthSmallest.findNthSmallestValue(testdata2, 1));

        // n > list size
        System.out.println("\n5th smallest valule = " + FindNthSmallest.findNthSmallestValue(testdata1, 6));

        // n < 0
        System.out.println("\n5th smallest valule = " + FindNthSmallest.findNthSmallestValue(testdata1, -2));

    }
}
