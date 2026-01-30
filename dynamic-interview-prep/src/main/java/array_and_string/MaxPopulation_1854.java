package array_and_string;

public class MaxPopulation_1854 {
  public int maximumPopulation(int[][] logs) {
    int max = 0;
    int maxY = 0;
    for(int year = 1950; year <= 2050; year++) {
      int cur = 0;
      for(int[] y : logs) {
        int birth = y [0];
        int death = y [1];
        if(birth <= year && year < death ) {
          cur++;
        }
      }
      if(cur > max) {
        max = cur;
        maxY = year;
      }
    }
    return maxY;
  }
}
