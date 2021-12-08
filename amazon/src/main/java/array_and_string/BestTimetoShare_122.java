package array_and_string;

public class BestTimetoShare_122 {
  public int maxProfit(int[] prices) {
    int buyIndex = 0;
    int profit = 0;
    while (buyIndex < prices.length - 1) {
      while(buyIndex < prices.length - 1 && prices[buyIndex] > prices[buyIndex+1]) {
        buyIndex++;
      }
      if(buyIndex == prices.length - 1) {
        break;
      }
      int sellIndex = buyIndex + 1;
      while (sellIndex < prices.length - 1 && prices[sellIndex] < prices[sellIndex + 1]) {
        sellIndex++;
      }
      if(sellIndex == prices.length) {
        break;
      }
      profit += prices[sellIndex] - prices[buyIndex];
      buyIndex = sellIndex + 1;
    }
    return profit;
  }
}
