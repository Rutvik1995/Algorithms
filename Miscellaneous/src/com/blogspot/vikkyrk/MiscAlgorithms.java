package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

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
	
	/*
	 * Given a array where the value of each element is the parent of that node in a tree,
	 * Find the max height of the tree
	 */
	
	public static int maxHeightParentTree(int[] A) {
		if(A.length == 0)
			return -1;
		
		if(A.length == 1)
			return 0;
		
		HashMap<Integer,Boolean> hMap = new HashMap<Integer,Boolean>();
		int [] B = new int[A.length];
		
		for(int i=0; i<A.length; i++) {
			hMap.put(A[i], true);
			B[i] = 0;
		}
		
		for(int i=1; i<A.length; i++) {
			int k = 0;
			int j = i;
			
			if(!hMap.containsKey(i)) {
				while(j != -1) {
					if(B[j] < k)
						B[j] = k;
					
					k++;
					j = A[j];
				}
			}
		}
		
		System.out.println("Hmap = " + hMap);
		
		return B[0];
	}

	private static final char[] digits = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final int MAX_RADIX = 36;
	private static final int MIN_RADIX = 2;

	public static String decimalToRadix(int dec, int rad) {
		if(rad < MIN_RADIX || rad > MAX_RADIX)
			throw new UnsupportedOperationException("Radix: "+rad+" not supported");
		
		char[] res = new char[33];
		
		boolean negative = (dec < 0);
		
		if(negative)
			dec = -dec;
		
		int i = 33;
		while(dec != 0) {
			res[--i] = digits[dec%rad];
			dec = dec / rad;
		}
		
		if(negative)
			res[--i] = '-';
		
		return new String(res,i,33-i);
	}

	public static void testDecToRadix(int howManyTimes) {
        Random randGen = new Random();
        int dec, rad;
		for(int i=0; i<howManyTimes; i++) {
			dec = randGen.nextInt(Integer.MAX_VALUE);
			rad = randGen.nextInt(36);
			if(rad < 2)
				continue;
			
			if(!Integer.toString(dec, rad).equals(decimalToRadix(dec,rad)))
				mainTest.log("Test Failed: Dec = " + dec + ", Rad = " + rad);
			else
				mainTest.log("Dec = " + dec + ", Rad = " + rad);
		}
		mainTest.log("testDecToRadix: Success");
	}
	
	
	public static void arrayLargestNum() {
		ArrayList<Integer> mList = new ArrayList<Integer>();
		mList.add(989);
		mList.add(9);
		mList.add(97);
		mList.add(554);
		mList.add(55);
		mList.add(556);
		
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return (arg1+arg0).compareTo(arg0+arg1);
			}
		};
		
		ArrayList<String> sList = new ArrayList<String>(mList.size());
		
		for(Integer i : mList)
			sList.add(i.toString());
		
		mainTest.log("ArrayListInput" + sList);
		
		Collections.sort(sList, stringComparator);
		
		String s = new String();
		
		for(String i: sList)
			s+=i;
		
		mainTest.log("Output:" + s);
	}
	
	/*
	 * Reverse Array
	 */
	
	public static void reverseArray (int[] arr, int low, int high) 
			throws ArrayIndexOutOfBoundsException,
			       IllegalArgumentException {
		if(low >= arr.length || high >= arr.length)
			throw new ArrayIndexOutOfBoundsException();
		if(low > high)
			throw new IllegalArgumentException();
		
		for(int i=0; i < (high-low+1)/2; i++) {
			arr[low + i] = arr[low + i] ^ arr[high - i];
			arr[high - i] = arr[low + i] ^ arr[high - i];
			arr[low + i] = arr[low + i] ^ arr[high - i];
		}
	}
	
	
	/*
	 * RotateArray
	 */
	public static void rotateArray(int[] arr, int times) {
		times = times < 0 ? (arr.length - (Math.abs(times) % arr.length)) :
							(times % arr.length);
		
		if(times == 0 || times == arr.length)
			return;
		reverseArray(arr, 0, arr.length - 1 - times);
		reverseArray(arr, arr.length - times, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
	}
	
	public static int binarySearch(int [] arr, int k) {
		
		int left = 0, right = arr.length-1;
		int mid;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(arr[mid]<k)
				left = mid+1;
			else if(arr[mid] > k) 
				right = mid-1;
			else
				return mid;
		}
		return -1;
	}
	
	public static int rotatedBinarySearch(int [] arr, int k) {
		int low = 0, high = arr.length-1;
		int mid;
		
		while(low <= high) {
			mid = low + (high-low)/2;
			if(arr[mid] == k)
				return mid;
			//Lower half is sorted
			if(arr[mid] > arr[low]) {
				if(arr[low] <= k && k < arr[mid] )
					high = mid-1;
				else
					low = mid+1;
			}
			//Higher half is sorted
			else {
				if(arr[mid] < k && k <= arr[high])
					low = mid+1;
				else
					high = mid-1;
			}
		}
		return -1;
	}
	
	/*
	 * Array is sorted and rotated. Find the starting element or find
	 * the rotation factor.
	 * 
	 * ** Duplicates not allowed.
	 */
	
	public static void getStartElement() {
		Random mR = new Random();
		int size = mR.nextInt(9)+1;
		mainTest.log("Size = " + size);
		int[] mInput = new int[size];
		
		for(int i=0; i<size; i++) {
			mInput[i] = mR.nextInt(size);
			for(int j=0; j<i; j++) {
				if(mInput[i] == mInput[j]) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(mInput);
		int rotate = mR.nextInt(size);
		mainTest.log("Rotated: " + rotate );
		rotateArray(mInput, rotate);
		
		mainTest.log("Input : " + Arrays.toString(mInput));
		mainTest.log("StartElement : " + getStartElementIndex(mInput));
	}
	
	private static int getStartElementIndex(int[] mInput) {
		int low = 0, high = mInput.length-1;
		
		/*
		 * instead of (low != high), its good to have
		 * mInput[low]>mInput[high], which would take care
		 * of the case where the input is already sorted
		 * and not rotated.
		 */
		while(mInput[low] > mInput[high]) {
			int mid = low + (high-low)/2;
			if(mInput[mid] > mInput[high]) 
				low = mid+1;
			else
				high = mid;
		}
		
		return low;
	}
}
