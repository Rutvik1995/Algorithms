package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Random;

import com.blogspot.vikkyrk.pegDisks.pegDisk;

public class mainTest {
	public static void main(String[] args) {
		//pegDisk.start();
		//MiscAlgorithms.myPowersOfHanoiRecursion(4);
		//nQueensImpl.printList(nQueensImpl.nQueensSolve(4));
		//System.out.println(myPower(2,11));
		MiscAlgorithms.maxContiguousSum(generateRandomIntegers(10,15));
	}
	
	public static ArrayList<Integer> generateRandomPositiveIntegers(int size, int maxValue) {
		Random rG = new Random();
		ArrayList<Integer> output = new ArrayList<Integer>(size);
		for(int i=0; i<size; i++) {
			output.add(rG.nextInt(maxValue));
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
