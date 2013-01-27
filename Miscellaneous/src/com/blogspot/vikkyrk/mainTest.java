package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class mainTest {
	
	public static void log(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		//pegDisk.start();
		//MiscAlgorithms.myPowersOfHanoiRecursion(4);
		//nQueensImpl.printList(nQueensImpl.nQueensSolve(4));
		//System.out.println(myPower(2,11));
		//MiscAlgorithms.maxContiguousSum(generateRandomIntegers(10,15));
		//int [] A = {-1,0,0,0,1,2,2,2,2};
		//log("MaxHeight = " + MiscAlgorithms.maxHeightParentTree(A));
		//MiscAlgorithms.arrayLargestNum();
	    //  BinarySearchTest();
		//rotatedBinarySearchTest();
		//int [] arr = {5, 0, 2, 3, 4};
		//log("Rbs: " + MiscAlgorithms.rotatedBinarySearch(arr, 5));
		//MiscAlgorithms.getStartElement();
		//MiscAlgorithms.testDecToRadix(3);
		
		MatrixAlgorithms.matrixTests();
	}
	
	public static void BinarySearchTest() {
		ArrayList<Integer> mList = generateRandomPositiveIntegers(5, 5);
		int [] p = convertToIntArray(mList);
		Arrays.sort(p);
		System.out.print("Sorted Input: ");
		for(int i : p) {
			System.out.print(i + ", ");
		}
		log("\nBinSearch: " + MiscAlgorithms.binarySearch(p, 3));	
	}
	
	public static void rotatedBinarySearchTest() {
		int maxValue = 7;
		int maxSize = 5;
		ArrayList<Integer> mList = generateUniquePositiveIntegers(maxSize, maxValue);
		int [] p = convertToIntArray(mList);
		Arrays.sort(p);
		Random mR = new Random();
		MiscAlgorithms.rotateArray(p, mR.nextInt(mList.size()));
		System.out.print("Rotated Sorted Input: ");
		for(int i : p) {
			System.out.print(i + ", ");
		}
		int key = mR.nextInt(maxValue);
		log("\nRotatedBinSearch: Searching for key " + key + ", index=" + MiscAlgorithms.binarySearch(p, key));
	}
	public static int[] convertToIntArray(ArrayList<Integer> mList) {
		int [] p = new int[mList.size()];
		int k=0;
		for(Integer i : mList) {
			p[k++] = i; 
		}
		return p;
	}
 	
	public static ArrayList<Integer> generateUniquePositiveIntegers(int size, int maxValue) {
		if(maxValue < size)
			throw new RuntimeException("Cannot get unique values for this input");
		
		Random rG = new Random();
		ArrayList<Integer> output = new ArrayList<Integer>(size);
		for(int i=0; i<size; i++) {
			int t = rG.nextInt(maxValue);
            if(output.contains(t)) {
            	i--;
            	continue;
            }
			output.add(t);
		}
		
		System.out.println("Random Input = " + output);
		return output;
	}

	public static ArrayList<Integer> generateRandomPositiveIntegers(int size, int maxValue) {
		Random rG = new Random();
		ArrayList<Integer> output = new ArrayList<Integer>(size);
		for(int i=0; i<size; i++) {
			int t = rG.nextInt(maxValue);
			output.add(t);
		}
		
		System.out.println("Random Input = " + output);
		return output;
	}

	public static ArrayList<Integer> generateRandomIntegers(int size, int maxValue) {
		Random rG = new Random();
		ArrayList<Integer> output = new ArrayList<Integer>(size);
		for(int i=0; i<size; i++) {
			int temp = rG.nextInt(maxValue);
			if(temp%2==1)
				temp = -temp;
			output.add(temp);
		}
		
		System.out.println("Random Input = " + output);
		return output;
	}
}
