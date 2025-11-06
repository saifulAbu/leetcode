package array_and_string;

public class SortArrayParity_905 {
  public int[] sortArrayByParity(int[] arr) {
    int evenPtr = 0, oddPtr = arr.length - 1;

    while(evenPtr < oddPtr) {
      while(evenPtr < arr.length && arr[evenPtr] % 2 == 0) {
        evenPtr++;
      }

      while(oddPtr >= 0 && arr[oddPtr] % 2 != 0) {
        oddPtr--;
      }

      if(evenPtr < oddPtr) {
        int temp = arr[evenPtr];
        arr[evenPtr++] = arr[oddPtr];
        arr[oddPtr--] = temp;
      }
    }
    return arr;
  }

  public int[] sortArrayByParity1(int[] nums) {
    int nextEven = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        int t = nums[i];
        nums[i] = nums[nextEven];
        nums[nextEven++] = t;
      }
    }
    return nums;
  }

  public int[] sortArrayByParity0(int[] nums) {
    int front = 0;
    int len = nums.length - 1;
    int back = len;
    while (front < len && back >= 0 && front < back) {
      while (front < len && front < back && nums[front] % 2 == 0) {
        front++;
      }

      while (back >= 0 && front < back &&  nums[back] % 2 != 0) {
        back--;
      }

      if (front < len && back >= 0 && nums[front] % 2 != 0 && nums[back] % 2 == 0) {
        int t = nums[front];
        nums[front] = nums[back];
        nums[back] = t;
      }
    }
    return nums;
  }
}
