package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class KnapSack {

    public static ArrayList<Integer> computeKnapSack(Integer inputSize,
            Integer valueSize, Integer maxSize) {
        return computeKnapSackDynamic(
                generateRandomInput(inputSize, valueSize),
                generateRandomInput(inputSize, valueSize), maxSize);
    }

    public static ArrayList<Integer> computeKnapSack(ArrayList<Integer> pSizes,
            ArrayList<Integer> pWeights, Integer maxSize) {

        if ((pSizes == null) || (pWeights == null) || (maxSize < 0))
            throw new RuntimeException("Invalid Input");

        if (pSizes.size() != pWeights.size())
            throw new RuntimeException("Invalid Input");

        return computeKnapSack(pSizes, pWeights, maxSize, pSizes.size() - 1);
    }

    public static ArrayList<Integer> computeKnapSackDynamic(
            ArrayList<Integer> pSizes, ArrayList<Integer> pWeights,
            Integer maxSize) {

        if ((pSizes == null) || (pWeights == null) || (maxSize < 0))
            throw new RuntimeException("Invalid Input");

        if (pSizes.size() != pWeights.size())
            throw new RuntimeException("Invalid Input");

        int lenA = maxSize + 1;
        int lenB = pSizes.size() + 1;
        int[][] ksk = new int[lenA][lenB];

        for (int i = 0; i < lenB; i++)
            ksk[0][i] = 0;
        for (int j = 0; j < lenA; j++)
            ksk[j][0] = 0;

        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                if (pSizes.get(j - 1) > i) {
                    ksk[i][j] = ksk[i][j - 1];
                } else {
                    ksk[i][j] = ksk[i][j - 1] > ksk[i - pSizes.get(j - 1)][j - 1]
                            + pWeights.get(j - 1) ? ksk[i][j - 1] : ksk[i
                            - pSizes.get(j - 1)][j - 1]
                            + pWeights.get(j - 1);
                }
            }
        }

        int i = maxSize;
        ArrayList<Integer> mList = new ArrayList<Integer>();
        for (int j = lenB - 1; j > 0; j--) {
            if (pSizes.get(j - 1) > i)
                continue;
            if (ksk[i][j - 1] > ksk[i - pSizes.get(j - 1)][j - 1]
                    + pWeights.get(j - 1)) {
                continue;
            } else {
                mList.add(0, j - 1);
                i = i - pSizes.get(j - 1);
            }
        }

        return mList;
    }

    private static ArrayList<Integer> computeKnapSack(
            ArrayList<Integer> pSizes, ArrayList<Integer> pWeights,
            Integer maxSize, Integer index) {
        if (index < 0)
            throw new RuntimeException("Index out of bounds");

        if (pSizes.get(index) > maxSize)
            return new ArrayList<Integer>();

        if (index == 0) {
            ArrayList<Integer> rList = new ArrayList<Integer>();
            rList.add(index);
            return rList;
        }

        ArrayList<Integer> mA = computeKnapSack(pSizes, pWeights, maxSize
                - pSizes.get(index), index - 1);
        ArrayList<Integer> mB = computeKnapSack(pSizes, pWeights, maxSize,
                index - 1);

        Integer cA = computeWeights(pWeights, mA);
        Integer cB = computeWeights(pWeights, mB);

        if ((cA + pWeights.get(index)) > cB) {
            mA.add(index);
            return mA;
        } else
            return mB;
    }

    private static Integer computeWeights(ArrayList<Integer> pWeights,
            ArrayList<Integer> rList) {
        Iterator<Integer> iterA = rList.iterator();
        Integer result = 0;
        while (iterA.hasNext()) {
            result += pWeights.get(iterA.next());
        }
        return result;
    }

    private static ArrayList<Integer> generateRandomInput(Integer listSize,
            Integer valueSize) {

        Random randomGen = new Random();
        ArrayList<Integer> mList = new ArrayList<Integer>(listSize);
        for (int i = 0; i < listSize; i++) {
            mList.add(randomGen.nextInt(valueSize));
        }
        System.out.println("Input = " + mList);
        return mList;
    }
}
