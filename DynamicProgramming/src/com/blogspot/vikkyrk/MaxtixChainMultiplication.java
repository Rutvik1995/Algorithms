package com.blogspot.vikkyrk;

//TODO: This problem and Optimal BSTs.. Both from Cormen Dynamic Programming
public class MaxtixChainMultiplication {
    /*
     * If there are 3 matrices, 8*6, 6*2, 2*4,
     * []p = {8,6,2,4}.
     * To get the exact order, create another
     * 2D array and store the 'k' value.
     */
    public static int getMinMatrixMult(int[] p) {
        int sz = p.length - 1;
        int[][] data = new int[sz+1][sz+1];
        for(int i=1; i<=sz; i++) {
            data[i][i] = 0;
        }

        for(int l=2; l<=sz; l++) {
            for(int i=1; i<=sz-l+1; i++) {
                int min = Integer.MAX_VALUE;
                int j = l+i-1;
                for(int k=i; k<j; k++) {
                    int temp = data[i][k] + data[k+1][j] + p[i-1] * p[k] * p[j];
                    if(temp < min)
                    min = temp;
                    //s[i][j] = k -> to get the order of multiplications
                }
                data[i][j] = min;
            }
        }
        return data[1][sz];
    }
}
