package array_and_string;

public class RemoveDuplicatedSorted_26 {

  public int removeDuplicates_drona(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;

    int write = 1;  // slow pointer

    for (int read = 1; read < n; read++) {
      if (nums[read] != nums[read - 1]) {
        nums[write] = nums[read];
        write++;
      }
    }

    return write;
  }

  public int removeDuplicates_0(int[] nums) {
    int l = 0, r = 0;
    while(r < nums.length && r < nums.length) {
      while(nums[l] == nums[r]) {
        r++;
      }
      if(r == nums.length) {
        break;
      }
      nums[++l] = nums[r++];
    }
    return l + 1;
  }

  public int removeDuplicates1(int[] nums) {
    // let e represents the index where every element nums[e-1] is sorted and unique
    // let lastSortedUniqElem = nums[e-1]
    // let i represents the index where nums[i] is the element we are inspecting to insert to resulting array
    int e = 0;
    int lastSortedUniqElem = nums[0] - 1; // guarranteeing lastSortedUniqElem is smaller than any element of nums
    int i = 0;

    while(i < nums.length) {
      // move i forward until we find a uniq element
      while(i < nums.length && nums[i] == lastSortedUniqElem) {
        i++;
      }

      if(i < nums.length) {
        //uniq element found, move e pointer
        nums[e++] = nums[i];
        lastSortedUniqElem = nums[i++];
      }
    }

    return e; // return the size of the uniq elements array
  }

  public int removeDuplicates0(int[] nums) {
    if(nums.length <= 1) {
      return nums.length;
    }
    int size = 1;
    for (int nextUniqueElemIdx = 1; nextUniqueElemIdx < nums.length; nextUniqueElemIdx++) {
      if (nums[size - 1] != nums[nextUniqueElemIdx]) {
        nums[size++] = nums[nextUniqueElemIdx];
      }
    }
    return size;
  }
}
