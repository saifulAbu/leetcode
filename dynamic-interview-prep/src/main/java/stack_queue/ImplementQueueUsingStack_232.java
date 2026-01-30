package stack_queue;

import java.util.Stack;

public class ImplementQueueUsingStack_232 {
  /*
  * example: push [a, b , c]
  * queue should look [a*, b, c]
  * pop() -> a, pop() -> b, pop() -> c
  *
  * a regular stack will be like this for the above push operations
  * [a, b, c*]
  * for pop operations
  * c, b, a
  *
  * after pushing a, b, c if our stack looks the following, we are good to just pop from it
  * [c, b, a*]
  *
  * we can achieve this stack by the following when push happens
  * 0. if stack is empty, simply push
  *    [a]
  * 1. pop items from the main stack and push it to a secondary stack if stack is non-empty
  *   primary [a], secondary []
  *   primary[], secondary[a]
  * 2. push item on primary
  *   [b]
  * 3. push all items from secondary to primary
  *   primary [b, a], secondary []
  *
  * */

  public ImplementQueueUsingStack_232 (){
  //public MyQueue() {

  }

  Stack<Integer> primary = new Stack<>(), secondary = new Stack<>();

  private void move(Stack<Integer> src, Stack<Integer> dest) {
    while(!src.isEmpty()) {
      dest.push(src.pop());
    }
  }

  public void push(int x) {
    move(primary, secondary);
    primary.push(x);
    move(secondary, primary);
  }

  public int pop() {
    return primary.pop();
  }

  public int peek() {
    return primary.peek();
  }

  public boolean empty() {
    return primary.isEmpty();
  }
}

class ImplementQueueUsingStack_0_232 {
  public ImplementQueueUsingStack_0_232() {

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
