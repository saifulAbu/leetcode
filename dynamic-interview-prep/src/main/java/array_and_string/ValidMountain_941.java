package array_and_string;

public class ValidMountain_941 {
  public boolean validMountainArray(int[] arr) {
    // array less than length 3 are not mountain arrays
    if(arr.length < 3) {
      return false;
    }

    // an decreasing array will not be a mountain array
    if(arr[0] > arr[1]) {
      return false;
    }

    boolean isIncreasing = true;
    for(int i = 1; i < arr.length; i++) {
      if(arr[i-1] == arr[i]) {
        return false;
      }

      if(isIncreasing) {
        if(arr[i-1] > arr[i]) {
          isIncreasing = false;
        }
      } else {
        if(arr[i-1] < arr[i]) {
          return false;
        }
      }
    }

    // when the loop ends, for a valid mountain array, isIncreasing should be false.
    // if it is still true, that will say the array is an increasing array and thus not a valid mountain array
    return !isIncreasing;
  }

  public boolean validMountainArray0(int[] arr) {
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
