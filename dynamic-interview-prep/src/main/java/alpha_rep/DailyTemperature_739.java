package alpha_rep;

import java.util.Stack;

public class DailyTemperature_739 {

  /*
  * case
  * [30 20 40]
  * res
  * [2 1 0]
  * we will maintain a stack as we go through the list of temperature
  * stack will hold index of a temperature
  * if current temperature is greater than prevMaxTemperature
  * current temperature can override previous max temperature
  * example stack build up
  * when we see the temperature 30, stack is empty
  * [0]
  * next we see 20 at index 1
  *   we look at the top of stack, it's 0, temperature at 0 index is 30. so 20 cannot do anything in this stack
  *   we push 1
  *   [0 1] is current the stack
  * next we see 40 at index 2
  *   we look at the top of stack, index 1, temp 20
  *   we can update information about this temperature
  *   on waitDays[1] we can put 2-1 = 1, that tells on index 1, we will have to wait for 1 day to get a warmer temperature than 20
  *   we pop the index 1 out of stack
  *   we see current top of stack is 0, temperature at that index is 30
  *   we repeat the step above to update result for that index
  * */
  public int[] dailyTemperatures_drona(int[] temperatures) {
    Stack<Integer> s = new Stack<>();
    int n = temperatures.length;
    int wait[] = new int[n];

    for(int i = 0; i < n; i++) {
      while(!s.empty() && temperatures[i] > temperatures[s.peek()]) {
        int prev = s.pop();
        wait[prev] = i - prev;
      }
      s.push(i);
    }
    return wait;
  }

  public int[] dailyTemperatures(int[] temperatures) {
    int NUM_DAYS = temperatures.length;
    Stack<Integer> waitingTemperatures = new Stack<>();
    int [] waitDays = new int[NUM_DAYS];

    for(int curTempIndex = 0; curTempIndex < NUM_DAYS; curTempIndex++) {
      int curTemp = temperatures[curTempIndex];

      //update all the lower temperature wait days that are lower than this temperature
      while(!waitingTemperatures.isEmpty()) {
        int waitingTempIndex = waitingTemperatures.peek();
        int waitingTemp = temperatures[waitingTempIndex];
        //curTemp is not warmer, so do nothing
        if(waitingTemp >= curTemp) {
          break;
        }
        //waitingTempIndex day will have to wait for (curTempIndex - waitingTempIndex) days to get a warmer temp
        waitDays[waitingTempIndex] = curTempIndex - waitingTempIndex;
        //pop the processed day
        waitingTemperatures.pop();
      }
      waitingTemperatures.push(curTempIndex);
    }
    return waitDays;
  }

  public int[] dailyTemperatures0(int[] temperatures) {
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

  public int[] dailyTemperatures_2(int[] temperatures) {
    Stack<Integer> s = new Stack<>();
    int n = temperatures.length;
    int wait[] = new int[n];

    for(int i = 0; i < n; i++) {
      while(!s.empty() && temperatures[i] > temperatures[s.peek()]) {
        int prev = s.pop();
        wait[prev] = i - prev;
      }
      s.push(i);
    }
    return wait;
  }























}
