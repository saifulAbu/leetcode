package walmart_mar_26;

import java.util.*;

public class ThreeSum_15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n - 2; i++) {

      // skip duplicate anchors
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int left = i + 1;
      int right = n - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));

          left++;
          right--;

          // skip duplicate left values
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }

          // skip duplicate right values
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }

        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return result;
  }


  public List<List<Integer>> threeSum_bruteForce(int[] nums) {
    int len = nums.length;

    Set<List<Integer>> result = new HashSet<>();
    HashMap<Integer, Integer> indices = new HashMap<>();
    for(int i = 0; i < len; i++) {
      indices.put(nums[i], i);
    }

    for(int i = 0; i < len; i++) {
      for(int j = i + 1; j < len; j++) {
        int need = -(nums[i] + nums[j]);
        if(!indices.containsKey(need)) {
          continue;
        }
        int k = indices.get(need);
        if(k == i || k == j) {
          continue;
        }
        List<Integer> triplets = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k]));
        Collections.sort(triplets);
        result.add(triplets);
      }
    }
    return new ArrayList<>(result);
  }
}
