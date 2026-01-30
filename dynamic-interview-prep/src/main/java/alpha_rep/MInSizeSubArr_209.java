package alpha_rep;

import java.util.Arrays;

public class MInSizeSubArr_209 {

  public int minSubArrayLen(int target, int[] nums) {
    /*
     * 2 2 2 50 target 7
     * we will use 2 pointers. l and r. we will sum the elements on the array starting from l to r-1.
     * initially l = 0, r = 0. so initial sum we take elements from startIndex = 0, endIndex = 0-1 = -1. so no elements.
     * when l = 0, r = 2, this means, we are considering indices 0, 1.
     * windowLen = r - l;
     * */

    int l = 0, r = 0, minLen = Integer.MAX_VALUE, curSum = 0, N = nums.length;

    while(l < N && l <= r) {
      //curSum is less so we will attempt to forward r and take one more element in the curSum
      if(curSum < target) {
        if(r == N) {
          break;
        }
        curSum += nums[r++];
      } else {
        minLen = Integer.min(minLen, r - l);
        curSum -= nums[l++];
      }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }

  public int minSubArrayLen1(int target, int[] nums) {
    int l = 0, h = 0;
    int minWindow = Integer.MAX_VALUE, curSum = 0;
    while(l <= h) {
      int curWindowLen = Integer.MAX_VALUE;
      if(curSum < target) {
        if(h >= nums.length) {
          break;
        }
        curSum += nums[h];
        h++;
        if(curSum >= target) {
          curWindowLen = h - l;
        }
      } else {
        curSum -= nums[l];
        l++;
        if(curSum >= target) {
          curWindowLen = h - l;
        }
      }
      minWindow = minWindow > curWindowLen ? curWindowLen : minWindow;
    }

    return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
  }

  public int minSubArrayLen0(int target, int[] nums) {
   int minLen = Integer.MAX_VALUE;
   int curSum = 0;
   int l = 0;
   for (int i = 0; i < nums.length; i++) {
     curSum += nums[i];
     while (curSum >= target) {
       minLen = Math.min(minLen, i + 1 - l);
       curSum -= nums[l];
     }
   }
   return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
