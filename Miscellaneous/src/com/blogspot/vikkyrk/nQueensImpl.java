package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class nQueensImpl {

    public static LinkedList<ArrayList<Integer>> nQueensSolve(int n) {

        LinkedList<ArrayList<Integer>> rslt = new LinkedList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        nQueensAlg1(n, n, tempList, rslt);
        return rslt;
    }

    /*
     * If Unique solutions are needed, check Wikipedia for details.
     * 
     * Interesting Trivia On an 8×8 board one can place 32 knights, or 14
     * bishops, 16 kings or eight rooks, so that no two pieces attack each
     * other. Fairy chess pieces have also been substituted for queens. In the
     * case of knights, an easy solution is to place one on each square of a
     * given color, since they move only to the opposite color. The solution is
     * also easy for rooks and kings. Eight rooks can be placed along a long
     * diagonal (amongst thousands of other solutions), and 16 kings are placed
     * on the board by dividing it into 2 by 2 squares and placing the kings at
     * equivalent points on each square.
     */
    private static void nQueensAlg1(int n, int k, ArrayList<Integer> tempList,
            LinkedList<ArrayList<Integer>> rslt) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }

        if (k == 0) {
            if (tempList.size() != 0) {
                ArrayList<Integer> tList = new ArrayList<Integer>(tempList);
                rslt.add(tList);
            }
            return;
        }

        int tSize = tempList.size();
        for (int i = 0; i < n; i++) {
            tempList.add(i);
            if (isPositionValid(tempList, tSize, tSize - 1, i)) {
                nQueensAlg1(n, k - 1, tempList, rslt);
            }
            tempList.remove(tSize);
        }
    }

    private static boolean isPositionValid(ArrayList<Integer> tempList, int k,
            int j, Integer col) {
        if (j < 0)
            return true;

        Integer temp2 = tempList.get(j);

        if (col == temp2 || col == temp2 + (k - j) || col == temp2 - (k - j)) {
            return false;
        }
        return isPositionValid(tempList, k, j - 1, col);
    }

    public static void printList(LinkedList<ArrayList<Integer>> rslt) {
        System.out.println("No of Solutions = " + rslt.size());
        Iterator<ArrayList<Integer>> iter = rslt.iterator();
        Iterator<Integer> vIter = null;
        int temp;
        while (iter.hasNext()) {
            vIter = iter.next().iterator();
            temp = 1;
            System.out.print("( ");
            while (vIter.hasNext()) {
                System.out.print("(" + temp + "," + (vIter.next() + 1 + ")"));
                temp++;
            }
            System.out.println(" )");
        }
    }
}
