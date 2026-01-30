package alpha_rep;

public class NumSubArray_1343 {

  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int curSum = 0;
    int subArr = 0;
    int target = k * threshold;

    //count initial sum
    for(int i = 0; i < k; i++) {
      curSum += arr[i];
    }

    if(curSum >= target) {
      subArr++;
      System.out.println("curSum: " + curSum + " subArr: " + subArr);
    }

    for(int addIndex = k, subTractIndex = 0; addIndex < arr.length; addIndex++, subTractIndex++) {
      curSum = curSum + arr[addIndex] - arr[subTractIndex];

      if(curSum >= target) {
        subArr++;
        System.out.println("curSum: " + curSum + " subArr: " + subArr);
      }
    }

    return subArr;
  }
}
