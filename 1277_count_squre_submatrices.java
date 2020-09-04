package com.company;

public class CountMatrix {
    public int countSquares(int[][] matrix) {
        int result = 0;
        final int R = matrix.length;
        final int C = matrix[0].length;

        int [][] resMatrix = new int[R][C];

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                resMatrix[r][c] = matrix[r][c];
            }
        }

        for(int r = 1; r < R; r++){
            for(int c = 1; c < C; c++){
                if(resMatrix[r][c] == 1) {
                    int min = Math.min(Math.min(resMatrix[r][c-1], resMatrix[r-1][c]), resMatrix[r-1][c-1]);
                    resMatrix[r][c] = min + 1;
                }
            }
        }

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                result += resMatrix[r][c];
            }
        }

        return result;
    }

    public static void main(String args[]){
        CountMatrix c = new CountMatrix();

        int[][] input = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };

        int [][] input2 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };

        System.out.println(c.countSquares(input2));

    }
}