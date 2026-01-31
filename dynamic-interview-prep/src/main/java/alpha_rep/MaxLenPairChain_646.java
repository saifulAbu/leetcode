package alpha_rep;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenPairChain_646 {
  public int findLongestChain(int[][] pairs) {
  /*
   * we sort the intervals based on the end time.
   * as we move on, if we find a conflicting interval, we remove the one that is ending later.
   * [[0, 5], [1, 6], [2, 7], [5, 8]]
   *
   * curEnd = -infinity
   * we check curEnd with [0,5] and update curEnd = 5;
   * then we check [1, 6] with curEnd = 5, because 5 > 1, we would remove this interval
   *  we count the number of intervals we are keeping, that would be the answer
   */

    Arrays.sort(pairs, new Comparator<int[]>() {
      @Override
      public int compare(int[] p0, int[] p1) {
        return p0[1] - p1[1];
      }
    });

    int curMinEnd = Integer.MIN_VALUE;
    int chainLen = 0;

    for(int[] pair : pairs) {
      if(curMinEnd < pair[0]) {
        chainLen++;
        curMinEnd = pair[1];
      }
    }

    return chainLen;
  }
}
