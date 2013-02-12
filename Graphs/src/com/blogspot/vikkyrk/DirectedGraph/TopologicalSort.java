package com.blogspot.vikkyrk.DirectedGraph;

public class TopologicalSort {

    private Iterable<Integer> order;

    public TopologicalSort(DirectedGraph dGr) {
        DirectedCycle cy = new DirectedCycle(dGr);
        if (cy.hasCycle())
            order = null;
        else {
            DFSOrder dfs = new DFSOrder(dGr);
            order = dfs.reversePostOrder();
        }
    }

    public boolean isDAG() {
        return !(order == null);
    }

    public Iterable<Integer> topologicalOrder() {
        return order;
    }
}
