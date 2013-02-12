package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.List;

public class LCSGeneric {

    public static <T extends Comparable<T>> List<T> computeLCS(List<T> la,
            List<T> lb) {

        if ((la == null) || (lb == null))
            return null;
        if ((la.size() == 0) || (lb.size() == 0))
            return new ArrayList<T>();

        int lenA = la.size() + 1;
        int lenB = lb.size() + 1;
        int[][] lcs = new int[lenA][lenB];

        for (int i = 0; i < lenA; i++)
            lcs[i][0] = 0;
        for (int j = 0; j < lenB; j++)
            lcs[0][j] = 0;

        for (int i = 1; i < lenA; i++)
            for (int j = 1; j < lenB; j++)
                if (la.get(i - 1).equals(lb.get(j - 1)))
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                else
                    lcs[i][j] = lcs[i - 1][j] > lcs[i][j - 1] ? lcs[i - 1][j]
                            : lcs[i][j - 1];

        int size = lcs[lenA - 1][lenB - 1];
        ArrayList<T> rList = new ArrayList<T>(size);

        // Fill List with dummy data
        for (int i = 0; i < size; i++) {
            rList.add(i, null);
        }
        int i = lenA - 1;
        int j = lenB - 1;

        while (size != 0) {
            if ((lcs[i][j] > lcs[i - 1][j]) && (lcs[i][j] > lcs[i][j - 1])) {
                rList.set(size - 1, la.get(i - 1));
                size--;
            }

            if (lcs[i - 1][j] > lcs[i][j - 1])
                i--;
            else
                j--;
        }

        return rList;
    }
}