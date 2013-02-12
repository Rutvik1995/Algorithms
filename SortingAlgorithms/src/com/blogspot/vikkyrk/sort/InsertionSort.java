package com.blogspot.vikkyrk.sort;

public class InsertionSort implements Sort{

	@Override
	public void sort(int[] arr) {
		if(arr == null)
			throw new IllegalArgumentException("Cannot have null array as input");
		
		if(arr.length == 0 || arr.length == 1)
			return;
		
		for(int i=1; i<arr.length;i++) {
			int j = i;
			
			while((j>0) && (arr[j] < arr[j-1])) {
				SortUtils.swap(arr,j,j-1);
				j--;
			}
		}
	}
	
	
		
}
