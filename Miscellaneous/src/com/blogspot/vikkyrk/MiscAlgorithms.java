package com.blogspot.vikkyrk;

import java.util.ArrayList;

public class MiscAlgorithms {
	/*
	 * Only prints out the order of movements, but not the exact
	 * Ids.
	 * TODO: Complete this.
	 */
	public static void myPowersOfHanoiRecursion(int i) {
		if(i > 0) {
			myPowersOfHanoiRecursion(i-1);
			System.out.print(i+ " ");
			myPowersOfHanoiRecursion(i-1);
		}
	}
	
	public static int myPower(int x, int n) {
		if(n == 0) 
			return 1;
		if(n == 1)
			return x;
		
		int temp = myPower(x,n/2);
		if(n%2 == 0) 
			return temp*temp;
		else
			return x*temp*temp;
	}
	
	public static int myBinarySearch(int [] arr, int k) {
		
		int left = 0, right = arr.length-1;
		int mid;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(arr[mid] == k)
				return mid-1;
			else if(arr[mid] > k) {
				right = mid+1;
			}
			else
				left = mid;
		}
		return -1;
	}
	
	public static int maxContiguousSum(ArrayList<Integer> input) {
		
		int maxSum = Integer.MIN_VALUE;
		int tempMax =0;
		
		for(int i=0; i<input.size(); i++) {
			tempMax += input.get(i);
			if(maxSum < tempMax)
				maxSum = tempMax;
			
			if(tempMax < 0)
				tempMax = 0;
		}
	
		System.out.println("MaxSum = " + maxSum);
		return maxSum;
	}
	
	public static void maxSlidingWindow(ArrayList<Integer> input, int windowSize) {
		
	}
}
