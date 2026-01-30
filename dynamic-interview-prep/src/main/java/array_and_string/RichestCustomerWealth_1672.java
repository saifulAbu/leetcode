package array_and_string;

public class RichestCustomerWealth_1672 {
  public int maximumWealth(int[][] accounts) {
    int maxWealth = 0;
    int MAX_ROW = accounts.length;
    int MAX_COL = accounts[0].length;

    for(int r = 0; r < MAX_ROW; r++) {
      int curSum = 0;
      for(int c = 0; c < MAX_COL; c++) {
        curSum += accounts[r][c];
      }
      if(curSum > maxWealth) {
        maxWealth = curSum;
      }
    }

    return maxWealth;
  }
}
