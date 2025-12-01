package com.app;

public class App {

  public void submatrixSwap(int[][] matrix, int[] coord_S1, int[] coord_S2) {
    /*COORDS Layout
    [LEFT_ROW, RIGHT_ROW, LEFT_COLUMN, RIGHT_COLUMN]
    Both Rights are 0 index so Value - 1
    */
    int leftRow_S1 = coord_S1[0], rightRow_S1 = coord_S1[1], leftCol_S1 = coord_S1[2], rightCol_S1 = coord_S1[3];
    int leftRow_S2 = coord_S2[0], rightRow_S2 = coord_S2[1], leftCol_S2 = coord_S2[2], rightCol_S2 = coord_S2[3];
    int swapRowNumb_S1 = rightRow_S1 - leftRow_S1 , swapColNumb_S1 = rightCol_S1 - leftCol_S1;
    int swapRowNumb_S2 = rightRow_S2 - leftRow_S2 , swapColNumb_S2 = rightCol_S2 - leftCol_S2;

    int[][] matrix_S1 = new int[swapRowNumb_S1][swapColNumb_S1];
    int[][] matrix_S2 = new int[swapRowNumb_S2][swapColNumb_S2];

    //Temporary Array S1
    for (int i = leftRow_S1; i<rightRow_S1;i++){
      for (int j = leftCol_S1; j<rightCol_S1;j++){
        matrix_S1[i - leftRow_S1][j - leftCol_S1] = matrix[i][j];
      }
    }
    //Temporary Array S2
    for (int i = leftRow_S2; i<rightRow_S2;i++){
      for (int j = leftCol_S2; j<rightCol_S2;j++){
        matrix_S2[i - leftRow_S2][j - leftCol_S2] = matrix[i][j];
      }
    }

    //Swappign the Positions
    for (int i = leftRow_S1; i<rightRow_S1;i++){
      for (int j = leftCol_S1; j<rightCol_S1;j++){
        matrix[i][j] = matrix_S2[i - leftRow_S1][j - leftCol_S1];
      }
    }
    for (int i = leftRow_S2; i<rightRow_S2;i++){
      for (int j = leftCol_S2; j<rightCol_S2;j++){
        matrix[i][j] = matrix_S1[i - leftRow_S2][j - leftCol_S2];
      }
    }
  }
}
