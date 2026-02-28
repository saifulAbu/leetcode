package alpha_rep;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum_560 {

  public int subarraySum_bruteforce_n_2(int[] nums, int k) {
    /*
    * this is the foundation of O(n) solution
    * please look through the for loop below
    * */
    int n = nums.length;
    int [] prefixSum = new int[n+1];

    for(int i = 0; i < nums.length; i++) {
      prefixSum[i+1] = nums[i] + prefixSum[i];
    }

    int count = 0;
    for(int i = 1; i < n + 1; i++) {
      for(int j = 0; j < i; j++) {
        // 0 1 2 3
        // 1 2 3 4
        // 0 1 3 6 10 prefix sum
        // we want to know what is the sum in the range of (1,3), that is 9, prefixSum[3] - prefixSum[1] = 10 - 1 =9
        // prefixSum[i] = prefixSum[j] + rangeSum(i, j)
        if(prefixSum[i] - prefixSum[j] == k) {
          count++;
        }
        /*
        * now the above condition can be written as follows,
        * prefixSumNeed = prefixSum[i] - k;
        * then we can just check if any prefixSum[j] == prefixSumNeeded
        * now because we just are looking for a prefixSum[j] that has value prefixSumNeeded, we can just use a hashmap!
        * we don't event have to use the array prefixSum! improvement is below
        * */
      }
    }
    return count;
  }

  public int subarraySum_drona(int[] nums, int k) {
    /*
     * please read through the version subarraySum_bruteforce_n_2 to understand how we came up with the following solution
     * */

    HashMap<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);

    int curSum = 0;
    int totalCount = 0;

    for (int num : nums) {
      curSum += num;

      int need = curSum - k;
      if (prefixCount.containsKey(need)) {
        totalCount += prefixCount.get(need);
      }

      prefixCount.put(curSum, prefixCount.getOrDefault(curSum, 0) + 1);
    }

    return totalCount;
  }


  public int subarraySum_bruteforce_n2(int[] nums, int k) {
    int n = nums.length;
    int count = 0;

    for (int start = 0; start < n; start++) {
      int sum = 0;
      for (int end = start; end < n; end++) {
        sum += nums[end];
        if (sum == k) {
          count++;
        }
      }
    }

    return count;
  }

  public int subarraySum_bruteforce_o_n_3(int[] nums, int k) {
    int n = nums.length;
    int count = 0;

    for (int start = 0; start < n; start++) {
      for (int end = start; end < n; end++) {
        int sum = computeRangeSum(nums, start, end);
        if (sum == k) {
          count++;
        }
      }
    }

    return count;
  }

  private int computeRangeSum(int[] nums, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += nums[i];
    }
    return sum;
  }


  public int subarraySum_0(int[] nums, int k) {
    int totalCount = 0;
    for(int s = 0; s < nums.length; s++) {
      int curSum = 0;
      for(int e = s; e < nums.length; e++) {
        curSum += nums[e];
        if(curSum == k) {
          totalCount++;
        }
      }
    }
    return totalCount;
  }
}
