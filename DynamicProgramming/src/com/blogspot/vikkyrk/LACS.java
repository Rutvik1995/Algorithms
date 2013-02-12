package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Random;

//Longest Ascending Contiguous Sequence
public class LACS {

    private static ArrayList<Integer> generateRandomInput(int size) {
        ArrayList<Integer> mList = new ArrayList<Integer>(size);
        Random randomGen = new Random();

        for (int i = 0; i < size; i++) {
            mList.add(randomGen.nextInt(size));
        }
        System.out.println("Input = " + mList);
        return mList;
    }

    public static ArrayList<Integer> computeLCS(int size) {
        return computeLCS(generateRandomInput(size));
    }

    public static ArrayList<Integer> computeLCS(ArrayList<Integer> aList) {
        ArrayList<Integer> rList = new ArrayList<Integer>();
        if (aList == null)
            return rList;

        int maxlength = 1;
        int startIndex = 0;
        int length = 1;

        for (int i = 1; i < aList.size(); i++) {
            if (aList.get(i) < aList.get(i - 1)) {
                length = 1;
            } else
                length++;

            if (length > maxlength) {
                maxlength = length;
                startIndex = i + 1 - length;
            }
        }

        for (int i = startIndex; i < startIndex + maxlength; i++) {
            rList.add(aList.get(i));
        }
        return rList;
    }
}
