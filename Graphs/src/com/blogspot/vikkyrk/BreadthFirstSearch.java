package com.blogspot.vikkyrk;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	
	private boolean [] marked;
	private int [] edgeTo;
	private int source;
	private UndirectedGraph uGr = null;
	private int count = 0;
	
	public BreadthFirstSearch(UndirectedGraph Gr, int s) {
		uGr = Gr;
		source = s;
		marked = new boolean[uGr.V()];
		edgeTo = new int[uGr.V()];
		for(int i=0; i<uGr.V();i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}

		BreadthFirstSearchIterative(s);
	}
	
	private void BreadthFirstSearchIterative(int s) {
		Queue<Integer> mQueue = new LinkedList<Integer>();
		
		marked[s] = true;
		edgeTo[s] = s;
		mQueue.add(s);
	
		while(!mQueue.isEmpty()) {
			int v = mQueue.remove();
			count++;
			for(int i: uGr.adj(v)) {
				if(marked[i] == false) {
					marked[i] = true;
					edgeTo[i] = v;
					mQueue.add(i);
				}
			}
		}
	}

	public int count() {
		return count;
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> path(int v) {
		LinkedList<Integer> mPath = new LinkedList<Integer>();
		if(hasPathTo(v)) {
			int i = v;
			while(i != source) {
				mPath.add(0, i);	
				i = edgeTo[i];
			}
			mPath.add(0,source);
		}
			
		return mPath;	
	}
	
	public void printMarked() {
		System.out.println("Marked :");
		for(int i=0; i<uGr.V(); i++) {
			System.out.print(marked[i] + ", ");
		}
	}

}
