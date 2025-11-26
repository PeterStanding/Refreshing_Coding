package com.app;

public class App {
    public int[][] interleaveMatrices(int[][] matrixA, int[][] matrixB, int[][] submatrixCoords) {

        int startRowA = submatrixCoords[0][0];
        int endRowA = submatrixCoords[0][1];
        int startColA = submatrixCoords[0][2];
        int endColA = submatrixCoords[0][3];

        int startRowB = submatrixCoords[1][0];
        int endRowB = submatrixCoords[1][1];
        int startColB = submatrixCoords[1][2];
        int endColB = submatrixCoords[1][3];

        int numRows = endRowA - startRowA + 1;
        int numColsA = endColA - startColA + 1;
        int numColsB = endColB - startColB + 1;

        int[][] resultMatrix = new int[numRows][numColsA + numColsB];
        int[][] submatrixA = new int[numRows][numColsA];
        int[][] submatrixB = new int[numRows][numColsB];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColsA; j++) {
                submatrixA[i][j] = matrixA[startRowA + i][startColA + j];
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColsB; j++) {
                submatrixB[i][j] = matrixB[startRowB + i][startColB + j];
            }
        }

        // The part for the concatenation process
        int countA = 0, countB = 0;
        for (int i = 0; i < numRows; i++) {
            countA = 0;
            countB = 0;
            for (int j = 0; j < (submatrixA[0].length + submatrixB[0].length);j++){
                if (j % 2 == 0){
                    resultMatrix[i][j] = submatrixA[i][countA];
                    countA++;
                } else {
                    resultMatrix[i][j] = submatrixB[i][countB];
                    countB++;
                }
            }
        }

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        return resultMatrix;
    }
}
