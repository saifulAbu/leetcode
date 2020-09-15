package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class BiPartition {
  private ArrayList<ArrayList<Integer>> graph;
  private HashMap<Integer, Integer> colorMap;

  public boolean possibleBipartition(int N, int[][] dislikes) {
    graph = new ArrayList<>(N+1);
    graph.add(null);
    colorMap = new HashMap<>();

    for(int node = 1; node <= N; node++) {
      graph.add(new ArrayList<Integer>());
    }

    //construct dislike graph
    for(int [] edge : dislikes) {
      int src = edge[0];
      int dest = edge[1];
      graph.get(src).add(dest);
      graph.get(dest).add(src);
    }

    for(int node = 1; node <= N; node++) {
      if(!colorMap.containsKey(node) && !canBeColoredWithColor(node, 0)) {
        return false;
      }
    }

    //check coloring
    return true;
  }

  boolean canBeColoredWithColor(int node, int color) {
    if(colorMap.containsKey(node) && colorMap.get(node) != color) {
      return false;
    }

    colorMap.put(node, color);
    System.out.println("node: " + node + " color: " + color);

    //traverse through neighbors and give them color
    ArrayList<Integer> edgeList = graph.get(node);
    int neighborColor = 1 - color;
    for(int neighbor : edgeList) {
      // do not call recursive calls on visited nodes
      if(colorMap.containsKey(neighbor) && colorMap.get(neighbor) != neighborColor) {
        return false;
      }
      if(!colorMap.containsKey(neighbor) && !canBeColoredWithColor(neighbor, neighborColor)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    BiPartition soln = new BiPartition();
    int[][] dislikes = {{1,2},{1,3},{2,4}, {1,4}};
    boolean possible = soln.possibleBipartition(4, dislikes);
    return;
  }
}
