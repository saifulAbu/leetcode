package alpha_rep;

public class TwoSum_II_167 {

  public int[] twoSum_bruteforce(int[] numbers, int target) {
    int n = numbers.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (numbers[i] + numbers[j] == target) {
          return new int[] { i + 1, j + 1 };  // 1-indexed
        }
      }
    }

    return null;
  }

  public int[] twoSum_canonical(int[] numbers, int target) {
    int n = numbers.length;
    int left = 0, right = n - 1;
    while(left < right) {
      int curSum = numbers[left] + numbers[right];
      if(curSum > target) {
        right--;
      } else if(curSum < target) {
        left++;
      } else {
        return new int[] {left+1, right + 1};
      }
    }
    return null;
  }


  public int[] twoSum(int[] numbers, int target) {
    // array sorted in increasing order
    // there is guarranted one unique solution
    // use to pointers l and r
    // take sum of numbers[l] + numbers[r]
    // if the sum is more than target, we want to reduce it.
    // we do so by r--, because array is sorted, numbers[r-] < numbers[r]
    // if sum is less than target, we increase it by taking the numbers[l+1]
    int l = 0, r = numbers.length - 1;
    while(l < r) {
      int curSum = numbers[l] + numbers[r];
      if(curSum == target) {
        break;
      } else if(curSum > target) {
        r--;
      } else {
        l++;
      }
    }
    return new int[] {l+1, r+1};
  }

  public int[] twoSum_1(int[] numbers, int target) {
    int b = 0, f = numbers.length - 1;
    while(b < f) {
      int curSum = numbers[b] + numbers[f];
      if(curSum > target) {
        f--;
      } else if(curSum < target) {
        b++;
      } else {
        break;
      }
    }
    return new int[] {b+1, f+1};
  }





























  public int[] twoSum0(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      if (numbers[low] + numbers[high] > target) {
        high--;
      } else if (numbers[low] + numbers[high] < target){
        low++;
      } else {
        break;
      }
    }
    return new int[] {low+1, high + 1};
  }
}
