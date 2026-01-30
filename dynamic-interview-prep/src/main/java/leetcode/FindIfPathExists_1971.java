package leetcode;

import java.util.LinkedList;

public class FindIfPathExists_1971 {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    if(source == destination) {
      return true;
    }

    LinkedList<Integer>[] adjList = new LinkedList[n];
    buildAdjacencyGraph(edges, n, adjList);

    boolean visited[] = new boolean[n];
    visited[source] = true;
    return searchDestinationsDFS(adjList, visited, source, destination);
  }

  private boolean searchDestinationsDFS(LinkedList<Integer>[] adjList, boolean[] visited, int curNode, int destination) {
    for(int neighbor : adjList[curNode]) {
      if(!visited[neighbor]) {
        if(neighbor == destination) {
          return true;
        }
        visited[neighbor] = true;
        if(searchDestinationsDFS(adjList, visited, neighbor, destination)) {
          return true;
        }
      }
    }
    return false;
  }

  private void buildAdjacencyGraph(int[][] edges, int n, LinkedList<Integer>[] neighborList) {
    for(int i = 0; i < n; i++) {
      neighborList[i] = new LinkedList<>();
    }

    for(int[] edge : edges) {
      int node0 = edge[0];
      int node1 = edge[1];

      neighborList[node0].add(node1);
      neighborList[node1].add(node0);
    }
  }

}
