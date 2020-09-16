package com.example.sorting;

import java.util.Arrays;

public class MergeSort {

    /*
        1. Find the middle point of the array and divide it into two halves:
        2. recursively call mergeSort for first half:
        3. recursively call mergeSort for second half:
        4. Merge the two halves which has been sorted as above
     */
    private static void mergeSort(int[] input, int l, int r){
        if (l < r) {
            // Find the middle point of array
            //Avoid overflow, same as m = (l + r) /2
            int m = l + (r - l)/2;

            // sort the first halves and then the second
            mergeSort(input, l, m);
            mergeSort(input, m + 1, r);

            // merge the sorted halves
            merge(input, l, m, r);

        }

    }

    /*
        Merge two sub arrays
        value of the 1st sub array is from arr[l] to arr[m]
        value of the 2nd sub array is from arr[m+1] to arr[r]
     */
    private static void merge(int[] input, int l, int m, int r) {

        int sizeOfSubArr1 = m - l + 1;
        int sizeOfSubArr2 = r - m;

        // create two temp arrays
        int left[] = new int[sizeOfSubArr1];
        int right[] = new int[sizeOfSubArr2];

        // copy data to temp arrays
        for (int i=0; i < sizeOfSubArr1; i++){
            left[i] = input [l + i];
        }

        for (int j=0; j < sizeOfSubArr2; j++){
            right[j] = input [m + 1 + j];
        }

        int indexOfArr1 = 0;
        int indexOfArr2 = 0;

        int indexOfMergedArr = l;

        while ((indexOfArr1 < sizeOfSubArr1) && (indexOfArr2 < sizeOfSubArr2)){
            if (left[indexOfArr1] <= right[indexOfArr2]) {
                input[indexOfMergedArr] = left[indexOfArr1];
                indexOfArr1++;
            } else {
                input[indexOfMergedArr] = right[indexOfArr2];
                indexOfArr2++;
            }
            indexOfMergedArr++;
        }

        while (indexOfArr1 < sizeOfSubArr1){
            input[indexOfMergedArr] = left[indexOfArr1];
            indexOfArr1++;
            indexOfMergedArr++;
        }

        while (indexOfArr2 < sizeOfSubArr2){
            input[indexOfMergedArr] = right[indexOfArr2];
            indexOfArr2++;
            indexOfMergedArr++;
        }
    }

    // main method
    public static void main(String args[])
    {
        int arr[] = {609, 753, 21, 40, 18, 9800, 35};
        System.out.println("Input (Unsorted Array) : " + Arrays.toString(arr));

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Output (Sorted Array) : " + Arrays.toString(arr));
    }

}
