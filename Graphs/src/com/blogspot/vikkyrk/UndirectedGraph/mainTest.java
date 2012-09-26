package com.blogspot.vikkyrk.UndirectedGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainTest {

	public static void main(String[] args) {
		File f = new File("/media/STUDY/Tech/AlgoWrkSpc/Graphs/src/undirectedGraphInput2.txt");
		FileReader fR = null;

		try {
			fR = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		UndirectedGraph myGraph = null;
		try {
			myGraph = new UndirectedGraph(new BufferedReader(fR));
		} catch (IOException e) {
			throw new RuntimeException("Error Creating Graph");
		}

		System.out.println(myGraph);

		/*DepthFirstSearch dfs = new DepthFirstSearch(myGraph,1);
		System.out.println("Dfs count for vertex 1 = " + dfs.count());
			
		System.out.println("Path:" + dfs.path(3));
		*/

		BreadthFirstSearch bfs = new BreadthFirstSearch(myGraph,1);
		System.out.println("Dfs count for verted 1 = " + bfs.count());

		System.out.println("Path:" + bfs.path(3));

		ConnectedComponents cc = new ConnectedComponents(myGraph);

		System.out.println("Connected " + cc);
		System.out.println("Connected " + cc.isConnected(0, 3) + " Num = " + cc.count());
		
		CycleDetection cy = new CycleDetection(myGraph);
		
		System.out.println("hasCyle = " + cy.hasCycle());
		System.out.println("isBipartite = " + cy.isBipartite());
	}	
}


