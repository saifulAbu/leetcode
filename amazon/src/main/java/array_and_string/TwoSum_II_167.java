package array_and_string;

public class TwoSum_II_167 {
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
