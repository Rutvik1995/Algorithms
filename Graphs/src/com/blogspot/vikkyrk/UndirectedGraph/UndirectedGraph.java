package com.blogspot.vikkyrk.UndirectedGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Although the Undirected Graph supports self-loops and
 * parallel edges, some of the other algorithms in other
 * classes might not. Be aware of these corner cases
 * when asked to write a graph algorithm
 * 
 * TODO: Null checks not added in all the graph algorithms.
 */
public class UndirectedGraph {

    private ArrayList<LinkedList<Integer>> vertices = null;
    private int numEdges = 0;

    public UndirectedGraph(int V) {
        vertices = new ArrayList<LinkedList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            vertices.add(new LinkedList<Integer>());
        }
    }

    public UndirectedGraph(BufferedReader in) throws IOException {
        this(Integer.parseInt(in.readLine()));
        String s;
        while ((s = in.readLine()) != null) {
            String[] str = s.split(" ");
            addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
    }

    public int V() {
        return vertices.size();
    }

    public int E() {
        return numEdges;
    }

    public void addEdge(int v, int w) {
        vertices.get(v).add(w);
        vertices.get(w).add(v);
        numEdges++;
    }

    public Iterable<Integer> adj(int v) {
        return vertices.get(v);
    }

    @Override
    public String toString() {
        String s = "";
        s = s + "\n Graph \n";
        for (int i = 0; i < vertices.size(); i++) {
            s = s + i + ":";
            s = s + vertices.get(i) + "\n";
        }
        return s;
    }
}
