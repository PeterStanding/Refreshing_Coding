package com.app;

import java.util.ArrayList;
import java.util.*;

public class App {
    public int[] spiralTraverseAndVowels(char[][] grid) {

      ArrayList<Character> traversal = new ArrayList<Character>();
        ArrayList<Integer> occur = new ArrayList<>();

        int rows = grid.length, cols = grid[0].length, size = rows*cols;
        int row = 0, col = 0, dir = 0, right = 0, down = 0, count = 0;

        /*Directions
        Dir = 0 --> RIGHT
        Dir = 1 --> LEFT
        Dir = 2 --> UP
        Dir = 3 --> DOWN
        */
        for (int i = 0; i < size;i++){
            traversal.add(grid[row][col]);
            if (traversal.get(i).equals('a')||traversal.get(i).equals('e')||traversal.get(i).equals('i')||traversal.get(i).equals('o')||traversal.get(i).equals('u')){
                occur.add(count);
            }
            count++;
            if (dir == 0){          //Moving RIGHT
                if (right == 1){
                    if (col == cols - 2){
                        col-=1;
                        dir = 3;
                        right++;
                    } else if (row == 0){
                        col += 1;
                    } else {
                        col += 1;
                    }
                }
                if (col == cols - 1){
                    row += 1;
                    dir = 3;
                    right++;
                } else if (row == 0){
                    col += 1;
                } else {
                    col += 1;
                }
            } else if (dir == 3){   //Moving DOWN
                if (down == 1){
                    if (row == rows - 2){
                        col -= 1;
                        dir = 1;
                        down++;
                    } else if (col == cols -2){
                        row += 1;
                    }
                }
                if (row == rows -1){
                    col -= 1;
                    dir = 1;
                    down++;
                } else if (col == cols -1){
                    row += 1;
                }
            } else if (dir == 1){   //Moving LEFT
                if (col == 0){
                    row -=1;
                    dir = 2;
                } else if (row == rows -1 ){
                    col -= 1;
                }
            } else if (dir == 2){   //Moving UP
                if (row == 1){
                    col += 1;
                    dir = 0;
                } else if (col == 0){
                    row -= 1;
                }
            }
        }

        count = 0;
        for (char ind : traversal){
            if (ind == 'a'||ind == 'e'||ind == 'i'||ind == 'o'||ind == 'u'){
                count++;
            }
        }

        int[] output = new int[count];
        count = 0;

        for (int i : occur){
            output[count] = i;
            count++;
        }

        return output;
    }
}
