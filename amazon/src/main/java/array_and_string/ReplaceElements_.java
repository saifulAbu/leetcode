package array_and_string;

public class ReplaceElements_ {
  public int[] replaceElements(int[] arr) {
    int max = -1;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] > max) {
        int t = arr[i];
        arr[i] = max;
        max = t;
      } else {
        arr[i] = max;
      }
    }
    return arr;
  }
}
