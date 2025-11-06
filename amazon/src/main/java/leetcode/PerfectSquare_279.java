package leetcode;

import java.util.*;

public class PerfectSquare_279 {

  /*
  * n = 6
  * squares less than 6
  * [1, 4]
  * optimum breakdown with squares
  * 1 + 1 + 4
  *
  * if we draw a tree     level
  *
  *        6                0
  *     1 / \ 4
  *      5    2             1
  *   1 / \ 4  \ 1
  *   4    1    1           2
  *
  * the problem can be seen as a bfs problem
  * source is 6
  * destination is one of the squares less than 6
  * as soon as we see a square number, we can return from there. for example, when processing the node 5 on level 1,
  * as soon as we see 4, when we choose the square number 1, we can return ((curlevel)1 + 1). as 4 belongs to level 2
  *
  * once we know how many bfs level it requires to reach a squareNumber from 6, we can finally return 2 + 1 = 3.
  * that will represent 3 squares, 1 + 1 + 4 = 6.
  * */

  private int getBFSLevelToFirstSquareNumFromSource(int n) {
    HashSet<Integer> squareNumSet = new HashSet<>();
    List<Integer> squareNumList = new LinkedList<>();
    HashSet<Integer> seenNums = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();

    //fill up squareNumSet
    for(int i = 1; i * i <= n; i++) {
      int curSqr = i * i;
      squareNumSet.add(curSqr);
      squareNumList.add(curSqr);
    }

    if(squareNumSet.contains(n)) {
      return 0;
    }

    int curLevel = 0;
    q.add(n);
    seenNums.add(n);
    while(!q.isEmpty()) {
      int curSize = q.size();
      for(int i = 0; i < curSize; i++) {
        int curNum = q.poll();
        for(int sqrNum : squareNumList) {
          if(sqrNum > curNum) {
            break;
          }
          int remainingNum = curNum - sqrNum;
          // as soon as we see a square number, we can return from there. for example, when processing the node 5 on level 1,
          // as soon as we see 4, when we choose the square number 1, we can return ((curlevel)1 + 1). as 4 belongs to level 2
          if(squareNumSet.contains(remainingNum)) {
            return curLevel + 1;
          }

          // we don't need to process a number we have put in the queue already. that number has been reached
          // earlier from current or previous level. this number can not be in shorter distance from origin than the previous
          if(seenNums.contains(remainingNum)) {
            continue;
          }

          q.offer(remainingNum);
        }
      } // all the numbers in cur level is processed
      curLevel++;
    }
    return curLevel;
  }

  public int numSquares(int n) {
    return getBFSLevelToFirstSquareNumFromSource(n) + 1;
  }

  //############## attempt 1
  HashMap<Integer, Integer> sqrCount = new HashMap<>();

  private boolean isPerfectSquare(int n) {
    int sqrt = (int) Math.floor(Math.sqrt(n));
    return sqrt * sqrt == n;
  }

  // n = 7
  // 7 can be formed the following ways
  // 1 + 6
  // 2 + 5
  // 3 + 4
  // then check for each combination, check how many squares you need for the breaks
  // sqrCount(3) + sqrCount(4)
  // check all the combination
  private int countMinSqr(int n) {
    if(isPerfectSquare(n)) {
      return 1;
    }
    int min = Integer.MAX_VALUE;
    for(int i = 1; i <= n / 2; i++) {
      int curSqrNum = sqrCount.get(i) + sqrCount.get(n-i);
      min = curSqrNum < min ? curSqrNum : min;
    }
    return min;
  }

  // main method
  // order is n * n
  public int numSquares1(int n) {
    if(isPerfectSquare(n)) {
      return 1;
    }

    for(int i = 0; i <= n; i++) {
      sqrCount.put(i, countMinSqr(i));
    }

    return sqrCount.get(n);
  }

  public int numSquares0(int n) {
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
