package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray_1389 {
  public int[] createTargetArray(int[] nums, int[] index) {
    int [] output = new int[nums.length];
    List<Integer> outList = new ArrayList<>();

    for(int i = 0; i < nums.length; i++){
      outList.add(index[i], nums[i]);
    }

    for(int i = 0; i < nums.length; i++) {
      output[i] = outList.get(i);
    }

    return output;
  }
}
