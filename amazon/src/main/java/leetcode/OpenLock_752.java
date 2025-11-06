package leetcode;

import java.util.*;

public class OpenLock_752 {
  Set<Combination> visited = new HashSet<>();
  Set<Combination> deadEnds = new HashSet<>();

  private void initializeDeadEnd(String[] deadEndArr) {
    for(String deadEnd : deadEndArr) {
      deadEnds.add(new Combination(deadEnd));
    }
  }

  public int openLock(String[] ddEnds, String trgt) {
    initializeDeadEnd(ddEnds);

    // check base conditions
    Combination target = new Combination(trgt), initial = new Combination("0000");

    // can't go anywhere if initial is in deadend.
    if(deadEnds.contains(target) || deadEnds.contains(initial)) {
      return -1;
    }
    if(target.equals(initial)) {
      return 0;
    }

    // call bfs
    Combination bfsTarget = runBFSToFindTarget(initial, target);
    if(bfsTarget == null) {
      return -1;
    }

    // count steps now
    return countStep(bfsTarget);
  }

  private Combination runBFSToFindTarget(Combination initial, Combination target) {
    Combination bfsTarget = null;
    Queue<Combination> q = new LinkedList<>();
    q.add(initial);
    visited.add(initial);

    while(!q.isEmpty() && (bfsTarget == null)) {
      Combination curCombination = q.poll();
      for(Combination nextCombination : curCombination.getNextCombinations()) {
        if(deadEnds.contains(nextCombination) || visited.contains(nextCombination)) {
          continue;
        }

        if(nextCombination.equals(target)) {
          bfsTarget = nextCombination;
          break;
        }

        visited.add(nextCombination);
        q.add(nextCombination);
      }
    }

    return bfsTarget;
  }

  // pass in the target combination found from running bfs
  // returns how many steps it requires to reach initial combination from target
  // "0011" -> "0001" -> "0000" -> null
  // there are 3 hops to reach null from target
  // nead to return 3 -1 = 2 to show number of combinations to reach initial
  private int countStep(Combination bfsTarget) {
    int hopCount = 0;
    Combination cur = bfsTarget;

    while(cur != null) {
      cur = cur.prev;
      hopCount++;
    }

    return hopCount-1;
  }


  class Combination {
    int [] digit;
    int NUM_DIGIT = 4;
    Combination prev = null;

    Combination(String combStr) {
      digit = new int[4];
      for(int i = 0; i < NUM_DIGIT; i++) {
        digit[i] = combStr.charAt(i) - '0';
      }
    }

    Combination (int [] digit) {
      this.digit = digit;
    }

    Combination setPrev(Combination prev) {
      this.prev = prev;
      return this;
    }

    // example scenario: this.digit[] = [0, 1, 2, 3]
    // caller will provide an index and how much they want that index to increment
    // increment value will be +1 or -1
    // if caller calls this function with 3, -1
    // a new combination will be generated with digit[] = [0, 1, 2, 2]
    Combination nextCombination(int index, int increment) {
      int[] nextDigit = new int[NUM_DIGIT];
      for(int i = 0; i < NUM_DIGIT; i++) {
        nextDigit[i] = this.digit[i];
      }
      nextDigit[index] = (this.digit[index] + increment + 10) % 10;
      return new Combination(nextDigit);
    }

    boolean equals(Combination that) {
      for(int i = 0; i < NUM_DIGIT; i++) {
        if(this.digit[i] != that.digit[i]) {
          return false;
        }
      }
      return true;
    }

    boolean equals(String combStr) {
      return equals(new Combination(combStr));
    }

    @Override
    public final boolean equals(Object that) {
      if(that instanceof String) {
        return equals((String) that);
      } else if (that instanceof Combination) {
        return equals((Combination) that);
      }
      return false;
    }

    @Override
    public final int hashCode() {
      int hashVal = 0;

      for(int i = 0; i < NUM_DIGIT; i++) {
        hashVal = hashVal * 10 + digit[i];
      }

      return hashVal;
    }

    List<Combination> getNextCombinations() {
      List<Combination> nextCombs = new LinkedList<>();
      for(int i = 0; i < NUM_DIGIT; i++) {
        nextCombs.add(nextCombination(i, +1).setPrev(this));
        nextCombs.add(nextCombination(i, -1).setPrev(this));
      }
      return nextCombs;
    }
  }
}

class OpenLock_0_752 {
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