package com.blogspot.vikkyrk.EdgeWeightedUndirectedGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class EdgeWeightedUndirectedGraph {
	private ArrayList<LinkedList<Edge>> vertices = null;
	private int numEdges = 0;
	
	public EdgeWeightedUndirectedGraph (int V) {
		vertices = new ArrayList<LinkedList<Edge>>(V);
		for(int i=0;i<V;i++) {
			vertices.add(new LinkedList<Edge>());
		}
	}
	
	public EdgeWeightedUndirectedGraph (BufferedReader in) throws IOException {
		this(Integer.parseInt(in.readLine()));
		String s;
		while( (s = in.readLine()) != null) {
			String[] str = s.split(" ");
			addEdge(new Edge(Integer.parseInt(str[0]), 
							 Integer.parseInt(str[1]), 
					         Double.parseDouble(str[2])));
		}
	}
	
	public int V() {
		return vertices.size();
	}
	
	public int E() {
		return numEdges;
	}
	
	public void addEdge(Edge e) {
		vertices.get(e.v1()).add(e);
		vertices.get(e.v2()).add(e);
		numEdges++;
	}
	
	public Iterable<Edge> adj(int v) {
		return vertices.get(v);
	}

	@Override
	public String toString() {
		String s = "";
		s = s + "\n Graph \n";
		for(int i=0; i<vertices.size(); i++) {
			s = s + i + ":";
			s = s + vertices.get(i) + "\n";
		}
		return s;
	}
}
