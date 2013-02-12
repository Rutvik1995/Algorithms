package com.blogspot.vikkyrk.pegDisks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class pegDisk {
    public static String destState = "";

    public static void start() {
        System.out
                .println("Enter Input: Read Problem statement for Input format");
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        ArrayList<Pegs> mPeg = new ArrayList<Pegs>();
        destState = "";
        readInput(input);
        destState = createPegsDiscs(input, mPeg);
        // System.out.println(getState(mPeg));
        System.out.println("\nDestState=" + destState);

        mSolve(mPeg, 0);

        System.out.println("\nEnded");
    }

    static int minCount = 8;
    static chainHashMap<String> sMap = new chainHashMap<String>();
    static myArrayStack<String> solStack = new myArrayStack<String>(8);

    public static void mSolve(ArrayList<Pegs> mPeg, int cnt) {
        if (cnt >= minCount)
            return;

        String cState = getState(mPeg);

        /*
         * if(sMap.contains(cState)) return; else sMap.put(cState);
         */

        if (sMap.contains(solStack.toString()))
            return;
        else
            sMap.put(solStack.toString());

        System.out.println("CurrentState=" + solStack.toString());

        if (cState.equals(destState)) {
            minCount = cnt;
            System.out.println(solStack.toString() + " MinCount =" + minCount);
            return;
        }

        ArrayList<Integer> moves = new ArrayList<Integer>();
        Iterator<Integer> mIter;
        String temp = "";
        int k;
        Discs cDisc;
        for (int i = 0; i < mPeg.size(); i++) {
            cnt++;
            moves.clear();
            getMoves(moves, mPeg, i);
            mIter = moves.iterator();
            while (mIter.hasNext()) {
                k = mIter.next();
                cDisc = mPeg.get(i).pop();
                cDisc.currentPegId = k + 1;
                mPeg.get(k).push(cDisc);
                temp = "(" + (i + 1) + "," + (k + 1) + ")";
                solStack.push(temp);
                mSolve(mPeg, cnt);
                cDisc = mPeg.get(k).pop();
                cDisc.currentPegId = i + 1;
                mPeg.get(i).push(cDisc);
                solStack.pop();
            }
            cnt--;
        }
    }

    public static void getMoves(ArrayList<Integer> moves, ArrayList<Pegs> mPeg,
            int pegId) {
        Discs cDisc;
        if (mPeg.get(pegId).isEmpty()) {
            return;
        }

        cDisc = mPeg.get(pegId).peek();

        for (int i = 0; i < mPeg.size(); i++) {
            if (i != pegId) {
                if (!mPeg.get(i).isEmpty()) {
                    if (cDisc.radius < mPeg.get(i).peek().radius) {
                        moves.add(i);
                    }
                } else {
                    moves.add(i);
                }
            }
        }
    }

    public static String createPegsDiscs(ArrayList<ArrayList<Integer>> input,
            ArrayList<Pegs> mPeg) {

        int numDiscs = input.get(0).get(0);
        int numPegs = input.get(0).get(1);
        String destState = "";
        for (int i = 1; i <= numPegs; i++) {
            mPeg.add(new Pegs(numDiscs, i));
        }

        for (int i = input.get(2).size() - 1; i >= 0; i--) {
            int pegId = input.get(2).get(i);
            int destPegId = input.get(2).get(i);
            mPeg.get(pegId - 1).push(new Discs(i + 1, pegId, destPegId));
        }

        destState = getState(mPeg);

        mPeg.clear();

        for (int i = 1; i <= numPegs; i++) {
            mPeg.add(new Pegs(numDiscs, i));
        }

        for (int i = input.get(1).size() - 1; i >= 0; i--) {
            int pegId = input.get(1).get(i);
            int destPegId = input.get(2).get(i);
            mPeg.get(pegId - 1).push(new Discs(i + 1, pegId, destPegId));
        }

        return destState;
    }

    public static String getState(ArrayList<Pegs> mPeg) {
        String state = "";
        for (int i = 0; i < mPeg.size(); i++) {
            state += mPeg.get(i).toString();
        }
        return state;
    }

    public static void readInput(ArrayList<ArrayList<Integer>> input) {

        String s = null;
        String[] str;

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                System.in));

        for (int i = 0; i < 3; i++) {
            try {
                s = inputReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Input Read Error");
            }

            str = s.split("\\s+");
            input.add(new ArrayList<Integer>());
            for (int k = 0; k < str.length; k++) {
                input.get(i).add(Integer.parseInt(str[k]));
            }
        }
        /*
         * for(int i=0;i<input.size();i++) { System.out.println(""); for(int
         * k=0;k<input.get(i).size();k++) { System.out.print(input.get(i).get(k)
         * + ","); } }
         */
    }
}
