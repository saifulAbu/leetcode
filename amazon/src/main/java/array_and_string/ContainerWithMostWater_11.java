package array_and_string;

public class ContainerWithMostWater_11 {
  public int maxArea(int[] height) {
    int start = 0;
    int end = height.length - 1;
    int maxWater = 0;
    while(start < end) {
      int curwater = Math.min(height[start], height[end]) * (end - start);
      if(curwater > maxWater) {
        maxWater = curwater;
      }
      //move the smaller pointer
      if(height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }

    return maxWater;
  }

  public static void main(String args[]) {
    ContainerWithMostWater_11 sol = new ContainerWithMostWater_11();
    //int[] bucket = {1,8,6,2,5,4,8,3,7};
    int[] bucket = {1, 2};
    System.out.println(sol.maxArea(bucket));
  }
}
