package com.blogspot.vikkyrk;

import java.util.ArrayList;
import java.util.List;

public class mainTest {

    public static void main(String[] args) {
        // MaxIndependentSet ms = new MaxIndependentSet(5);
        // ms.computeMIS();
        /*
         * String a = "abcaaeade"; String b = "abmnaaepa";
         * System.out.println(LongestCommonSeq.computeLCS(a,b));
         * System.out.println("LCS Specific = " +
         * LongestCommonSeq.computeLCSDynamic(a,b));
         * 
         * System.out.println("LCS Generic = " +
         * LCSGeneric.computeLCS(stringToList(a), stringToList(b)));
         * System.out.println(LACS.computeLCS(5));
         */
        // System.out.println(LongestIncreasingSeq.longestIncreasingSubSeq(10));

        // System.out.println(KnapSack.computeKnapSack(1, (int)(1.25)*20, 20));

        String m = "difjabxmno";
        String n = "idfjabydifjmno";

        LongestCommonSubstring.computeLCSS(m, n);
    }

    private static List<Character> stringToList(String a) {
        if (a == null)
            return null;
        char[] temp = a.toCharArray();
        List<Character> cList = new ArrayList<Character>(temp.length);
        for (int i = 0; i < temp.length; i++)
            cList.add(temp[i]);
        return cList;
    }
}