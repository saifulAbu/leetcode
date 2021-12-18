package array_and_string;

public class TwoSum_II_167 {
  public int[] twoSum(int[] numbers, int target) {
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
