package array_and_string;

public class MinDeciBinaryString_1689 {
  public int minPartitions(String n) {
    int max = 0;

    for (char ch : n.toCharArray()) {
      int d = ch - '0';
      if (max < d) {
        max = d;
      }
      if (d == 9) {
        break;
      }
    }

    return max;
  }
}
