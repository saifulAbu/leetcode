package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class PathWithMinEffort_1631 {
  int R, C;
  int[] rc = new int[2];
  int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  Set<Integer> inQ = new HashSet<>();

  void initCost(int[][] cost) {
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        cost[r][c] = Integer.MAX_VALUE;
      }
    }
  }

  public int minimumEffortPath(int[][] heights) {
    R = heights.length;
    C = heights[0].length;
    int[][] cost = new int[R][C];
    initCost(cost);
    Deque<Integer> q = new ArrayDeque<>();
    cost[0][0] = 0;
    q.offer(0);
    while(!q.isEmpty()) {
      int curId = q.poll();
      System.out.println("cur id " + curId);
      if(curId == 5) {
        System.out.println("cur id 5");
      }
      getRC(curId);
      int curR = rc[0];
      int curC = rc[1];
      markOutOfQueue(curId);
      for(int[] dir : DIR) {
        int nR, nC;
        nR = curR + dir[0];
        nC = curC + dir[1];
        if(!isValid(nR, nC)) {
          continue;
        }
        int nId = getId(nR, nC);
        int neighborCost = Math.max(Math.abs(heights[curR][curC] - heights[nR][nC]), cost[curR][curC]);
        if(neighborCost < cost[nR][nC]) {
          if(!isInQ(nId)) {
            q.offer(nId);
            markInQueue(nId);
          }
          cost[nR][nC] = neighborCost;
        }
      }
    }
    return cost[R-1][C-1];
  }

  boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }

  int getId(int r, int c) {
    return r * C + c;
  }

  void getRC(int id) {
    rc[0] = id / C;
    rc[1] = id - rc[0] * C;
  }

  void markInQueue(int id) {
    inQ.add(id);
  }

  void markOutOfQueue(int id) {
    inQ.remove(id);
  }

  boolean isInQ(int id) {
    return inQ.contains(id);
  }

  public static void main(String args[]) {
    int [][] trail = {{5,5,9,2}, {9,7,5,6}};
    PathWithMinEffort_1631 ptw = new PathWithMinEffort_1631();
    System.out.println(ptw.minimumEffortPath(trail));
  }

}

/*
fails for [[5,5,9,2],[9,7,5,6]]

* */