package com.jinsol.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by jaejo on 7/20/16.
 */
public class FileRead {

    public static void main(String[] args) {

        // ./src/com/jinsol/file/input.txt: works
        // src/com/jinsol/file/input.txt: works
        // /src/com/jinsol/file/input.txt: does NOT work
        String filepath = "./src/com/jinsol/file/input.txt";

        // 1) classic way
//        try {
//            InputStream is = new FileInputStream(filepath); // FileNotFoundException
//            InputStreamReader isr = new InputStreamReader(is, "UTF-8"); //UnsupportedEncodingException
//            BufferedReader reader = new BufferedReader(isr);
//
//            String line = null;
//            while ( (line = reader.readLine()) != null ) {
//                System.out.println(line);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 2) new way using nio package
        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath), Charset.forName("UTF-8"));
//            for (String line: lines) {
//                System.out.println(line);
//            }

            if ( lines.size() < 4 ) {
                System.out.println("need more lines to test, so stopping now!");
                System.exit(11);
            }

            int testcaseCount = 0;
            try {
                testcaseCount = Integer.parseInt(lines.get(0));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.exit(12);
            }

            for (int t=0; t< testcaseCount; t++) {
                mergeTwoSortedLists(lines, t);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeTwoSortedLists(List<String> lines, int t) {

        String sizeOfTwoArraysStr = lines.get(1 + 3*t);
        StringTokenizer sto = new StringTokenizer(sizeOfTwoArraysStr);
        int array1size = 0;
        int array2size = 0;
        if ( sto.countTokens() == 2 ) {
            array1size = Integer.parseInt(sto.nextToken());
            array2size = Integer.parseInt(sto.nextToken());
        }

        String array1str = lines.get(2 + 3*t);
        String array2str = lines.get(3 + 3*t);
        int[] array1 = new int[array1size];
        int[] array2 = new int[array2size];

        sto = new StringTokenizer(array1str);
        int i = 0;
        while ( sto.hasMoreTokens() ) {
            array1[i++] = Integer.parseInt(sto.nextToken());
        }

        sto = new StringTokenizer(array2str);
        i = 0;
        while ( sto.hasMoreTokens() ) {
            array2[i++] = Integer.parseInt(sto.nextToken());
        }

        // now merge two lists
        // each list is already sorted in descending order, so I'll pick the highest (= most left) number
        // from each list, compare, and put higher value into the new list
        // repeat the above steps
        int[] mergedArray = new int[array1size + array2size];
        int index1 = 0;
        int index2 = 0;
        int n = 0;
        for (; n < mergedArray.length && index1 < array1.length && index2 < array2.length; n++) {

            if ( array1[index1] > array2[index2] ) {
                mergedArray[n] = array1[index1];
                index1++;
            }
            else {
                // value in the second array is bigger or same
                mergedArray[n] = array2[index2];
                index2++;
            }
            i++;
        }

        // one of the arrays still have values not used, so fill them up in the remaining of the merged array
        while ( n < mergedArray.length ) {
            if ( index1 < array1.length ) {
                mergedArray[n++] = array1[index1++];
            }
            else if ( index2 < array2.length ) {
                mergedArray[n++] = array2[index2++];
            }
        }

        // print
        System.out.println("\nmerge list:");
        for(int value: mergedArray) {
            System.out.print(value + " ");
        }
    }
}
