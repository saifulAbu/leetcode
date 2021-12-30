package trees_and_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquare_279 {

  public int numSquares(int n) {
    List<Integer> sqrs = new LinkedList<>();
    HashSet<Integer> sqrsSet = new HashSet<>();
    HashSet<Integer> seen = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();

    //form squares
    for (int i = 0; i * i <= n; i++) {
      int sq = i * i;
      sqrs.add(sq);
      sqrsSet.add(sq);
    }

    q.offer(n);
    seen.add(n);
    int count = 0;
    while (!q.isEmpty()) {
      count++;
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int curVal = q.poll();
        if (sqrsSet.contains(curVal)) {
          return count;
        }
        for(int sqr : sqrs) {
          if (sqr > curVal) {
            break;
          }
          int remainder = curVal - sqr;
          if (!seen.contains(remainder)) {
            if(sqrsSet.contains(remainder)) {
              return count + 1;
            }
            q.offer(remainder);
          }
        }
      }
    }
    return count;
  }
}
