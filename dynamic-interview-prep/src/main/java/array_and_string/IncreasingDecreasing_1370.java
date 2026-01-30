package array_and_string;

public class IncreasingDecreasing_1370 {
  public String sortString(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    int [] count = new int[26];

    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }
    int len = 0;
    while (len < s.length()) {
      //forward
      for (int i = 0; i < count.length; i++) {
        if (count[i] > 0) {
          count[i]--;
          char ch = (char) ('a' + i);
          stringBuilder.append(ch);
          len++;
        }
      }
      //backward
      for (int i = count.length - 1; i >= 0; i--) {
        if (count[i] > 0) {
          count[i]--;
          char ch = (char) ('a' + i);
          stringBuilder.append(ch);
          len++;
        }
      }
    }

    return stringBuilder.toString();
  }

  public static void main(String args[]) {
    IncreasingDecreasing_1370 incr = new IncreasingDecreasing_1370();
    System.out.println(incr.sortString("leetcode"));
  }
}
