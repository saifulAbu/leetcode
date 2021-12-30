package stack_queue;

import java.util.Stack;

public class DailyTemperature_739 {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      int curT = temperatures[i];
      while (!stack.isEmpty() && temperatures[stack.peek()] < curT) {
        int j = stack.pop();
        res[j] = i - j;
      }
      stack.push(i);
    }
    return res;
  }
}
