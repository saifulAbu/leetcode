package array_and_string;

public class TwoSumSorted_167 {
  public int[] twoSum(int[] numbers, int target) {
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

  public static void main(String args[]) {
    TwoSumSorted_167 sol = new TwoSumSorted_167();
    int[] arr = {-1, 0};
    int target = -1;
    System.out.println(sol.twoSum(arr, target));
  }
}
