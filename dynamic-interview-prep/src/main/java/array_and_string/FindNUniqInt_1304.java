package array_and_string;

public class FindNUniqInt_1304 {
  public int[] sumZero(int n) {
    int[] res = new int[n];
    int i = 0;
    if (n % 2 != 0) {
      res[0] = 0;
      i++;
    }
    while (i < n) {
      res[i] = i;
      res[i+1] = -i;
      i += 2;
    }
    return res;
  }
}
