package alpha_rep;

public class CoinChange_322 {
  public int coinChange(int[] coins, int amount) {
    /*
    * example: coins [1, 2], total amount 4
    *         4
    *       1/ \2
    *       3   2
    *     1/ \2
    *     2
    *   starting from 4, if we know the optimal solution for amount = 3, or amount = 2, we can find the optimal solution
    *   for 4. from amount 3, we will just add 1 coin of value 1, that will give amount 4.
    *   now looking down the recursion tree, see we will have to compute optimum coin for 2 several times. we can skip
    *   that using dynamic programming.
    *
    * pseudoCode:
    * minCoin = new int[amount+1];
    * minCoin[0] = 0;
    * for(curAmount = 1; curAmount <= amount; curAmount++) {
    *   curMin = 0;
    *   for(coin : coins) {
    *     if(curAmount - coin < 0) {
    *       continue;
    *     }
    *     curMin = min(curMin, minCoin[curAmount - coin] + 1);
    *   }
    *   minCoin[curAmount] = curMinCoin;
    * }
    * return minCoin[amount];
    *
    * */

    int[] minCoin = new int[amount + 1];
    minCoin[0] = 0;

    //we will compute bottom up optimum coin count for each val
    for(int curAmount = 1; curAmount <= amount; curAmount++) {
      int curMinCoin = Integer.MAX_VALUE;

      for(int coinVal : coins) {
        int prevMinIndex = curAmount - coinVal;
        if(prevMinIndex < 0) {
          continue;
        }
        int prevMinCoin = minCoin[prevMinIndex];
        if(prevMinCoin == Integer.MAX_VALUE) {
          continue;
        }
        curMinCoin = Math.min(curMinCoin, prevMinCoin + 1);
      }

      minCoin[curAmount] = curMinCoin;
    }

    return (minCoin[amount] == Integer.MAX_VALUE ? -1 : minCoin[amount]);
  }
}
