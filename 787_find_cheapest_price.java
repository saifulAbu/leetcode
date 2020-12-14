package com.company;

import java.util.ArrayList;
import java.util.List;

public class CheapestFlight {
  static class Node {
    int src;
    int dest;
    int cost;
    Node(int src, int dest, int cost) {
      this.src = src;
      this.dest = dest;
      this.cost = cost;
    }
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

    //form graph
    List<List<Node>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    boolean [] visited = new boolean[n];
    for(int[] flight : flights) {
      int srcNode = flight[0];
      int dstNode = flight[1];
      int cost = flight[2];
      graph.get(srcNode).add(new Node(srcNode, dstNode, cost));
    }

    return dfsHelper(src, dst, K + 1, Integer.MAX_VALUE, 0, visited, graph);
  }

  int dfsHelper(int curNode, int dest, int k, int minCost, int curCost, boolean[] visited, List<List<Node>> graph) {
    if(k == 0 && curNode != dest) {
      return minCost;
    }
    if(curCost > minCost) {
      return minCost;
    }
    if(curNode == dest) {
      return curCost;
    }

    visited[curNode] = true;
    for(Node neighbor : graph.get(curNode)) {
      int costThroughNeighbor = 0;
      if(visited[neighbor.dest]) {
        continue;
      }
      costThroughNeighbor = dfsHelper(neighbor.dest, dest,k-1, minCost, curCost + neighbor.cost, visited, graph);
      if(costThroughNeighbor < minCost) {
        minCost = costThroughNeighbor;
      }
    }
    visited[curNode] = false;
    return minCost;
  }

  public static void main(String args[]) {
    int n = 3;
    int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
    int src = 0;
    int dst = 0;
    int k = 1;

    CheapestFlight flightSoln = new CheapestFlight();
    int soln = flightSoln.findCheapestPrice(n, edges, src, dst, k);
    System.out.println(soln);
    return;
  }
}
