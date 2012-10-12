package com.blogspot.vikkyrk.EdgeWeightedUndirectedGraph;

public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}
	
	public int v1() {
		return v;
	}
	
	public int v2() {
		return w;
	}
	
	@Override
	public int compareTo(Edge arg0) {
		if(this.weight > arg0.weight) return 1;
		else if(this.weight < arg0.weight) return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		String s = "";
		s = s + "(" + v + "-" + w + ":" + weight + ")";
		return s;
	}
	
}
