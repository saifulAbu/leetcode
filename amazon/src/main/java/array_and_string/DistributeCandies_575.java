package array_and_string;

import java.util.HashSet;

public class DistributeCandies_575 {
  public int distributeCandies(int[] candyType) {
    HashSet<Integer> type = new HashSet<>();
    for (int candy : candyType) {
      type.add(candy);
    }
    return Math.min(type.size(), candyType.length / 2);
  }
}
