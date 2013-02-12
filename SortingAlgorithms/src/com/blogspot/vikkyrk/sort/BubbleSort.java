package com.blogspot.vikkyrk.sort;

public class BubbleSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if(arr == null)
			throw new IllegalArgumentException("Cannot have null array as input");
		
		if(arr.length == 0 || arr.length == 1)
			return;
		
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1])
					SortUtils.swap(arr, j, j+1);
			}
		}
	}
	
}
