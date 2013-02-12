package com.blogspot.vikkyrk.UndirectedGraph;

import java.util.Stack;

/*
 * Assuming it is a connected Graph
 * Also checks if graph is BiPartite
 * 
 * TODO: Get the actual vertices which are part of a cycle
 */
public class CycleDetection {

    private boolean hasCycle = false;
    private boolean isBipartite = true;
    private boolean[] marked = null;
    private int[] edgeTo;
    private boolean[] color;

    public CycleDetection(UndirectedGraph uGr) {
        marked = new boolean[uGr.V()];
        edgeTo = new int[uGr.V()];
        color = new boolean[uGr.V()];
        for (int i = 0; i < uGr.V(); i++) {
            marked[i] = false;
            edgeTo[i] = -1;
        }

        dfs(uGr, 0);
    }

    private void dfs(UndirectedGraph uGr, int s) {
        Stack<Integer> mStack = new Stack<Integer>();
        marked[s] = true;
        edgeTo[s] = s;
        color[s] = true;
        mStack.push(s);

        while (!mStack.isEmpty()) {
            int v = mStack.pop();
            for (int i : uGr.adj(v)) {
                if (marked[i] == false) {
                    marked[i] = true;
                    edgeTo[i] = v;
                    color[i] = !color[v];
                    mStack.push(i);
                } else {
                    if (!(edgeTo[v] == i))
                        hasCycle = true;
                    if (color[v] == color[i])
                        isBipartite = false;
                }
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
