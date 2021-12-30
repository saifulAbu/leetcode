package trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class OpenLock_752 {
  int[][][][] space = new int[10][10][10][10];
  int UNSEEN = 0;
  int SEEN = 1;
  int FORBIDDEN = -1;
  public int openLock(String[] deadends, String target) {
    for (String deadend : deadends) {
      int a0 = deadend.charAt(0) - '0';
      int a1 = deadend.charAt(1) - '0';
      int a2 = deadend.charAt(2) - '0';
      int a3 = deadend.charAt(3) - '0';
      space[a0][a1][a2][a3] = FORBIDDEN;
    }

    //set target
    int t0 = target.charAt(0) - '0';
    int t1 = target.charAt(1) - '0';
    int t2 = target.charAt(2) - '0';
    int t3 = target.charAt(3) - '0';

    if(space[0][0][0][0] == FORBIDDEN || space[t0][t1][t2][t3] == FORBIDDEN) {
      return -1;
    }


    //set initial combination to seen
    space[0][0][0][0] = SEEN;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {0, 0, 0, 0});
    int level = 0;
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int[] curComb = q.poll();
        int p0 = curComb[0];
        int p1 = curComb[1];
        int p2 = curComb[2];
        int p3 = curComb[3];

        //found target
        if (p0 == t0 && p1 == t1 && p2 == t2 && p3 == t3) {
          return level;
        }

        int n = (p0 + 1) % 10;
        if (space[n][p1][p2][p3] == UNSEEN) {
          q.offer(new int[] {n, p1, p2, p3});
          space[n][p1][p2][p3] = SEEN;
        }
        n = (p0 - 1 + 10) % 10;
        if (space[n][p1][p2][p3] == UNSEEN) {
          q.offer(new int[] {n, p1, p2, p3});
          space[n][p1][p2][p3] = SEEN;
        }

        n = (p1 + 1 + 10) % 10;
        if (space[p0][n][p2][p3] == UNSEEN) {
          q.offer(new int[] {p0, n, p2, p3});
          space[p0][n][p2][p3] = SEEN;
        }
        n = (p1 - 1 + 10) % 10;
        if (space[p0][n][p2][p3] == UNSEEN) {
          q.offer(new int[] {p0, n, p2, p3});
          space[p0][n][p2][p3] = SEEN;
        }

        n = (p2 + 1 + 10) % 10;
        if (space[p0][p1][n][p3] == UNSEEN) {
          q.offer(new int[] {p0, p1, n, p3});
          space[p0][p1][n][p3] = SEEN;
        }
        n = (p2 - 1 + 10) % 10;
        if (space[p0][p1][n][p3] == UNSEEN) {
          q.offer(new int[] {p0, p1, n, p3});
          space[p0][p1][n][p3] = SEEN;
        }

        n = (p3 + 1 + 10) % 10;
        if (space[p0][p1][p2][n] == UNSEEN) {
          q.offer(new int[] {p0, p1, p2, n});
          space[p0][p1][p2][n] = SEEN;
        }
        n = (p3 - 1 + 10) % 10;
        if (space[p0][p1][p2][n] == UNSEEN) {
          q.offer(new int[] {p0, p1, p2, n});
          space[p0][p1][p2][n] = SEEN;
        }
      }
      level++;
    }
    return -1;
  }
}