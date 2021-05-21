package array_and_string;

public class TruncateSentence_1816 {
  public String truncateSentence(String s, int k) {
    int spaceCount = 0;
    //find i of  k th space
    int i = 0;
    for(; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        spaceCount++;
      }
      if (spaceCount == k) {
        break;
      }
    }
    return s.substring(0, i);
    //return substring of (0, i)
  }
}
