package stack_queue;

import java.util.Stack;

public class ImplementQueueUsingStack_232 {
  public ImplementQueueUsingStack_232() {

  }

  Stack<Integer> s0 = new Stack<>(), s1 = new Stack<>();

  public void push(int x) {
    s0.push(x);
  }

  public int pop() {
    if (s1.isEmpty()) {
      while (!s0.isEmpty()) {
        s1.push(s0.pop());
      }
    }
    return s1.pop();
  }

  public int peek() {
    if (s1.isEmpty()) {
      while (!s0.isEmpty()) {
        s1.push(s0.pop());
      }
    }
    return s1.peek();
  }

  public boolean empty() {
    return s1.size() + s0.size() == 0;
  }
}
