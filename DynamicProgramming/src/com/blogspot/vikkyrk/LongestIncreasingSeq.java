package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LongestIncreasingSeq {

    /*
     * This solution uses dynamic programming with complexity of O(n^2) There
     * are other techniques which solve this in O(nLogn) time. To be explored
     * later. Also explore Longest path in a graph.
     */
    private static ArrayList<Integer> generateRandomInput(int size) {
        ArrayList<Integer> mList = new ArrayList<Integer>(size);
        Random randomGen = new Random();

        for (int i = 0; i < size; i++) {
            mList.add(randomGen.nextInt(size * 10));
        }
        System.out.println("Input = " + mList);
        return mList;
    }

    public static List<Integer> longestIncreasingSubSeq(int size) {
        return longestIncreasingSubSeq(generateRandomInput(size));
    }

    public static List<Integer> longestIncreasingSubSeq(ArrayList<Integer> iList) {
        ArrayList<Integer> kList = new ArrayList<Integer>(iList);
        Collections.sort(kList);

        return LCSGeneric.computeLCS(iList, kList);
    }
}