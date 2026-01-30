package array_and_string;

import java.util.LinkedList;
import java.util.List;

public class SummaryRange_228 {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new LinkedList<>();
    //write loop here
    int i = 0;
    while (i < nums.length) {
      int start = nums[i];
      while (i + 1 < nums.length && nums[i+1] - nums[i] == 1) {
        i++;
      }
      int end = nums[i];
      res.add(formRange(start, end));
      i++;
    }
    return res;
  }

  private String formRange(int start, int end) {
    return start == end? Integer.toString(start) : Integer.toString(start) + "->" + end;
  }
}

//

