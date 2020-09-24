package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
  //comparator descending order for profits
  //here profit is cost to go to A - cost to go to B
  class CostComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] c1, int[] c2) {
      int profit1 = c1[1] - c1[0];
      int profit2 = c2[1] - c2[0];
      return profit2 - profit1;
    }
  }
  public int twoCitySchedCost(int[][] costs) {
    int n = costs.length / 2;
    Arrays.sort(costs, new CostComparator());
    int minCost = 0;
    for(int i = 0; i < n; i++) {
      minCost += costs[i][0];
    }
    for(int i = n; i < costs.length; i++) {
      minCost += costs[i][1];
    }
    return minCost;
  }

  public static void main(String args[]) {

  }
}
