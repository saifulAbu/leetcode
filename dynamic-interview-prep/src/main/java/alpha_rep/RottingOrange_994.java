package alpha_rep;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange_994 {
  public int orangesRotting(int[][] grid) {
    /*
    * t = 0
    * 2 1 0
    * 0 1 0
    * 1 1 1
    *
    * t = 1
    * 2 2 0
    * 0 1 0
    * 1 1 1
    *
    * t = 2
    * 2 2 0
    * 0 2 0
    * 1 1 1
    *
    * t = 3
    * 2 2 0
    * 0 2 0
    * 1 2 1
    *
    * t = 4
    * 2 2 0
    * 0 2 0
    * 2 2 2
    *
    * by t = 4 all the oranges gets rotten
    *
    * we will have a queue and put the rotten oranges there. from there we will continue rotting good oranges.
    * we will use bfs. will continue till queue is empty. once queue is empty, lets go and check if any oranges left
    * unrotten.
    * */

    int R = grid.length, C = grid[0].length;
    int goodCount = 0;
    Queue<int[]> queue = new LinkedList<>();
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        if(grid[r][c] == 2) {
          queue.add(new int[] {r, c});
        } else if(grid[r][c] == 1) {
          goodCount++;
        }
      }
    }

    if(goodCount == 0) {
      return 0;
    }

    if(queue.isEmpty() && goodCount > 0) {
      return -1;
    }


    int t;
    t = -1;
    // entering queue, this will make t value go 1 higher than what it's need to be
    while(!queue.isEmpty()) {
      int curQSize = queue.size();
      for(int i = 0; i < curQSize; i++) {
        int [] curRotten = queue.poll();
        int r = curRotten[0], c = curRotten[1];
        grid[r][c] = 2;
        //look up
        if(r - 1 >= 0 && grid[r-1][c] == 1) {
          grid[r-1][c] = 2;
          queue.add(new int[] {r-1, c});
        }
        //look down
        if(r + 1 < R && grid[r+1][c] == 1) {
          grid[r+1][c] = 2;
          queue.add(new int[] {r+1, c});
        }
        //look left
        if(c - 1 >= 0 && grid[r][c-1] == 1) {
          grid[r][c-1] = 2;
          queue.add(new int[] {r, c-1});
        }
        //look right
        if(c + 1 < C && grid[r][c+1] == 1) {
          grid[r][c+1] = 2;
          queue.add(new int[] {r, c+1});
        }
      }
      t++;
    }

    //check if any good oranges are left
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        if(grid[r][c] == 1) {
          return -1;
        }
      }
    }

    return t;
  }

  public int orangesRotting_0(int[][] grid) {
    int R = grid.length;
    int C = grid[0].length;

    Queue<int[]> q = new ArrayDeque<>();
    int goodOrangeCount = 0;
    //count number of oranges
    //add bad oranges to queue
    for (int r  = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (grid[r][c] == 1) {
          goodOrangeCount++;
        } else if (grid[r][c] == 2) {
          q.offer(new int[] {r, c});
        }
      }
    }
    if(goodOrangeCount == 0) return 0;

    int timeStamp = -1;
    int [][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int [] curBad = q.poll();
        int r = curBad[0];
        int c = curBad[1];
        for(int [] dir : dirs) {
          int nR = r + dir[0];
          int nC = c + dir[1];
          if (nR >=0 && nR < R && nC >= 0 && nC < C && grid[nR][nC] == 1) {
            grid[nR][nC] = 2;
            goodOrangeCount--;
            q.offer(new int[] {nR, nC});
          }
        }
      }
      timeStamp++;
    }

    return goodOrangeCount == 0? timeStamp : -1;
  }
}
