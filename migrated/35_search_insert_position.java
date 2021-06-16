package com.company;

public class SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int resIndex = 0;
    int inputSize = nums.length;
    if(nums[0] > target) {
      return 0;
    }
    if(nums[inputSize-1] < target) {
      return inputSize;
    }

    int start = 0;
    int end = inputSize - 1;
    int mid;

    while(start <= end) {
      mid = (start + end) / 2;
      if(nums[mid] == target) {
        resIndex = mid;
        break;
      } else if(nums[mid] > target) {
        resIndex = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return resIndex;
  }

  public static void main(String args[]) {
    SearchInsertPosition res = new SearchInsertPosition();
    System.out.println("result index " + res.searchInsert(new int[]{1, 3}, 2));
  }
}
