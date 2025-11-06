package array_and_string;

import java.util.Arrays;

public class MInSizeSubArr_209 {

  public int minSubArrayLen(int target, int[] nums) {
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
