package com.blogspot.vikkyrk;

import java.util.Stack;

public class ConnectedComponents {
	
	private int[] cmpIds;
	private int numCmps = 0;
	private boolean[] marked;
	
	public ConnectedComponents(UndirectedGraph uGr) {
		cmpIds = new int[uGr.V()];
		marked = new boolean[uGr.V()];
		for(int i=0; i<uGr.V(); i++) {
			marked[i] = false;
		}
		computeConnectedComponents(uGr);
	}
	
	private void computeConnectedComponents(UndirectedGraph uGr) {
		
		for(int i=0; i<uGr.V(); i++) {
			if(!marked[i]) {
				dfs(uGr,i,numCmps++);
			}
		}
	}
	
	private void dfs(UndirectedGraph uGr, int s, int compId) {
		Stack<Integer> mStack = new Stack<Integer>();
		marked[s] = true;
		cmpIds[s] = compId;
		mStack.push(s);
	
		while(!mStack.isEmpty()) {
			int v = mStack.pop();
			for(int i: uGr.adj(v)) {
				if(marked[i] == false) {
					marked[i] = true;
					cmpIds[i] = compId;
					mStack.push(i);
				}
			}
		}
	}

	public boolean isConnected(int v, int w) {
		
		if(cmpIds[v] == cmpIds[w]) 
			return true;
		else 
			return false;
		
		//return (cmpIds[v] == cmpIds[w]);
	}
	
	public int count() {
		return numCmps;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(int i=0; i<cmpIds.length; i++) {
			s = s + cmpIds[i] + ", ";
		}
		return s;
	}
	
}
