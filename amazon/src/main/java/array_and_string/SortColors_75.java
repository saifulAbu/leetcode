package array_and_string;

public class SortColors_75 {
  public void sortColors(int[] nums) {
    int [] count = new int[3];
    for (int color : nums) {
      count[color]++;
    }

    int i = 0;
    for (int curColor = 0; curColor < count.length; curColor++) {
      for (int k = 0; k < count[curColor]; k++) {
        nums[i++] = curColor;
      }
    }
  }
}
