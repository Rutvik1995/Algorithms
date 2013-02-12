package com.blogspot.vikkyrk.DirectedGraph;

import java.util.LinkedList;

/*
 * Strongly Connected Components
 */
public class SCC {
    private int count = 0;
    private int[] cmpId;
    private boolean[] marked;
    LinkedList<Iterable<Integer>> sccs = new LinkedList<Iterable<Integer>>();

    public SCC(DirectedGraph dGr) {
        cmpId = new int[dGr.V()];
        marked = new boolean[dGr.V()];

        for (int i = 0; i < dGr.V(); i++) {
            marked[i] = false;
            cmpId[i] = i;
        }

        Iterable<Integer> order = (new DFSOrder(dGr.reverse()))
                .reversePostOrder();

        for (int i : order) {
            if (!marked[i]) {
                dfs(dGr, i);
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            for (int j = 0; j < dGr.V(); j++) {
                if (cmpId[j] == i) {
                    temp.add(j);
                }
            }
            sccs.add(temp);
        }

    }

    private void dfs(DirectedGraph dGr, int s) {
        marked[s] = true;
        cmpId[s] = count;
        for (int i : dGr.adj(s)) {
            if (marked[i] == false) {
                dfs(dGr, i);
            }
        }
    }

    public Iterable<Iterable<Integer>> getSCCs() {
        return sccs;
    }

    public int getCount() {
        return count;
    }
}
