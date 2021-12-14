package dynamic_programing;

public class BestTimeToStock_121 {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for(int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else {
        maxProfit = Integer.max(maxProfit, price - minPrice);
      }
    }
    return maxProfit;
  }
}
