package design;

import java.util.LinkedList;

public class MinStack {
  LinkedList<Integer> q, m;
  public MinStack() {
    q = new LinkedList<>();
    m = new LinkedList<>();
  }

  public void push(int val) {
    q.push(val);
    int curMin = val;
    if (!m.isEmpty()) {
      curMin = Math.min(curMin, m.peek());
    }
    m.push(curMin);
  }

  public void pop() {
    q.pop();
    m.pop();
  }

  public int top() {
    return q.peek();
  }

  public int getMin() {
    return m.peek();
  }
}
