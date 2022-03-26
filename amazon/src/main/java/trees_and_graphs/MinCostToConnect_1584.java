package trees_and_graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnect_1584 {
  public int minCostConnectPoints(int[][] points) {
    //form priority queue
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[2] - t1[2];
      }
    });

    int n = points.length;
    //form disantance and populate prirotiy queue
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
        pq.offer(new int[] {i, j, weight});
      }
    }

    //use disjoint to make sure we are not forming a loop, we need a tree
    DisjoinSet ds = new DisjoinSet(n);
    int numEdges = 0;
    int totalWeight = 0;
    while (numEdges < n - 1) {
      int [] curEdge = pq.poll();
      int i = curEdge[0];
      int j = curEdge[1];
      int w = curEdge[2];
      if (ds.find(i) != ds.find(j)) {
        ds.union(i, j);
        numEdges++;
        totalWeight += w;
      }
    }
    return totalWeight;
  }
}

class DisjoinSet {
  int [] rank, parent;
  int size;
  int numCompoonents;

  DisjoinSet(int size) {
    this.size = size;
    parent = new int[size];
    numCompoonents = size;

    for (int i = 0; i < size; i++) {
      parent[i] = -1;
    }
  }

  public boolean connected(int n0, int n1) {
    return find(n0) == find(n1);
  }

  public int find(int n) {
    if (parent[n] < 0) {
      return n;
    }
    return parent[n] = find(parent[n]);
  }

  public void union(int n0, int n1) {
    int p0 = find(n0);
    int p1 = find(n1);
    if (p0 == p1) {
      return;
    } else if (Math.abs(parent[p0]) > Math.abs(parent[p1])) {
      parent[p1] = p0;
    } else {
      parent[p0] = p1;
      parent[p1]--;
    }
    numCompoonents--;
  }

  public int getNumCompoonents() {
    return numCompoonents;
  }
}

