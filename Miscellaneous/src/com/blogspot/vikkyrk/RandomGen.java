package com.blogspot.vikkyrk;

import java.util.Random;

public class RandomGen {
    
    public static void randomShuffle(int[] arr) {
        int n = arr.length;
        Random rG = new Random();
        for(int i=0; i<n; i++) {
            swap(arr,n-i-1,rG.nextInt(n-i));
        }
    }

    /*
     * Programming pearls.
     * Sorted Random Numbers, O(n)
     * Another way is to initialize an array and then 
     * do a randomShuffle for and choose k elements
     * and sort them
     */
    public static void printRandomSorted(int n, int m) {
        System.out.println("Random Sorted " + m +" Numbers");
        
        int num = m;
        int den = n;
        Random rG = new Random();
        while(num > 0) {
            if(rG.nextInt(den) < num) {
                System.out.print(n-den + " ");
                num--;
            }
            den--;
        }
    }
    
    /*
     * More details http://blogs.msdn.com/b/spt/archive/2008/02/05/reservoir-sampling.aspx
     * Distributed version is awesome
     */
    public static void reservoirSampling(int[] arr, int s) {
        int k = s+1;
        Random rG = new Random();
        while(k<arr.length) {
            int r = rG.nextInt(k);
            if(r<s) {
                swap(arr, rG.nextInt(s), k);
            }
            k++;
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    
    
}

