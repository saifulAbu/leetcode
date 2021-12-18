package array_and_string;

public class MInSizeSubArr_209 {
  public int minSubArrayLen(int target, int[] nums) {
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
