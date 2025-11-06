package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
}
