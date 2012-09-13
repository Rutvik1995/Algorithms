package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class LongestIncreasingSeq {
	
	private static ArrayList<Integer> generateRandomInput(int size) {
		ArrayList<Integer> mList = new ArrayList<Integer>(size);
		Random randomGen = new Random();

		for(int i=0; i<size; i++) {
			mList.add(randomGen.nextInt(size));
		}
		System.out.println("Input = " + mList);
		return mList;
	}
	
	public static ArrayList<Integer> longestIncreasingSubSeq(int size) {
		return longestIncreasingSubSeq(generateRandomInput(size));
	}
	
	public static ArrayList<Integer> longestIncreasingSubSeq(ArrayList<Integer> iList) {
		ArrayList<Integer> kList = new ArrayList<Integer>(iList);
		Collections.sort(kList);
		String s1 = listToString(iList);
		String s2 = listToString(kList);
		
		System.out.println(s1);
		System.out.println(s2);
		return null;
	}
	
	private static String listToString(List<Integer> iList) {
		ListIterator<Integer> lIter = iList.listIterator();
		StringBuilder sb = new StringBuilder();
		while(lIter.hasNext()) {
			sb.append(lIter.next());
		}
		return sb.toString();
	}
}
