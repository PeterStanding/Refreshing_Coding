package com.app;

import java.util.List;
import java.util.ArrayList;

public class App {
    public List<Integer> matrixBoundaryConcatenation(int[][] matrixA, int[][] matrixB, int n) {
        // TODO: implement the function that extracts 'n' boundary layers from matrixA and matrixB,
        // merges them into a single list and then returns this new list.
        ArrayList<Integer> output = new ArrayList<Integer>();
        ArrayList<Integer> listA = new ArrayList<Integer>();
        ArrayList<Integer> listB = new ArrayList<Integer>();
        ArrayList<Integer> curr = new ArrayList<Integer>();

        for (int i = 0; i<n;i++){
            curr = helperMethod(i,matrixA);
            listA.addAll(curr);
            
            curr = helperMethod(i,matrixB);
            listB.addAll(curr);
        }


        for (int x : listA){
            output.add(x);
        }
        for (int y : listB){
            output.add(y);
        }

        return output;
    }
    public ArrayList<Integer> helperMethod(int layerNum,int [][] currMatrix){
        ArrayList<Integer> help = new ArrayList<Integer>();

        int startRow = 0+layerNum, startCol = 0+layerNum;
        int endRow = ((currMatrix.length-1) - layerNum), endCol = (currMatrix.length- layerNum);
        int row = 0+layerNum, col = 0+layerNum;
        //Top Row
        for (col = startCol; col < endCol;col++){
            help.add(currMatrix[startRow][col]);
        }
        //Right Col
        for (row = startRow + 1; row <= endRow; row++){
            help.add(currMatrix[row][endCol-1]);
        }
        //Bottom Row
        for (col = endCol - 2; col >= startCol;col--){
            help.add(currMatrix[endRow][col]);
        }
        //Left Col
        for (row = endRow - 1; row >=startRow + 1; row--){
            help.add(currMatrix[row][startCol]);
        }

        return help;
    }
}
