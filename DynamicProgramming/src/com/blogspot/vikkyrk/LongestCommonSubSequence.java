package com.blogspot.vikkyrk;

public class LongestCommonSubSequence {

    public static String computeLCS(String a, String b) {
        if ((a == null) || (b == null))
            return "";
        return computeLCS(a.toCharArray(), a.length(), b.toCharArray(),
                b.length());
    }

    private static String computeLCS(char[] a, int lenA, char[] b, int lenB) {

        String s = null;
        if ((a == null) || (b == null) || (lenA == 0) || (lenB == 0)) {
            return s;
        }

        if (a[lenA - 1] == b[lenB - 1]) {
            s = computeLCS(a, lenA - 1, b, lenB - 1);
            return (s != null) ? (s + a[lenA - 1]) : "" + (a[lenA - 1]);
        } else {
            String s1 = computeLCS(a, lenA - 1, b, lenB);
            String s2 = computeLCS(a, lenA, b, lenB - 1);

            if (s1 == null)
                return s2;
            else if (s2 == null)
                return s1;
            else
                return (s1.length() > s2.length()) ? s1 : s2;
        }
    }

    public static String computeLCSDynamic(String aa, String bb) {
        if (aa == null || bb == null || aa.length() == 0 || bb.length() == 0)
            return "";
        char[] a = aa.toCharArray();
        char[] b = bb.toCharArray();

        int lenA = a.length + 1;
        int lenB = b.length + 1;
        int[][] lcs = new int[lenA][lenB];

        for (int i = 0; i < lenA; i++)
            lcs[i][0] = 0;
        for (int j = 0; j < lenB; j++)
            lcs[0][j] = 0;

        for (int i = 1; i < lenA; i++)
            for (int j = 1; j < lenB; j++)
                if (a[i - 1] == b[j - 1])
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                else
                    lcs[i][j] = lcs[i - 1][j] > lcs[i][j - 1] ? lcs[i - 1][j]
                            : lcs[i][j - 1];

        int size = lcs[lenA - 1][lenB - 1];
        char[] cLcs = new char[size];
        int i = lenA - 1;
        int j = lenB - 1;

        while (size != 0) {
            if ((lcs[i][j] > lcs[i - 1][j]) && (lcs[i][j] > lcs[i][j - 1])) {
                cLcs[size - 1] = a[i - 1];
                size--;
            }

            if (lcs[i - 1][j] > lcs[i][j - 1])
                i--;
            else
                j--;
        }

        return new String(cLcs);
    }
}
