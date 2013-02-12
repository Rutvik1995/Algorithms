package com.blogspot.vikkyrk.sort;

public class CountingSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException(
                    "Cannot have null array as input");

        if (arr.length == 0 || arr.length == 1)
            return;

        int max = SortUtils.findMax(arr);

        int[] countArr = new int[max + 1];

        // TODO: Handle Negative numbers
        for (int i = 0; i < arr.length; i++)
            countArr[arr[i]]++;

        int j = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] != 0) {
                arr[j++] = i;
                countArr[i]--;
            }
        }
    }
}
