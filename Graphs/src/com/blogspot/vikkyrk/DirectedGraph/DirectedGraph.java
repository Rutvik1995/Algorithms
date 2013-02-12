package com.blogspot.vikkyrk.DirectedGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class DirectedGraph {

    private ArrayList<LinkedList<Integer>> vertices = null;
    private int numEdges = 0;

    public DirectedGraph(int V) {
        vertices = new ArrayList<LinkedList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            vertices.add(new LinkedList<Integer>());
        }
    }

    public DirectedGraph(BufferedReader in) throws IOException {
        this(Integer.parseInt(in.readLine()));
        String s;
        while ((s = in.readLine()) != null) {
            String[] str = s.split(" ");
            addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
    }

    public void addEdge(int v, int w) {

        vertices.get(v).add(w);
        numEdges++;
    }

    public Iterable<Integer> adj(int v) {
        return vertices.get(v);
    }

    public int V() {
        return vertices.size();
    }

    public int E() {
        return numEdges;
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

    public DirectedGraph reverse() {
        DirectedGraph rev = new DirectedGraph(vertices.size());

        for (int i = 0; i < vertices.size(); i++) {
            for (int w : vertices.get(i)) {
                rev.addEdge(w, i);
            }
        }
        return rev;
    }
}
