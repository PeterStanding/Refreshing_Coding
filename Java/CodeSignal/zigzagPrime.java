package com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class App {

    private static boolean isPrime(int n) {
        //https://www.geeksforgeeks.org/java/java-prime-number-program/
        boolean pass = true;

        if (n <=1){
            pass = false;
        }

        for (int j = 2;j<n;j++){
            if (n % j == 0){
                pass = false;
            }
        }
        return pass;
    }

    public Map<Integer, Integer> zigzagTraverseAndPrimes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = 0, dir = 0;
        int lastDir = 0;

        Map<Integer, Integer> output = new HashMap<>();
        ArrayList<Integer> traversal = new ArrayList<>();

        for (int i = 0; i <(rows*cols);i++){
            traversal.add(matrix[row][col]);
            if (dir == 0){ //MOVING RIGHT
                if (col == cols - 1){
                    row += 1;
                    dir = 1;
                    lastDir = 0;
                } else {
                    col+=1;
                }
            } else if (dir == 1){ //MOVING DOWN
                if (lastDir == 0){
                    col -= 1;
                    dir = 2;
                } else if (lastDir == 1){
                    dir = 0;
                    col +=1;
                }
            } else if (dir == 2){ //MOVING LEFT
                if (col == 0){
                    lastDir = 1;
                    row += 1;
                    dir = 1;
                } else {
                    col -= 1;
                }
            }
        }

        boolean in = false;
        int c = 0;
        for (int x : traversal){
            in = isPrime(x);
            if (in){
                output.put(c,x);
            }
            c++;
        }

        return output;
    }
}
