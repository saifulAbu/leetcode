package stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Minstack_155 {
  LinkedList<Integer> stack = new LinkedList<>();
  LinkedList<Integer> minStack = new LinkedList<>();
  int curMin = Integer.MAX_VALUE;

  public Minstack_155() {
  //public MinStack() {
    stack.push(Integer.MAX_VALUE);
    stack.push(Integer.MAX_VALUE);
  }

  public void push(int val) {
    curMin = val < curMin ? val : curMin;
    stack.push(val);
    minStack.push(curMin);
  }

  public void pop() {
    minStack.pop();
    curMin = minStack.isEmpty()? Integer.MAX_VALUE : minStack.peek();
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return curMin;
  }
}

class MinStack_1 {
  Stack<Integer> stack = new Stack<>();
  Stack<Integer> minStack = new Stack<>();

  public MinStack_1() {

  }

  public void push(int val) {
    stack.push(val);
    int curMin = minStack.peek();
    if(val < curMin) {
      minStack.push(val);
    } else {
      minStack.push(curMin);
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}