package com.blogspot.vikkyrk.sort;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException(
                    "Cannot have null array as input");

        if (arr.length == 0 || arr.length == 1)
            return;

        // TODO:Randomize input before processing
        sortInternal(arr, 0, arr.length - 1);
    }

    private void sortInternal(int[] arr, int st, int end) {

        if (st < end) {
            int mid = splitAtPivot(arr, st, end);
            sortInternal(arr, st, mid - 1);
            sortInternal(arr, mid + 1, end);
        }
    }

    private int splitAtPivot(int[] arr, int st, int end) {
        int i = st + 1, j = end;

        while (i <= j) {
            while (i <= end && arr[i] <= arr[st])
                i++;

            while (j >= 0 && arr[j] > arr[st])
                j--;

            if (i < j)
                SortUtils.swap(arr, i++, j--);
        }

        SortUtils.swap(arr, st, i - 1);
        return i - 1;
    }
}
