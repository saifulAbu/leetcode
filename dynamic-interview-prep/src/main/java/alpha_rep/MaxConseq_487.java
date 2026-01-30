package alpha_rep;

public class MaxConseq_487 {

  public int findMaxConsecutiveOnes(int[] nums) {
    /*
    * example case
    * 1 1 1 0 1 1 1
    * first calculate 1s on left side, this is just once. from hence forth, we will only calculate 1s on the right
    * for each 0.
    * once encountered a 0, calculate 1s on the right side
    * total 1 = left + right + 1
    *
    * if another 0 is encountered
    * 1 1 1 0 1 1 1 0 1 1 1 1
    * left = right, right = 0
    * calculate 1s on the right side.
    * */

    //count initial 1s on the left side to begin with
    int left = 0;
    int i = 0;
    while(i < nums.length && nums[i] == 1) {
      left++;
      i++;
    }

    //case where all the digits are 1s, no flipping of digits needed
    if(left == nums.length) {
      return nums.length;
    }

    int max = 0;
    int right = 0;
    // i = i + 1 because we want to skip the zero. want to count the number of 1s on the rightside
    for(i = i + 1; i < nums.length; i++) {
      if(nums[i] == 1) {
        right++;
      } else {
        max = Math.max(max, left + right + 1);
        left = right;
        right = 0;
      }
    }

    //it can happen we have not processed a the string len
    // 1 1 1 0 1 1 1
    return Math.max(max, left + right + 1);
  }

  public int findMaxConsecutiveOnes_0(int[] nums) {
    //thinking there is a zero on -1 index and nums.length index
    //number of consecutiveOnes would be nextZeroIndex - prevZeroIndex - 1
    int prevZeroIndex = -1;
    int curZeroIndex = -1;
    int maxConseqZero = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        //first time seeing zero
        if (curZeroIndex == -1) {
          curZeroIndex = i;
        } else {
          int curConseqzeros = i - prevZeroIndex - 1;
          if (curConseqzeros > maxConseqZero) {
            maxConseqZero = curConseqzeros;
          }
          prevZeroIndex = curZeroIndex;
          curZeroIndex = i;
        }
      }
    }
    //calculate the last seen zero, imagine there is a zero on arr.length position
    int resultForLastZero = nums.length - prevZeroIndex - 1;
    if (resultForLastZero > maxConseqZero) {
      maxConseqZero = resultForLastZero;
    }
    return maxConseqZero;
  }
}
