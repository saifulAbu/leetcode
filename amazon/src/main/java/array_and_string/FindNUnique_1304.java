package array_and_string;

public class FindNUnique_1304 {
  public int[] sumZero(int n) {
    int [] res = new int[n];
    for(int i = 0; i < n / 2; i++) {
      res[i] = i + 1;
    }

    int val = -1;
    for(int i = (int) Math.ceil(n / 2.0); i < n; i++) {
      res[i] = val;
      val--;
    }

    return res;
  }
}
