package com.blogspot.vikkyrk;

@SuppressWarnings("unused")
public class LongestCommonSubstring {
    private static int count = 0;

    public static String computeLCSS(String a, String b) {
        if ((a == null) || (b == null))
            return "";
        return computeLCSS(a.toCharArray(), a.length(), b.toCharArray(),
                b.length());
    }

    private static String computeLCSS(char[] a, int lenA, char[] b, int lenB) {
        myInt len = new myInt(0, 0);
        int lcssLength = 0;
        // computeLCSSLength(a,lenA,b,lenB,len);
        // lcssLength = len.a;

        lcssLength = computeLCSSLengthAnother(a, lenA, b, lenB);

        System.out
                .println("Length of LCS = " + lcssLength + "Count = " + count);
        return null;
    }

    private static void computeLCSSLength(char[] a, int lenA, char[] b,
            int lenB, myInt tlen) {
        count++;
        if (lenA == 0 || lenB == 0) {
            tlen.a = 0;
            tlen.b = 0;
            return;
        }

        int t1 = 0, t2, t3;

        if (a[lenA - 1] == b[lenB - 1]) {
            computeLCSSLength(a, lenA - 1, b, lenB - 1, tlen);
            t1 = tlen.b + 1;
        }

        computeLCSSLength(a, lenA - 1, b, lenB, tlen);
        t2 = tlen.a;

        computeLCSSLength(a, lenA, b, lenB - 1, tlen);
        t3 = tlen.a;

        tlen.a = t1 > t2 ? (t1 > t3 ? t1 : t3) : (t2 > t3 ? t2 : t3);
        tlen.b = t1;
    }

    /*
     * This one does not work. Use the iterative approach.
     */
    private static int computeLCSSLengthAnother(char[] a, int lenA, char[] b,
            int lenB) {
        count++;
        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        int t1 = 0, t2, t3;

        if (a[lenA - 1] == b[lenB - 1]) {
            t1 = computeLCSSLengthAnother(a, lenA - 1, b, lenB - 1);
            t1++;
        }

        t2 = computeLCSSLengthAnother(a, lenA - 1, b, lenB);

        t3 = computeLCSSLengthAnother(a, lenA, b, lenB - 1);

        return t1 > t2 ? (t1 > t3 ? t1 : t3) : (t2 > t3 ? t2 : t3);
    }

    private static class myInt {
        int a;
        int b;

        myInt(int m, int n) {
            a = m;
            b = n;
        }
    }
}
