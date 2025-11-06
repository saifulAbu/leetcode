package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses_1136 {
  public int minimumSemesters(int n, int[][] relations) {
    return topologicalSort(n, transformZeroBased(relations));
  }

  private int[][] transformZeroBased(int[][] relations) {
    for(int [] edge : relations) {
      edge[0]--;
      edge[1]--;
    }
    return relations;
  }

  public int topologicalSort(int n, int[][] relations) {
    List<Integer>[] graph = buildGraph(n, relations);
    int [] indegree = buildIndegree(graph);
    int numprocessed = 0;
    int level = 0;
    Queue<Integer> q = new LinkedList<>();
    populateQueue(q, indegree);
    while(!q.isEmpty()) {
      int curSize = q.size();
      for(int i = 0; i < curSize; i++) {
        int v0 = q.poll();
        numprocessed++;
        for(int v1 : graph[v0]) {
          indegree[v1]--;
          if(indegree[v1] == 0) {
            q.offer(v1);
          }
        }
      }
      level++;
    }
    if(numprocessed == n) {
      return level;
    }
    return -1;
  }

  public void populateQueue(Queue<Integer> q, int[] indegree) {
    for(int i = 0; i < indegree.length; i++) {
      if(indegree[i] == 0) {
        q.add(i);
      }
    }
  }

  public List<Integer>[] buildGraph(int n, int[][] relations) {
    List<Integer>[] graph = new List[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new LinkedList<>();
    }
    for(int[] edge : relations) {
      int v0 = edge[0];
      int v1 = edge[1];
      graph[v0].add(v1);
    }
    return graph;
  }

  public int[] buildIndegree(List<Integer>[] graph) {
    int n = graph.length;
    int[] inDegree = new int[n];
    for(int v0 = 0; v0 < n; v0++) {
      for(int v1 : graph[v0]) {
        inDegree[v1]++;
      }
    }
    return inDegree;
  }

  public static void main(String args[]) {
    ParallelCourses_1136 pr = new ParallelCourses_1136();
    int n = 3;
    int[][] edges = {{1, 2}, {2, 3}};
    //List<Integer>[] leetcode.graph = pr.buildGraph(n, edges);
    int l = pr.minimumSemesters(n, edges);
    System.out.println("hello, world!");
  }
}
