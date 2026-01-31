package alpha_rep;

public class ContainerWithMostWater_11 {

  public int maxArea(int[] height) {
    /*
    * b         f
    * 0 1 2 3 4 5
    * 1 2 5 5 6 7
    *
    * for the scenario above, we can start with two pointers, f and b.
    * at each point, we can calculate the water amount = (f-b) * (min(f,b)) and update maxWater.
    * after each calculation, we want to compute the next one, we can apply greedy approach.
    * we can move the pointer that is pointing minimum water level. that way we are hoping the next water amount will be
    * greater or equal what we have currently. if there is a tie, we can move b pointer.
    * if we are doing greedy, can we miss a solution? lets check that out.
    *
    * 1 2 100 2 4 200 7 8
    * we do compute the case for 100, and 200 barrier. this will be our max level
    *
    * complexity = O(n)
    * */

    int b = 0, f = height.length - 1, maxWater = 0;
    while(b < f) {
      int bHeight = height[b], fHeight = height[f];
      int curWater = (f - b) * (Math.min(fHeight, bHeight));
      maxWater = Math.max(maxWater, curWater);
      if(bHeight < fHeight) {
        b++;
      } else {
        f--;
      }
    }
    return maxWater;
  }

  public int maxArea_0(int[] height) {
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
}
