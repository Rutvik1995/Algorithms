package com.blogspot.vikkyrk.DirectedGraph;

import java.util.LinkedList;
import java.util.Stack;

public class DirectedCycle {
    private boolean hasCycle = false;
    private boolean[] marked = null;
    private boolean[] onStack = null;
    private int[] edgeTo = null;
    LinkedList<Integer> cycle = new LinkedList<Integer>();

    public DirectedCycle(DirectedGraph dGr) {
        marked = new boolean[dGr.V()];
        onStack = new boolean[dGr.V()];
        edgeTo = new int[dGr.V()];
        for (int i = 0; i < dGr.V(); i++) {
            marked[i] = false;
            onStack[i] = false;
            edgeTo[i] = -1;
        }

        for (int i = 0; i < dGr.V(); i++)
            if (!marked[i])
                dfsRecursive(dGr, i);
    }

    @SuppressWarnings("unused")
    private void dfs(DirectedGraph dGr, int s) {
        Stack<Integer> mStack = new Stack<Integer>();
        marked[s] = true;
        mStack.push(s);
        edgeTo[s] = s;
        while (!mStack.isEmpty()) {
            int v = mStack.pop();
            onStack[v] = false;
            for (int i : dGr.adj(v)) {
                if (marked[i] == false) {
                    marked[i] = true;
                    onStack[i] = true;
                    edgeTo[i] = v;
                    mStack.push(i);
                } else if (!onStack[i] && (edgeTo[v] != i) && hasCycle == false) {
                    hasCycle = true;
                    cycle.add(i);
                    for (int m = v; m != i; m = edgeTo[m]) {
                        if (m == s) {
                            cycle.clear();
                            hasCycle = false;
                            break;
                        }
                        cycle.add(m);
                    }
                }
            }
        }
    }

    /*
     * dfsRecursive for detecting cycles is much more simple to follow and
     * easier to code and test.
     */
    private void dfsRecursive(DirectedGraph dGr, int s) {
        marked[s] = true;
        onStack[s] = true;
        for (int i : dGr.adj(s)) {
            if (hasCycle == true)
                return;
            else if (!marked[i]) {
                edgeTo[i] = s;
                dfsRecursive(dGr, i);
            } else if (onStack[i] == true) {
                hasCycle = true;
                cycle.add(i);
                for (int m = s; m != i; m = edgeTo[m]) {
                    cycle.add(m);
                }
            }
        }
        onStack[s] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public Iterable<Integer> getCycle() {
        return cycle;
    }
}
