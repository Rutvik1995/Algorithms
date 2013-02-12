package com.blogspot.vikkyrk.sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException(
                    "Cannot have null array as input");

        if (arr.length == 0 || arr.length == 1)
            return;

        sortInternal(arr, 0, arr.length - 1);

    }

    private void sortInternal(int[] arr, int st, int end) {
        if (st < end) {
            int mid = st + (end - st) / 2;
            sortInternal(arr, st, mid);
            sortInternal(arr, mid + 1, end);
            merge(arr, st, end);
        }
    }

    private void merge(int[] arr, int st, int end) {
        int[] tempArr = new int[end - st + 1];
        int mid = st + (end - st) / 2;
        int id1 = st;
        int id2 = mid + 1;
        for (int i = 0; i < tempArr.length; i++) {
            if (id1 > mid)
                tempArr[i] = arr[id2++];
            else if (id2 > end)
                tempArr[i] = arr[id1++];
            else if (arr[id1] < arr[id2])
                tempArr[i] = arr[id1++];
            else
                tempArr[i] = arr[id2++];
        }

        for (int i = 0; i < tempArr.length; i++)
            arr[st + i] = tempArr[i];
    }
}
