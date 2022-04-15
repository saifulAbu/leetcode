package trees_and_graphs;

import java.util.*;

public class CheapestFlight_787 {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    HashMap<Integer, List<int[]>> graph = buildAdjList(flights);
    int[] curCost = new int[n];
    int[] nextCost = new int[n];
    Arrays.fill(curCost, Integer.MAX_VALUE);
    Arrays.fill(nextCost, Integer.MAX_VALUE);
    curCost[src] = nextCost[src] = 0;
    for (int i = 0; i < k + 1; i++) {
      for (int curSrc = 0; curSrc < n; curSrc++) {
        if (!graph.containsKey(curSrc) || curCost[curSrc] == Integer.MAX_VALUE) {
          continue;
        }
        for (int[] nEdge : graph.get(curSrc)) {
          int neighbor = nEdge[0];
          int curCostToNeighbor = nEdge[1] + curCost[curSrc];
          if (curCostToNeighbor < nextCost[neighbor]) {
            nextCost[neighbor] = curCostToNeighbor;
          }
        }
      }
      int [] t = curCost;
      curCost = nextCost;
      nextCost = t;
    }
    return curCost[dst] == Integer.MAX_VALUE? -1 : curCost[dst];
  }

  public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
    HashMap<Integer, List<int[]>> graph = buildAdjList(flights);
    int[] cost = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);
    Queue<Integer> q = new ArrayDeque<>();
    HashSet<Integer> inQ = new HashSet<>();
    cost[src] = 0;
    q.add(src);
    inQ.add(src);
    for (int i = 0; i < k + 1 && !q.isEmpty(); i++) {
      int curQSize = q.size();
      for (int count = 0; count < curQSize; count++) {
        int curSrc = q.poll();
        inQ.remove(curSrc);
        if (!graph.containsKey(curSrc)) {
          continue;
        }
        for (int[] nEdge : graph.get(curSrc)) {
          int neighbor = nEdge[0];
          int curCost = nEdge[1] + cost[curSrc];
          if (curCost < cost[neighbor]) {
            cost[neighbor] = curCost;
            if (!inQ.contains(neighbor)) {
              q.add(neighbor);
              inQ.add(neighbor);
            }
          }
        }
      }
    }
    int minCost = cost[dst];
    return minCost==Integer.MAX_VALUE ? -1:minCost;
  }

  private HashMap<Integer, List<int[]>> buildAdjList(int[][] times) {
    HashMap<Integer, List<int[]>> hashMap = new HashMap<>();
    for (int[] edge : times) {
      int src = edge[0] - 1;
      int dst = edge[1] - 1;
      int wt = edge[2];
      hashMap.putIfAbsent(src, new ArrayList<int[]>());
      List<int[]> neighborList = hashMap.get(src);
      neighborList.add(new int[]{dst, wt});
    }
    return hashMap;
  }
}
