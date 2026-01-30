package array_and_string;

public class TwoSumSorted_167 {

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
    int l = 0, r = numbers.length - 1;

    while(l < r) {
      int curSum = numbers[l] + numbers[r];
      if(curSum > target) {
        r--;
      } else if (curSum < target) {
        l++;
      } else {
        break;
      }
    }

    return new int[] {l+1, r+1};
  }

  public int[] twoSum_0(int[] numbers, int target) {
    int [] res = new int[2];
    int head = 0;
    int tail = numbers.length - 1;

    while(head < tail) {
      int curSum = numbers[head] + numbers[tail];
      if(curSum == target) {
        res[0] = head + 1;
        res[1] = tail + 1;
        break;
      } else if (curSum < target) {
        head++;
      } else {
        tail--;
      }
    }
    return res;
  }
}
