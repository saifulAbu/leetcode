package stack_queue;

class DesignCircularQueue_622 {
  int MAX_LEN = 0, len = 0;
  int frontPtr = 0, backPtr = 0;
  int[] q;

  //public MyCircularQueue(int k) {
  public DesignCircularQueue_622(int k) {
    this.MAX_LEN = k;
    q = new int[k];
  }

  public int Front() {
    if(isEmpty()) {
      return -1;
    }
    return q[frontPtr];
  }

  public int Rear() {
    if(isEmpty()) {
      return -1;
    }
    return q[prevPtr(backPtr)];
  }

  public boolean isEmpty() {
    return len == 0;
  }

  public boolean isFull() {
    return len == MAX_LEN;
  }

  public boolean enQueue(int value) {
    if(isFull()) {
      return false;
    }

    q[backPtr] = value;
    backPtr = nextPtr(backPtr);
    len++;
    return true;
  }

  public boolean deQueue() {
    if(isEmpty()) {
      return false;
    }

    frontPtr = nextPtr(frontPtr);
    len--;
    return true;
  }

  private int nextPtr(int curPtr) {
    return (curPtr + 1 + MAX_LEN) % MAX_LEN;
  }

  private int prevPtr(int curPtr) {
    return (curPtr - 1 + MAX_LEN) % MAX_LEN;
  }
}


class DesignCircularQueue_0_622 {
  int size = 0;
  int k = 0;
  int [] q;
  int i = 0, j = 0;
  public DesignCircularQueue_0_622(int k) {
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
