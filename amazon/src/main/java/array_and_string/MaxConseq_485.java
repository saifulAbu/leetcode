package array_and_string;

public class MaxConseq_485 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = Integer.MIN_VALUE;
    int curConseq = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        curConseq++;
        if (max < curConseq) {
          max = curConseq;
        }
      } else {
        curConseq = 0;
      }
    }
    return max;
  }
}
