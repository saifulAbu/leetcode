package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue_225 {
  /*
  * push operations for (a, b)
  * stack => [a, b*]
  * pop operations will return the following
  * b, a
  *
  * on a reqular queue push (a, b) will give the following queue
  * [a*, b]
  * pop will return the following
  * a, b
  *
  * we somehow want the queue to look as the following
  * [b*, a]
  *
  * in order to do that we can have a primary and a secondary queue.
  * push operation:
  * 0. if the primary queue is empty, just add to primary
  *    primary [a], secondary []
  * 1. primary queue is not empty, add to secondary
  *    primary[a], secondary [b]
  * 3. pop all elements from primary to secondary
  *   primary[], secondary [b, a]
  * 4. swap primary reference to secondary
  *   primary[b, a], secondary []
  * pop operation
  * 0. just return the top element from primary queue
  *
  * example for 3 elements
  * push a, b => primary [b, a], secondary[]
  * push c => primary [b, a], secondary[c] => primary[], secondary [c, b, a] => primary [c, b, a], secondary = []
  *
  * */

  Queue<Integer> primary = new LinkedList<>(), secondary = new LinkedList<>(), temp;
  //public MyStack() {
  public ImplementStackUsingQueue_225() {

  }

  public void push(int x) {
    secondary.offer(x);
    movePrimaryToSecondary();
    swapPrimaryWithSecondary();

  }

  private void movePrimaryToSecondary() {
    while(!primary.isEmpty()) {
      secondary.offer(primary.poll());
    }
  }

  private void swapPrimaryWithSecondary() {
    temp = secondary;
    secondary = primary;
    primary = temp;
  }


  public int pop() {
    return primary.poll();
  }

  public int top() {
    return primary.peek();
  }

  public boolean empty() {
    return primary.isEmpty();
  }
}


class ImplementStackUsingQueue_0_225 {
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
