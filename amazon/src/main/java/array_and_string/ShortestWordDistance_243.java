package array_and_string;

public class ShortestWordDistance_243 {
  public int shortestDistance(String[] wordsDict, String word0, String word1) {
    int w0 = wordsDict.length, w1 = wordsDict.length, min = Integer.MAX_VALUE;

    for (int i = 0; i < wordsDict.length; i++) {
      String cur = wordsDict[i];
      if (word0.equals(cur)) {
        w0 = i;
        min = Math.min(Math.abs(w1 - w0), min);
      } else if (word1.equals(cur)) {
        w1 = i;
        min = Math.min(Math.abs(w1 - w0), min);
      }
    }
    return min;
  }
}
