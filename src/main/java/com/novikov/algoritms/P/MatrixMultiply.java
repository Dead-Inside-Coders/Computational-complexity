package com.novikov.algoritms.P;

public class MatrixMultiply {
    public static int[][] matrixMultiply(int[][] A, int B[][], int N) {
        int[][] C = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
            {
                C[i][j] = 0;
                for(int k = 0; k < N; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }
}
