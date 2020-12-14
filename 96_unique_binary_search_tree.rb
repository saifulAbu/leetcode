package com.company;

public class UniqueBST {
  public int numTrees(int n) {
    int [] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for(int numNodes = 2; numNodes <= n; numNodes++) {
      int leftNodesCount = 0;
      int rightNodesCount = numNodes - 1;
      int count = 0;
      for(int root = 1; root <= numNodes; root++) {
        count += dp[leftNodesCount] * dp[rightNodesCount];
        leftNodesCount++;
        rightNodesCount--;
      }
      dp[numNodes] = count;
    }

    return dp[n];
  }

  public static void main(String [] args) {
    UniqueBST tree = new UniqueBST();
    System.out.println(tree.numTrees(2));
  }
}
