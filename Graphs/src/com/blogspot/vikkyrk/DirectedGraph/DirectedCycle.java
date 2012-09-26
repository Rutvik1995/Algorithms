package com.blogspot.vikkyrk.DirectedGraph;

import java.util.Stack;

public class DirectedCycle {
	private boolean hasCycle = false;
	private boolean [] marked = null;
	public DirectedCycle(DirectedGraph dGr) {
		marked = new boolean[dGr.V()]; 
		for(int i=0; i<dGr.V();i++) {
			marked[i] = false;
		}
	}
	
	private void dfs(DirectedGraph dGr, int s) {
		Stack<Integer> mStack = new Stack<Integer>();
		marked[s] = true;
		mStack.push(s);
		
		while(!mStack.isEmpty()) {
			int v = mStack.pop();
			
			for(int i: dGr.adj(v)) {
				if(marked[i] == false) {
					marked[i] = true;
					mStack.push(i);
				}
			}
		}
	}
	
	public boolean hasCycle() {
		return hasCycle;
	}
}
