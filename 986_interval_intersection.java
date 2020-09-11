package com.company;

import java.util.ArrayList;

public class IntervalFinding {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> result = new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        while(aIndex < A.length && bIndex < B.length) {
            int[] aEntry, bEntry;
            int lowInterval, highInterval;
            aEntry = A[aIndex];
            bEntry = B[bIndex];

            lowInterval = Math.max(aEntry[0], bEntry[0]);
            highInterval = Math.min(aEntry[1], bEntry[1]);

            if(lowInterval <= highInterval) {
                result.add(new int[]{lowInterval, highInterval});
            }
            if(A[aIndex][1] < B[bIndex][1]) {
                aIndex++;
            } else {
                bIndex++;
            }
        }
        return  result.toArray(new int[result.size()][]);
    }

    public static void main(String args[]){
        int [][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};

        IntervalFinding intF = new IntervalFinding();
        int[][] result = intF.intervalIntersection(A, B);
        return;
    }
}
