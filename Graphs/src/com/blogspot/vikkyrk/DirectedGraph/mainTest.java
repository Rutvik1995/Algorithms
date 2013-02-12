package com.blogspot.vikkyrk.DirectedGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainTest {

    public static void main(String[] args) {
        File f = new File(
                "/media/STUDY/Tech/AlgoWrkSpc/Graphs/src/directedGraphInput2.txt");
        FileReader fR = null;

        try {
            fR = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DirectedGraph myGraph = null;
        try {
            myGraph = new DirectedGraph(new BufferedReader(fR));
        } catch (IOException e) {
            throw new RuntimeException("Error Creating Graph");
        }

        System.out.println(myGraph);
        System.out.println("\n" + myGraph.reverse());

        DepthFirstSearch dfs = new DepthFirstSearch(myGraph, 1);
        System.out.println("Dfs count for vertex 1 = " + dfs.count());

        System.out.println("Path:" + dfs.path(2));

        DFSOrder dfsO = new DFSOrder(myGraph);
        System.out.println("PreOrder: " + dfsO.preOrder());
        System.out.println("PostOrder: " + dfsO.postOrder());
        System.out.println("ReversePostOrder: " + dfsO.reversePostOrder());

        /*
         * BreadthFirstSearch bfs = new BreadthFirstSearch(myGraph,1);
         * System.out.println("Bfs count for vertex 1 = " + bfs.count());
         * 
         * System.out.println("Path:" + bfs.path(2));
         */

        DirectedCycle cy = new DirectedCycle(myGraph);

        System.out.println("Cycle:" + cy.hasCycle());
        if (cy.hasCycle()) {
            for (int i : cy.getCycle())
                System.out.println(i);
        }

        TopologicalSort ts = new TopologicalSort(myGraph);
        if (ts.isDAG())
            System.out.println("TopologicalOrder = " + ts.topologicalOrder());

        SCC scc = new SCC(myGraph);

        System.out.println("SCC Count = " + scc.getCount());
        System.out.println(scc.getSCCs());
    }

}
