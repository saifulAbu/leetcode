//package trees_and_graphs;
//
//import javafx.util.Pair;
//import java.util.HashMap;
//
///* The knows API is defined in the parent class Relation.
//      boolean knows(int a, int b); */
//
//class FindCeleberity_277 {
//  HashMap<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
//
//  boolean knows(int a, int b) {
//    return false;
//  }
//
//  public int findCelebrity(int n) {
//    int cand = getCandidate(n);
//    return isCelebrity(cand, n) ? cand : -1;
//  }
//
//  private int getCandidate(int n) {
//    int curCand = 0;
//    for(int i = 1; i < n; i++) {
//      if(cachedKnows(curCand, i)) {
//        curCand = i;
//      }
//    }
//    return curCand;
//  }
//
//  private boolean cachedKnows(int a, int b) {
//    Pair<Integer, Integer> pair = new Pair<>(a, b);
//    if(!cache.containsKey(pair)) {
//      cache.put(pair, knows(a, b));
//    }
//    return cache.get(pair);
//  }
//
//  private boolean isCelebrity(int c, int n) {
//    for(int i = 0; i < n; i++) {
//      if(i == c) {
//        continue;
//      }
//      if(cachedKnows(c, i) || !cachedKnows(i, c)) {
//        return false;
//      }
//    }
//    return true;
//  }
//}