package com.jinsol.misc;

/**
 * Created by jaejo on 7/2/16.
 */
public class FindMedianOfMediansOriginal {

    public static void main(String[] args) {

        FindMedianOfMediansOriginal mine = new FindMedianOfMediansOriginal();

        int[] testdata1 = {3, 5, 12, 9, 1, 2, 15, 22, 4, 23, 6, 7};
        int[] testdata2 = {3, 5, 12, 9, 22};
        int[] testdata3 = {7};
        int medianOfMedians = mine.find(testdata1);
        System.out.println("median of medians is " + medianOfMedians);
    }


    //
    // break input array into chunk of 5 elements, find median

    int find(int[] inputArray) {

        if ( inputArray == null || inputArray.length < 1 ) {
            return -999;
        }

        if ( inputArray.length <= 5 ) {
            return findMedian5(inputArray, 0, inputArray.length - 1);
        }
        else {
            for (int i=0; i < inputArray.length; i += 5) {
                int startIndex = i;
                int endIndex = i + 4;
                if ( endIndex > inputArray.length ) {
                    endIndex = inputArray.length - 1;
                }
                int valueFound = findMedian5(inputArray, startIndex, endIndex);
                System.out.println("median found from " +  startIndex + ":" + endIndex + " is " + valueFound);
            }
        }

        return -1;
    }

    // input array has at most 5 elements
    // because there are max 5 elements, use insertion sort to sort and find a median
    private int findMedian5(int[] input5, int left, int right) {

        // (0..index-1) is already sorted
        // find a right spot for input[index] from the biggest value, and insert
        int middleIndex = (right - left) / 2 + left;
        for (int index=left+1; index < right + 1; index++) {

            int currentValue = input5[index]; // save this value for later insertion
            int innerIndex = index - 1;
            for (; innerIndex >= 0; innerIndex--) {

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
        return input5[middleIndex];
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
