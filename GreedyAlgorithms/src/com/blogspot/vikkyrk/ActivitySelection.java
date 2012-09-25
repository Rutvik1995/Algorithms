package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/*
 * Activity Selection Problem
 * 
 * Given activities with start and end times, we need to select
 * maximum number of activities without any conflict.
 * The idea is to sort the activities on their endTimes and then keep
 * selecting activities which do not conflict. O(nlog(n))
 * 
 * The idea is pretty simple, but proving why it works is the 
 * challenging part (generally true with any Greedy Algorithm)
 * 
 * In this case, we can prove it using the 'Exchange Trick'
 * Suppose that you have an optimal solution, we observe that
 * adding an activity that ends first will either improve the solution
 * or keep it the same. Using the same argument recursively, we keep 
 * selecting non-conflicting activities that end first.
 * 
 * 
 * Variation - Activity Selection Problem on Multiple Processors
 * 
 * Apply the Activity Selection Problem until all the activities are assigned
 * a processor.
 * 
 */
public class ActivitySelection {

	private static ArrayList<Activity> generateRandomInput(int size) {
		Random randomGen = new Random();
		int st, et;
		ArrayList<Activity> mAct = new ArrayList<Activity>(size);
		for(int i=0; i<size; i++) {
			st = randomGen.nextInt(size);
			et = st + randomGen.nextInt(size);
			mAct.add(new Activity(st,et));
		}
		System.out.println("Input = \n" + mAct);
		return mAct;
	}
	
	public static void ActivitySelectionSolve(int size) {
		ArrayList<Activity> mAct = generateRandomInput(size);
		Collections.sort(mAct);
		System.out.println("Sorted Input = \n" + mAct);
		
		ArrayList<Activity> selected = new ArrayList<Activity>();
		int st = -1;
		
		for(int i=0; i<size; i++) {
			if(mAct.get(i).startTime >= st) {
				selected.add(mAct.get(i));
				st = mAct.get(i).endTime;
			}	
		}
		
		System.out.println("Selected Activities = \n" + selected);
	}
	
	private static class Activity implements Comparable<Activity> {
		Integer startTime = 0;
		Integer endTime = 0;
		
		private Activity(Integer st, Integer et) {
			startTime = st;
			endTime = et;
		}
		@Override
		public int compareTo(Activity o) {
			return this.endTime.compareTo(o.endTime);
		}
		
		@Override
		public String toString() {
			return "(" + startTime + "-" + endTime + ")\n";
		}
	}
}
