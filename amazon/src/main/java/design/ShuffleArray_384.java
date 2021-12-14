package design;

import java.util.Random;

public class ShuffleArray_384 {
  private int [] original;
  private Random random = new Random();

  public ShuffleArray_384(int[] nums) {
    original = nums.clone();
  }

  public int[] reset() {
    return original.clone();
  }

  public int[] shuffle() {
    int [] res = original.clone();
    for (int i = 0; i < res.length; i++) {
      int rand = getRandomNumber(i, res.length);

      int t = res[i];
      res[i] = res[rand];
      res[rand] = t;
    }

    return res;
  }

  private int getRandomNumber(int min, int max) {
    return random.nextInt(max-min)  + min;
  }
}
