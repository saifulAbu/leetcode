package trees_and_graphs;

import java.util.*;

public class MinHeightTrees_310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if(n <= 2) {
      List<Integer> res = new LinkedList<>();
      if(n == 1) {
        res.add(0);
      } else {
        res.add(edges[0][0]);
        res.add(edges[0][1]);
      }
      return res;
    }
    return topologicalSort(n, edges);
  }
  // think more about how we can transform this problem to topological sorting problem

  Set<Integer>[] getGraph(int n, int[][] edges) {
    Set<Integer>[] graph = new Set[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new HashSet<>();
    }

    for(int[] edge : edges) {
      int v0 = edge[0];
      int v1 = edge[1];
      graph[v0].add(v1);
      graph[v1].add(v0);
    }
    return graph;
  }

  int [] getIndegree(Set<Integer>[] graph) {
    int [] inDegree = new int[graph.length];
    for(int i = 0; i < graph.length; i++) {
      for(int neighbor : graph[i]) {
        inDegree[neighbor]++;
      }
    }
    return inDegree;
  }

  List<Integer> topologicalSort(int n, int [][] edges) {
    Set<Integer>[] graph = getGraph(n, edges);
    int [] indegree = getIndegree(graph);
    List<Integer> q = new LinkedList<>();
    Set<Integer> seen = new HashSet<>();
    //Set<Integer> processed = new HashSet<>();

    for(int i = 0; i < indegree.length; i++) {
      if(indegree[i] == 1) {
        q.add(i);
        seen.add(i);
      }
    }

    int remaining = n;
    while (remaining > 2) {
      int curSize = q.size();
      for(int i = 0; i < curSize; i++) {
        int v0 = q.remove(0);
        remaining--;
        //traverse through neighbors
        for(int v1 : graph[v0]) {
          if(seen.contains(v1)) {
            continue;
          }
          indegree[v1]--;
          if(indegree[v1] == 1) {
            q.add(v1);
            seen.add(v1);
          }
        }
      }
    }
    return q;
  }

  public static void main(String args[]) {
    int[][] edges = {{3, 1}, {1, 0},{0, 2}, {2,4}, {4,5}};
    int n = 6;
    //int[][] edges = {{2, 0}, {3, 0}, {1, 4}, {1, 5}, {0, 6}, {6, 1}};
    //int n = 7;

    MinHeightTrees_310 mht = new MinHeightTrees_310();
    Set<Integer>[] graph = mht.getGraph(n , edges);
    int[] indegree = mht.getIndegree(graph);
    List<Integer> res = mht.findMinHeightTrees(n, edges);
    System.out.println("hello, world!");
  }
}
// did not do anything