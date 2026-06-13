package alpha_rep;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    // Use ArrayList for better memory performance in recursion
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(int[] nums, int index, List<Integer> currentPath, List<List<Integer>> result) {
    // Base Case: We've made a decision for every element
    if (index == nums.length) {
      // Crucial: Create a deep copy because currentPath is reused
      result.add(new ArrayList<>(currentPath));
      return;
    }

    // Choice 1: "Include" the element at the current index
    currentPath.add(nums[index]);
    backtrack(nums, index + 1, currentPath, result);

    // Choice 2: "Exclude" the element (Backtrack)
    // We remove the element we just added to reset the state for the 'Exclude' branch
    currentPath.remove(currentPath.size() - 1);
    backtrack(nums, index + 1, currentPath, result);
  }

  public List<List<Integer>> subsets_1(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack_3_28(nums, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void backTrack_3_28(int [] nums, int i, List<Integer> runningSet, List<List<Integer>> result) {
    if(i == nums.length) {
      result.add(new ArrayList<>(runningSet));
      return;
    }
    //take
    runningSet.add(nums[i]);
    backTrack_3_28(nums, i + 1, runningSet, result);

    // don't take
    runningSet.remove(runningSet.size() - 1);
    backTrack_3_28(nums, i + 1, runningSet, result);
  }

  public List<List<Integer>> subsets_drona(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack_drona(nums, 0, new ArrayList<>(), result);
    return result;
  }

  private void backTrack_drona(int [] nums, int i, List<Integer> runningSet, List<List<Integer>> result) {
    if(i == nums.length) {
      result.add(new ArrayList<>(runningSet));
      return;
    }
    // take
    runningSet.add(nums[i]);
    backTrack_drona(nums, i + 1, runningSet, result);

    // don't take
    runningSet.remove(runningSet.size() - 1);
    backTrack_drona(nums, i + 1, runningSet, result);
  }
}
