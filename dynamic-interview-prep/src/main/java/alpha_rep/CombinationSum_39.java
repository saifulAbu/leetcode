package alpha_rep;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
  public List<List<Integer>> combinationSum_drona(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack_drona(candidates, target, 0, new ArrayList<>(), result);
    return result;
  }

  private void backTrack_drona(int[] canditates, int target, int curIndex, List<Integer> curCombination, List<List<Integer>> result) {
    if(target == 0) {
      result.add(new ArrayList<>(curCombination));
      return;
    } else if (curIndex == canditates.length || target < 0){
      return;
    }
    // take cur element
    int curElement = canditates[curIndex];
    curCombination.add(curElement);
    backTrack_drona(canditates, target - curElement, curIndex, curCombination, result);

    // ignore cur element
    curCombination.remove(curCombination.size() - 1);
    backTrack_drona(canditates, target, curIndex + 1, curCombination, result);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack(candidates, 0, new ArrayList<>(), target, result);
    return result;
  }

  void backTrack(int[] candidates, int index, List<Integer> curCombination, int target, List<List<Integer>> result) {
    if(index >= candidates.length) {
      return;
    }

    int curSum  = getSum(curCombination);
    if(curSum == target) {
      result.add(new ArrayList<>(curCombination));
      return;
    } else if(curSum > target) {
      return;
    }

    //try adding this index again
    curCombination.add(candidates[index]);
    backTrack(candidates, index, curCombination, target, result);

    //add cur element and going to the next element
    backTrack(candidates, index+1, curCombination, target, result);

    //not adding cur element adn going to the next element
    curCombination.remove(curCombination.size() - 1);
    backTrack(candidates, index + 1, curCombination, target, result);

    //returning from the function clean, added current element once, removed once
  }

  private void backTrack(int[] candidates, int index, List<Integer> cur, int target, int currentSum, List<List<Integer>> result) {
    // 1. Base Case: Success
    if (currentSum == target) {
      result.add(new ArrayList<>(cur));
      return;
    }

    // 2. Base Case: Dead End (Out of bounds or exceeded sum)
    if (index >= candidates.length || currentSum > target) {
      return;
    }

    // CHOICE 1: Include the current element
    cur.add(candidates[index]);
    // Stay at 'index' so we can reuse it, update sum instantly
    backTrack(candidates, index, cur, target, currentSum + candidates[index], result);

    // BACKTRACK: Remove the element to reset state for the next choice
    cur.remove(cur.size() - 1);

    // CHOICE 2: Skip the current element entirely and move to the next
    backTrack(candidates, index + 1, cur, target, currentSum, result);
  }

  private int getSum(List<Integer> combination) {
    int sum = 0;
    for(int elem : combination) {
      sum += elem;
    }
    return sum;
  }

  public List<List<Integer>> combinationSum_0531(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();

    backtrack_0531(candidates, 0, target, result, new ArrayList<Integer>());

    return result;
  }

  private void backtrack_0531(int[] candidates, int i, int target, List<List<Integer>> result, ArrayList<Integer> runningList) {

    if(target == 0) {
      result.add(new ArrayList<>(runningList));
      return;
    }

    if(i == candidates.length || target < 0) {
      return;
    }

    //take
    runningList.add(candidates[i]);
    backtrack_0531(candidates, i, target - candidates[i], result, runningList);

    //don't take
    runningList.remove(runningList.size() - 1);
    backtrack_0531(candidates, i+1, target, result, runningList);

  }
}
