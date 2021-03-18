package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> res = new ArrayList<>();
    int maxCandy = 0;
    for(int candy : candies) {
      if(candy > maxCandy) {
        maxCandy = candy;
      }
    }
    for(int candy : candies) {
      if(candy + extraCandies >= maxCandy) {
        res.add(true);
      } else {
        res.add(false);
      }
    }
    return res;
  }
}
