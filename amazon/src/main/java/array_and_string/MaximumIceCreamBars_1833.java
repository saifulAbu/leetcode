package array_and_string;

import java.util.Arrays;

public class MaximumIceCreamBars_1833 {
  public int maxIceCream(int[] costs, int coins) {
    int bars = 0;
    int remCoin = coins;
    Arrays.sort(costs);

    for (int i = 0; i < costs.length; i++) {
      if (remCoin >= costs[i]) {
        remCoin -= costs[i];
        bars++;
      } else {
        break;
      }
    }
    return bars;
  }
}
