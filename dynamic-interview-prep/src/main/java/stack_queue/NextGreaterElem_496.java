package stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElem_496 {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> nextGreater = new HashMap<>();
    Stack<Integer> s = new Stack<>();

    for(int i : nums2) {
      while(!s.isEmpty() && s.peek() < i) {
        nextGreater.put(s.pop(), i);
      }
      s.push(i);
    }

    int[] res = new int[nums1.length];
    for(int i = 0; i < res.length; i++) {
      res[i] = nextGreater.getOrDefault(nums1[i], -1);
    }

    return res;
  }
}
