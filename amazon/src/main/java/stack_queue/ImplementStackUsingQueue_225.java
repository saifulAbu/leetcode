package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue_225 {
  Queue<Integer> q = new LinkedList<>();

  public void push(int x) {
    int prevSize = q.size();
    q.offer(x);
    for (int i = 0; i < prevSize; i++) {
      q.offer(q.poll());
    }
  }

  public int pop() {
    return q.poll();
  }

  public int top() {
    return q.peek();
  }

  public boolean empty() {
    return q.isEmpty();
  }
}
