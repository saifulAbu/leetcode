package stack_queue;

public class DesignCircularQueue_622 {
  int size = 0;
  int k = 0;
  int [] q;
  int i = 0, j = 0;
  public DesignCircularQueue_622(int k) {
    q = new int[k];
    this.k = k;
  }

  public boolean enQueue(int value) {
    if (size == k) {
      return false;
    }
    q[i] = value;
    i = (i + 1) % k;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (size == 0) {
      return false;
    }
    j = (j + 1) % k;
    size--;
    return true;
  }

  public int Front() {
    if (size == 0) {
      return -1;
    }
    return q[i];
  }

  public int Rear() {
    if (size == 0) {
      return -1;
    }
    return q[(i + k - 1) % k];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == k;
  }
}
