package array_and_string;

public class MaxConseq_487 {
  public int findMaxConsecutiveOnes(int[] nums) {
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
    //calculate the last seen zero, imaginve there is a zero on arr.length position
    int resultForLastZero = nums.length - prevZeroIndex - 1;
    if (resultForLastZero > maxConseqZero) {
      maxConseqZero = resultForLastZero;
    }
    return maxConseqZero;
  }
}
