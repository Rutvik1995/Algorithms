package com.blogspot.vikkyrk.sort;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException(
                    "Cannot have null array as input");

        if (arr.length == 0 || arr.length == 1)
            return;

        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            SortUtils.swap(arr, i, maxIndex);
        }
    }

}
