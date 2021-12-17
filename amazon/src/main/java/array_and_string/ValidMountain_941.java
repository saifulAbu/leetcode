package array_and_string;

public class ValidMountain_941 {
  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }
    int i = 1;
    while (i < arr.length && arr[i-1] < arr[i]) {
      i++;
    }
    if (i == 1 || i == arr.length) {
      return false;
    }
    while (i < arr.length && arr[i-1] > arr[i]) {
      i++;
    }
    if (i != arr.length) {
      return false;
    }
    return true;
  }
}
