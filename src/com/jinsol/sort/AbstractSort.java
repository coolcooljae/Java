package com.jinsol.sort;

/**
 * Created by jaejo on 5/24/16.
 */
public abstract class AbstractSort {

    static int[] INPUT0 = {8, 5, 6, 9, 7}; // already sorted
    static int[] INPUT1 = {1, 2, 3, 4, 5}; // already sorted
    static int[] INPUT2 = {5, 4, 3, 2, 1}; // reverse sorted
    static int[] INPUT3 = {3, 2, 5, 4, 1};
    static int[] INPUT4 = {4, 5, 3, 2, 1};
    static int[] INPUT5 = {2, 11, -33, 5, 202, 50, 7, 88};
    static int[] INPUT6 = {-3}; // single item
    static int[] INPUT7 = {7, 3}; // two items


//    AbstractSort sortObject = null; // initialize at the sub class

//    abstract void initSortObject();

    abstract void sort(int[] input);

    void printList(int[] list) {

        for(int i: list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    void testSort() {
//        sort(INPUT1);
//        sort(INPUT2);
//        sort(INPUT3);
//        sort(INPUT4);
//        sort(INPUT5);
//        sort(INPUT6);
//        sort(INPUT7);
        sort(INPUT0);
    }

}
