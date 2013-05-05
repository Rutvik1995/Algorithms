package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LongestIncreasingSubSequence {

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
        ArrayList<Integer> ml = generateRandomInput(size);
        List<Integer> r1 = longestIncreasingSubSeq(ml);
        List<Integer> r2 = longestIncreasingSubSeqInternal(ml);
        
        System.out.println(r1);
        System.out.println(r2);
        return r1;
    }

    /*
     * Longest Increasing Sequence is LCS of it and its sorted version.
     */
    private static List<Integer> longestIncreasingSubSeq(ArrayList<Integer> iList) {
        ArrayList<Integer> kList = new ArrayList<Integer>(iList);
        Collections.sort(kList);

        return LCSGeneric.computeLCS(iList, kList);
    }
    
    /*
     * Without using LCS, O(n^2). A better O(nlogn) solution can be found here,
     * http://stackoverflow.com/questions/4938833/find-longest-increasing-sequence
     */
    private static List<Integer> longestIncreasingSubSeqInternal(ArrayList<Integer> iList) {
        Integer[] temp = new Integer[iList.size()];
        
        for(int i=0; i<temp.length; i++)
            temp[i] = 1;
        
        for(int i=1; i<iList.size(); i++) {
            for(int j=0; j<i; j++) {
                if((iList.get(i) >= iList.get(j)) && temp[i] < temp[j] + 1) 
                    temp[i] = temp[j] + 1;
            }
        }
        
        int maxIndex = 0;
        
        for(int i=1; i<temp.length; i++)
            if(temp[i] > temp[maxIndex])
                maxIndex = i;
        
        List<Integer> res = new LinkedList<Integer>();
        res.add(iList.get(maxIndex));
        int prev = maxIndex;
        for(int i=maxIndex-1; i>=0; i--) {
            if((iList.get(i) <= iList.get(prev)) && (temp[i] == (temp[prev]-1))) {
                prev = i;
                res.add(0, iList.get(i));
            }
        }
        
        return res;
    }
}