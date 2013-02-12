package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MaxIndependentSet {
    private ArrayList<Integer> inputArr = new ArrayList<Integer>();
    int size = 0;
    int recursiveDepth = 0;

    public MaxIndependentSet(int size) {
        inputArr.ensureCapacity(size);
        this.size = size;
        generateRandomInput();
    }

    public MaxIndependentSet() {
        this(10);
        this.size = 10;
    }

    private void generateRandomInput() {
        Random rG = new Random();
        for (int i = 0; i < size; i++) {
            inputArr.add(rG.nextInt(size * 10));
        }
    }

    public void computeMIS() {
        System.out.println("Input = " + inputArr);
        System.out.println("MISRecursive = " + computeMISRecursive(size));
        System.out.println("RecursiveDepth = " + recursiveDepth);

        for (int i = 0; i <= size; i++) {
            sList.add(0);
        }
        sList.set(0, 0);
        sList.set(1, inputArr.get(0));
        computeMISDynamicProg();
        System.out.println("MISDynamic = " + sList.get(size));
        System.out.println("MISSet = " + mList);
    }

    private int computeMISRecursive(int n) {
        recursiveDepth++;
        if (n == 0)
            return 0;
        if (n == 1)
            return inputArr.get(0);

        int s1 = computeMISRecursive(n - 1);
        int s2 = computeMISRecursive(n - 2) + inputArr.get(n - 1);
        return s1 > s2 ? s1 : s2;
    }

    ArrayList<Integer> sList = new ArrayList<Integer>(size + 1);
    LinkedList<Integer> mList = new LinkedList<Integer>();

    /*
     * Works for positive integers only. To support negative integers, we need
     * to add a third condition to our algorithm which checks if s2+m < m, if so
     * s1 = m.
     */
    private void computeMISDynamicProg() {
        int s1, s2;
        for (int i = 2; i <= size; i++) {
            s1 = sList.get(i - 1);
            s2 = sList.get(i - 2) + inputArr.get(i - 1);
            if (s1 < s2)
                sList.set(i, s2);
            else
                sList.set(i, s1);
        }

        for (int i = size; i > 0; i--) {
            if (sList.get(i) > sList.get(i - 1)) {
                mList.add(0, inputArr.get(i - 1));
                i--;
            }
        }
    }
}
