package com.jinsol.misc;


/**
 * Created by jaejo on 7/2/16.
 *
 * working!!! 7/3/2016
 * based on https://www.quora.com/What-is-the-most-efficient-algorithm-to-find-the-kth-smallest-element-in-an-array-having-n-unordered-elements
 */

public class FindMedianOfMedians {

    public static void main(String[] args) {

        FindMedianOfMedians mine = new FindMedianOfMedians();

        int[] testdata1 = {3, 5, 12, 9, 1, 2, 15, 22, 4, 23, 6, 7};
        int[] testdata2 = {21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] testdata3 = {7};

        int[] inputData = testdata2;
        int medianOfMedians = mine.find(inputData, 0, inputData.length-1);
        System.out.println("median of medians is input[" + medianOfMedians + "]= " + inputData[medianOfMedians]);
    }


    //
    // break input array into chunk of 5 elements, find median

    int find(int[] inputArray, int startIndex, int endIndex) {

        if ( inputArray == null || inputArray.length < 1 ) {
            return -999;
        }

        // if chunk size <= 5, then find a median after sorting it
        if ( (endIndex - startIndex + 1) <= 5 ) {
            sort5(inputArray, startIndex, endIndex);
            return (startIndex + endIndex) / 2;
        }

        // chunk size > 5, so divide and conquer
        for (int i=0; i <= (endIndex + 1)/5; i++) {
            int left = 5 * i;
            int right = left + 4;
            if ( right > endIndex ) {
                right = endIndex;
            }
            int medianFound = find(inputArray, left, right);
            System.out.println("median found from " +  left + ":" + right + " is input[" + medianFound + "]= " + inputArray[medianFound]);
            swap(inputArray, i, medianFound);
        }

        return find(inputArray, 0, (endIndex + 1)/5);
    }


    // input array has at most 5 elements
    // because there are max 5 elements, use insertion sort to sort and find a median
    private void sort5(int[] input5, int left, int right) {

        // (0..index-1) is already sorted
        // find a right spot for input[index] from the biggest value, and insert
        for (int index=left+1; index < right + 1; index++) {

            int currentValue = input5[index]; // save this value for later insertion
            int innerIndex = index - 1;
            for (; innerIndex >= left; innerIndex--) {

                if ( currentValue < input5[innerIndex] ) {
                    // move input[innerIndex] to one right
                    input5[innerIndex+1] = input5[innerIndex];
                    input5[innerIndex] = currentValue;
                }
                else {
                    break;
                }
            }
        }
    }


    private void swap(int[] valueArray, int index1, int index2) {

        int tempValue = valueArray[index1];
        valueArray[index1] = valueArray[index2];
        valueArray[index2] = tempValue;
    }



    // from https://www.quora.com/What-is-the-most-efficient-algorithm-to-find-the-kth-smallest-element-in-an-array-having-n-unordered-elements

//    //selects the median of medians in an array
//    static int selection(int a[], int s, int e, int k){
//        // if the partition length is less than or equal to 5
//        // we can sort and find the kth element of it
//        // this way we can find the median of n/5 partitions
//        if(e-s+1 <= 5){
//            Arrays.sort(a,s, e);
//            return s+k-1;
//        }
//
//       /* if array is bigger we partition the array in sub-arrays of size 5
//     no. of partitions = n/5 = (e+1)/5 iterate through each partition and recursively
//    calculate the median of all of them and keep putting the medians in the
//    starting of the array
//  */
//
//    for(int i=0; i<(e+1)/5; i++){
//        int left = 5*i;
//        int right = left + 4;
//        if(right > e) right = e;
//        //left+(right-left)/2 median will be 3rd element e.g.ar[2] in zero index based array
//        int median = selection(a,left, right, 2);
//        swap(a[median], a[i]);
//    }
//
//    /*now we have array  a[0] = median of 1st 5 sized partition a[1] = median of
//      2nd 5 sized partition and so on till n/5 to find out the median of these n/5
//      medians we need to select the n/10th element of this set (i.e. middle of it)
//   */
//    return selection(a, 0, (e+1)/5, ((e+1)/10));
//}




}
