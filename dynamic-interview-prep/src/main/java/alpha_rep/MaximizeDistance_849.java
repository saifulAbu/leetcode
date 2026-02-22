package alpha_rep;

public class MaximizeDistance_849 {
  public int maxDistToClosest(int[] seats) {
    /*
    * we will create two arrays, left and right
    * left will contain the distance on left side on i'th position, right constructed the same way
    * at any index, curDistance is = min(left[i], right[i]).
    * take the max among all the distances
    * */

    int NUM_SEAT = seats.length;
    int[] left = new int[NUM_SEAT], right = new int[NUM_SEAT];

    //fill up the left
    if(seats[0] == 0) {
      left[0] = NUM_SEAT;
    }
    for(int i = 1; i < NUM_SEAT; i++) {
      if(seats[i] == 1) {
        left[i] = 0;
      } else {
        left[i] = left[i-1] + 1;
      }
    }

    //fill up the right
    if(seats[NUM_SEAT - 1] == 0) {
      right[NUM_SEAT - 1] = NUM_SEAT;
    }

    for(int i = NUM_SEAT - 2; i >= 0; i--) {
      if(seats[i] == 1) {
        right[i] = 0;
      } else {
        right[i] = right[i + 1] + 1;
      }
    }

    int maxDistance = 0;
    for(int i = 0; i < NUM_SEAT; i++) {
      maxDistance = Math.max(maxDistance, Math.min(left[i], right[i]));
    }

    return maxDistance;
  }
}
