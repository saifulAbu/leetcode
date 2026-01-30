package alpha_rep;

import java.util.*;

public class Sum3_15 {

  public List<List<Integer>> threeSum(int[] nums) {
    /*
    * first sort the array. we will use a few pointers.
    *  p0 p1                      p3
    *  0  1  2  3  4  5  6  7  8  9
    * -3 -3 -2 -2 -1  0  0  1  1  5
    *
    *  we will start p0 = 0, p1 = p0 + 1, p2 = len - 1
    *  max value of p0 can be 7, len is 10, so p0 < len - 2
    *  we sum up sum = arr[p0] + arr[p1] + arr[p2].
    *  if sum < 0, we move p1 forward to increase the sum
    *  if sum > 0, we move p2 backward to decrease sum
    *  if sum == 0, we move p1 forward skipping all the duplicates.
    *     in past, we found lets say, -3, -2, 5 combination, next we will have -3, -1, 4, this guarantees that our tuples
    *     will never contain dups
    *  we stop the inner loop when p1 >= p2
    *  we move forward p0 and skip all the dups
    *
    *  complexity: timeComplexity:
    *   we are sorting and we have two for loops
    *     O(n * n) + O(n * log(n))
    * */
    List<List<Integer>> triplets = new LinkedList<>();
    if(nums.length < 3) {
      return triplets;
    }

    Arrays.sort(nums);
    int p0 = 0, LEN = nums.length;
    while(p0 < LEN - 2) {
      int p1 = p0 + 1, p2 = LEN - 1;

      while(p1 < p2) {
        int curSum = nums[p0] + nums[p1] + nums[p2];
        if(curSum > 0) {
          p2--;
        } else if (curSum < 0) {
          p1++;
        } else {
          triplets.add(Arrays.asList(nums[p0], nums[p1], nums[p2]));

          //move forward p1 so that we can skip all the dups
          p1++;
          while(p1 < LEN - 1 && nums[p1] == nums[p1 - 1]) {
            p1++;
          }
        }
      }// end of inner loop for advancing p1 and p2

      //advance p0 and skip all the dups
      p0++;
      while(p0 < LEN - 2 && nums[p0] == nums[p0 - 1]) {
        p0++;
      }
    }
    return triplets;
  }











  public List<List<Integer>> threeSum_1(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);
    int p0 = 0;
    int len = nums.length;
    while (p0 < len - 2) {
      int p1 = p0 + 1;
      int p2 = len - 1;
      while (p1 < p2) {
        int sum = nums[p0] + nums[p1] + nums[p2];
        if (sum == 0) {
          List<Integer> list = Arrays.asList(nums[p0], nums[p1], nums[p2]);
          res.add(list);
          do {
            p1++;
          }  while (p1 < len - 1 && nums[p1] == nums[p1 - 1]);
        } else if (sum < 0){
          p1++;
        } else {
          p2--;
        }

      }
      do {
        p0++;
      } while (p0 < len - 2 && nums[p0] == nums[p0 - 1]);
    }
    return res;
  }

  public List<List<Integer>> threeSum_0(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);
    //special case 3 zeros
    int zeroCount = 0;
    for (int i : nums) {
      if (i == 0) {
        zeroCount++;
      }
    }
    if (zeroCount >= 3) {
      res.add(Arrays.asList(0, 0, 0));
    }
    Map<Integer, Integer> map = new HashMap<>();
    //add number to map if negative latest index, if positive earliest
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        map.put(nums[i], i);
      } else {
        if (!map.containsKey(nums[i])) {
          map.put(nums[i], i);
        }
      }
    }

    int low = 0;
    int hi = nums.length - 1;
    while (low < hi) {
      int sum = nums[low] + nums[hi];
      int target = sum * -1 ;
      if (map.containsKey(target)) {
        int targetIndex = map.get(target);
        if (targetIndex != low && targetIndex != hi) {
          int a = nums[low];
          int b = nums[targetIndex];
          int c = nums[hi];
          List<Integer> list = Arrays.asList(a, b, c);
          res.add(list);
          while (nums[low] == a) {
            low++;
          }
          while (nums[hi] == c) {
            hi--;
          }
          continue;
        }
      }
      if (sum < 0) {
        low++;
      } else {
        hi--;
      }
    }
    return res;
  }
}
