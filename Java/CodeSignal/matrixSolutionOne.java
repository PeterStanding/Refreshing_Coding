package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class App {
    public List<int[]> solution(int[][] matrix) {
        /* Matrix Info
        N = rows, M = Columns
        Populated from Range 1 - 100 inclusive
        Can contain either Positive, Negative or Zero
        */
        /*About Task
        Travserse Matrix from Top left to bottom Right in a Zig Zag pattern
        Task is too return a list of tuples, each tuple contains the index pair of Cells with negative integers
        */

        List<int[]> output = new ArrayList<int[]>();
        List<Integer> traversal = new ArrayList<Integer>();
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = 0, d = 0;
        int[] holder = {0,0};
        for (int i = 0; i < (rows*cols); i++){
            //Adds the current value a traversal Matrix
            traversal.add(matrix[row][col]);

            //Checks to see if the current Value is < 0
            //If so, update holder values to be Matrix Location of the value and add to Output ArrayList
            if (matrix[row][col] < 0){
                holder[0] = row;
                holder[1] = col;
                output.add(holder);
            }
            //Traversing the Matrix
            if (d == 1){ //Moves Down Right
                if (row == rows-1){
                    col += 1;
                    d = -1;
                } else if (col == 0){
                    row += 1;
                    d = -1;
                } else {
                    row += 1;
                    col -= 1;
                }
            } else { //Moves Up Left
                if (col == cols-1){
                    row += 1;
                    d = 1;
                } else if (row == 0){
                    col += 1;
                    d = 1;
                } else {
                    row -= 1;
                    col += 1;
                }
            }
        }
        return output;
    }
}
