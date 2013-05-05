package com.blogspot.vikkyrk;

import java.util.Random;

public class MatrixAlgorithms {

    private static class Matrix {
        int[][] arr;
        int rowSize, columnSize;

        Matrix(int[][] a) {
            arr = a;
            rowSize = a.length;
            columnSize = a[0].length;
        }

        Matrix(Matrix m) {
            rowSize = m.rowSize;
            columnSize = m.columnSize;
            arr = m.arr.clone();
        }
    }

    private static void log(String s) {
        System.out.println(s);
    }

    private static Matrix generateRandomMatrix(int sizeR, int sizeC,
            int maxDataValue) {
        Random rG = new Random();
        int[][] arr = new int[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++)
            for (int j = 0; j < sizeC; j++) {
                arr[i][j] = rG.nextInt(maxDataValue);
            }

        return new Matrix(arr);
    }

    public static void printMatrix(Matrix m) {
        log("Matrix: ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.rowSize; i++) {
            for (int j = 0; j < m.columnSize; j++) {
                sb.append(m.arr[i][j] + ", ");
            }
            sb.append("\n");
        }
        log(new String(sb));
    }

    public static void transposeMatrix(Matrix m) {
        if (m.rowSize != m.columnSize)
            throw new IllegalArgumentException(" RowSize != ColumnSize");

        for (int i = 0; i < m.rowSize; i++) {
            for (int j = 0; j < i; j++) {
                int temp = m.arr[i][j];
                m.arr[i][j] = m.arr[j][i];
                m.arr[j][i] = temp;
            }
        }
    }

    public static void swapRows(Matrix m, int i, int j) {
        if (i >= m.rowSize || j >= m.rowSize)
            throw new IllegalArgumentException("Invalid arguments");

        for (int k = 0; k < m.columnSize; k++) {
            int temp = m.arr[i][k];
            m.arr[i][k] = m.arr[j][k];
            m.arr[j][k] = temp;
        }
    }

    public static void swapColumns(Matrix m, int i, int j) {
        if (i >= m.columnSize || j >= m.columnSize)
            throw new IllegalArgumentException("Invalid arguments");

        for (int k = 0; k < m.rowSize; k++) {
            int temp = m.arr[k][i];
            m.arr[k][i] = m.arr[k][j];
            m.arr[k][j] = temp;
        }
    }

    public static void reverseRows(Matrix m) {
        for (int i = 0; i < m.rowSize / 2; i++) {
            swapRows(m, i, m.rowSize - i - 1);
        }
    }

    public static void reverseColumns(Matrix m) {
        for (int i = 0; i < m.columnSize / 2; i++) {
            swapColumns(m, i, m.columnSize - i - 1);
        }
    }

    public static void rotate90usingTranspose(Matrix m) {
        transposeMatrix(m);
        reverseColumns(m);
    }

    public static void rotate90Layerwise(Matrix m) {
        if (m == null || m.rowSize != m.columnSize)
            throw new IllegalArgumentException();

        int size = m.rowSize;

        for (int layer = 0; layer < size / 2; layer++) {
            int start = layer;
            int end = size - 1 - layer;
            log("start-end = " + start + "-" + end);
            for (int i = 0; i < end - start; i++) {
                int temp = m.arr[start][start + i];
                m.arr[start][start + i] = m.arr[end - i][start];
                m.arr[end - i][start] = m.arr[end][end - i];
                m.arr[end][end - i] = m.arr[start + i][end];
                m.arr[start + i][end] = temp;
            }
        }
    }

    public static void matrixTests() {
        Matrix m = generateRandomMatrix(1, 1, 5);
        printMatrix(m);
        // rotate90usingTranspose(m);
        // rotate90Layerwise(m);
        // printMatrix(m);
        //printSpiral(m);
        

    }

    public static void printSpiral(Matrix input) {
        if (input == null || input.rowSize != input.columnSize) {
            throw new RuntimeException("Input invalid");
        }

        log("Spiral Matrix");

        for (int i = 0; i < (input.rowSize + 1) / 2; i++) {
            int r = i, c = i;
            for (int k = 0; k < 4; k++) {
                int m = input.rowSize - 1 - 2 * i;
                int rx, cx;

                if (k % 2 == 0) {
                    cx = 1;
                    rx = 0;
                } else {
                    rx = 1;
                    cx = 0;
                }

                if (k > 1) {
                    rx = rx * -1;
                    cx = cx * -1;
                }

                for (int j = 0; j < m; j++) {
                    System.out.print("" + input.arr[r][c] + " ");
                    r += rx;
                    c += cx;
                }

                if (m == 0) {
                    System.out.print("" + input.arr[r][c] + " ");
                    break;
                }
            }
        }
    }

    public void diagonalPrint(Matrix m) {
        int r=0, c=0;
        int st=0;
        while(true) {
            if(r < m.rowSize)
                r++;
            else if (true)
                st++;
            else if(st < m.columnSize)
                st++;
            
            
        }
    }
}
