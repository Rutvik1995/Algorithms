package com.blogspot.vikkyrk.EdgeWeightedUndirectedGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainTest {
    public static void main(String[] args) {
        File f = new File(
                "/media/STUDY/Tech/AlgoWrkSpc/Graphs/src/edgeweightedGraphInput.txt");
        FileReader fR = null;

        try {
            fR = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        EdgeWeightedUndirectedGraph myGraph = null;
        try {
            myGraph = new EdgeWeightedUndirectedGraph(new BufferedReader(fR));
        } catch (IOException e) {
            throw new RuntimeException("Error Creating Graph");
        }

        System.out.println(myGraph);

    }
}
