package com.blogspot.vikkyrk.UndirectedGraph;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int source;
    private UndirectedGraph uGr = null;
    private int count = 0;

    public DepthFirstSearch(UndirectedGraph Gr, int s) {
        uGr = Gr;
        source = s;
        marked = new boolean[uGr.V()];
        edgeTo = new int[uGr.V()];
        for (int i = 0; i < uGr.V(); i++) {
            marked[i] = false;
            edgeTo[i] = -1;
        }
        // DepthFirstSearchRecursive(s);
        DepthFirstSearchIterative(s);
    }

    @SuppressWarnings("unused")
    private void DepthFirstSearchRecursive(int s) {
        marked[s] = true;
        count++;
        for (int i : uGr.adj(s)) {
            if (marked[i] == false) {
                edgeTo[i] = s;
                DepthFirstSearchRecursive(i);
            }
        }
    }

    private void DepthFirstSearchIterative(int s) {
        Stack<Integer> mStack = new Stack<Integer>();

        marked[s] = true;
        edgeTo[s] = s;
        mStack.push(s);

        while (!mStack.isEmpty()) {
            int v = mStack.pop();
            count++;
            for (int i : uGr.adj(v)) {
                if (marked[i] == false) {
                    marked[i] = true;
                    edgeTo[i] = v;
                    mStack.push(i);
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
        if (hasPathTo(v)) {
            int i = v;
            while (i != source) {
                mPath.add(0, i);
                i = edgeTo[i];
            }
            mPath.add(0, source);
        }

        return mPath;
    }

    public void printMarked() {
        System.out.println("Marked :");
        for (int i = 0; i < uGr.V(); i++) {
            System.out.print(marked[i] + ", ");
        }
    }
}
