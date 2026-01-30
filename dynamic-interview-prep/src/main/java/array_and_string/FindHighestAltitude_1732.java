package array_and_string;

public class FindHighestAltitude_1732 {
  public int largestAltitude(int[] gain) {
    int maxAlt = 0;
    int curSum = 0;
    for (int i = 0; i < gain.length; i++) {
      curSum += gain[i];
      if (curSum > maxAlt) {
        maxAlt = curSum;
      }
    }
    return maxAlt;
  }
}
