package alpha_rep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime_743 {
  public int networkDelayTime(int[][] times, int n, int k) {
    HashMap<Integer, List<int[]>> grph = buildAdjList(times);
    int[] timeStamp = new int[n];
    Arrays.fill(timeStamp, Integer.MAX_VALUE);
    boolean[] visited = new boolean[n];
    int visitedCount = 0;
    k = k - 1;
    timeStamp[k] = 0;

    while (visitedCount < n) {
      int curNode = -1;
      int minTimeStamp = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if (!visited[i] && timeStamp[i] < minTimeStamp) {
          curNode = i;
          minTimeStamp = timeStamp[i];
        }
      }
      if (curNode == -1) {
        return -1;
      }
      visited[curNode] = true;
      visitedCount++;
      if (!grph.containsKey(curNode)){
        continue;
      }
      for (int[] neighborEdge : grph.get(curNode)) {
        int neighbor = neighborEdge[0];
        int wt = neighborEdge[1];
        if (timeStamp[neighbor] > minTimeStamp + wt) {
          timeStamp[neighbor] = minTimeStamp + wt;
        }
      }
    }

    //find the maximum timeStamp
    int maxTimeStamp = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (maxTimeStamp < timeStamp[i]) {
        maxTimeStamp = timeStamp[i];
      }
    }
    return maxTimeStamp;
  }

  private HashMap<Integer, List<int[]>> buildAdjList(int[][] times) {
    HashMap<Integer, List<int[]>> hashMap = new HashMap<>();
    for (int [] edge : times) {
      int src = edge[0] - 1;
      int dst = edge[1] - 1;
      int wt = edge[2];
      hashMap.putIfAbsent(src, new ArrayList<int[]>());
      List<int[]> neighborList = hashMap.get(src);
      neighborList.add(new int[] {dst, wt});
    }
    return hashMap;
  }

  public static void main(String args[]) {
    int [][] times = {{2,1,1},{2,3,1},{3,4,1}};
    NetworkDelayTime_743 ndltm = new NetworkDelayTime_743();
    HashMap h = ndltm.buildAdjList(times);
    int time = ndltm.networkDelayTime(times, 4, 4);
    return;
  }

  public int networkDelayTime_0714(int[][] times, int n, int src) {    
    //build adj graph
    List<List<int[]>> graph = new ArrayList<>();
    for(int i = 1; i < n + 1; i++) {
      graph.add(new ArrayList<>());
    }
    
    //times array holds [u_i, v_i, w_i]
    for(int[] edge : times) {
      int u = edge[0];
      graph.get(u).add(edge);
    }

    //(node, time_so_far)
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[]{src, 0});

    boolean[] visited = new boolean[n + 1];
    int processed = 0;
    int minTime = 0;
    while (!pq.isEmpty() && processed < n) {
      int[] cur = pq.poll();
      int u = cur[0];
      int w_u = cur[1];
      if(visited[u]) {
        continue;
      }
      for(int[] edge : graph.get(u)){
        int v = edge[1];
        int w_uv = edge[2]; 
        if(!visited[v]) {
          pq.offer(new int[]{v, w_u + w_uv});
        }
      }
      processed++;
      visited[u] = true;
      minTime = Math.max(minTime, w_u);
    }

    return processed == n ? minTime : -1;
  }

  public int networkDelayTime_drona(int[][] times, int n, int src) {    
    // Build adjacency list (using n + 1 size since nodes are 1-based)
    List<List<int[]>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
    }
    
    // Each entry in graph.get(u) is an array: {neighbor_node, weight}
    for (int[] edge : times) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        graph.get(u).add(new int[]{v, w});
    }

    // Min-heap tracking: {node, current_total_time}
    // Using Integer.compare to safely handle sorting without underflow/overflow risk
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    pq.add(new int[]{src, 0});

    boolean[] visited = new boolean[n + 1];
    int processed = 0;
    int minTime = 0;

    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int u = cur[0];
        int w_u = cur[1];
        
        // If node already visited, skip
        if (visited[u]) {
            continue;
        }
        
        // CRITICAL FIX: Mark node as visited upon settling it
        visited[u] = true;
        processed++;
        minTime = w_u; // The settled path values are guaranteed to be in non-decreasing order

        // If we have visited all n nodes, we can terminate early
        if (processed == n) {
            return minTime;
        }

        // Relax neighbors
        for (int[] edge : graph.get(u)) {
            int v = edge[0];
            int w_uv = edge[1]; 
            if (!visited[v]) {
                pq.offer(new int[]{v, w_u + w_uv});
            }
        }
    }

    return processed == n ? minTime : -1;
}
}
