package alpha_rep;

import java.util.Arrays;

//noted
public class KokoEatingBananas_875 {
  public int minEatingSpeed(int[] piles, int guardInterval) {
    int l = 1, h = -1;

    //find max eat rate
    for(int count : piles) {
      if(count > h) {
        h = count;
      }
    }

    while(l <= h) {
      int m = l + (h - l) / 2;
      long pileFinishTime = hourToEat(piles, m);
      if(pileFinishTime <= guardInterval) {
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }

  private long hourToEat(int[] piles, int eatingRate) {
    long totalTime = 0;
    for (int count : piles) {
      totalTime += (count + eatingRate - 1) / eatingRate; // integer ceil
    }
    return totalTime;
  }


  private int hourToEat_caues_overflow(int[] piles, int eatingRate) {
    int totalTime = 0;
    for(int count : piles) {
      totalTime += (int) Math.ceil((count) / (double)eatingRate);
    }
    return totalTime;
  }

  public int minEatingSpeed_drona(int[] piles, int H) {
    int l = 1, h = getMax(piles);
    int minResult = h;

    while (l <= h) {
      int m = l + (h - l) / 2;
      int timeNeeded = calculateTime(m, piles);

      if (timeNeeded <= H) {
        minResult = m;   // store speed, not time
        h = m - 1;       // try slower speed
      } else {
        l = m + 1;       // need faster speed
      }
    }

    return minResult;
  }

  private int getMax(int[] piles) {
    int max = 0;
    for (int count : piles) {
      if (count > max) {
        max = count;
      }
    }
    return max;
  }

  private int calculateTime(int spd, int[] piles) {
    int total = 0;
    for (int count : piles) {
      total += (count + spd - 1) / spd; // ceil
    }
    return total;
  }



}
