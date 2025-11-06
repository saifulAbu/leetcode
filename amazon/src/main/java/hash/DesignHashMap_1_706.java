package hash;

//class MyHashMap {
public class DesignHashMap_1_706 {

  class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    Node(int key, int value) {
      this(key, value, null);
    }

    Node() {
      this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
  }

  private final int SIZE = 29;
  Node[] arr;

  public DesignHashMap_1_706() {
    //public MyHashMap() {

    //initialize array with a dummy head
    arr = new Node[SIZE];
    for(int i = 0; i < SIZE; i++) {
      arr[i] = new Node();
    }
  }

  private Node getParent(int key) {
    Node h = arr[getHashFor(key)];
    while(h.next != null) {
      if(h.next.key == key) {
        return h;
      }
      h = h.next;
    }
    return null;
  }

  private int getHashFor(int key) {
    return key % SIZE;
  }

  public void put(int key, int value) {
    Node parent = getParent(key), target = null;
    if(parent == null) {
      parent = arr[getHashFor(key)];
      target = new Node(key, value, parent.next);
      parent.next = target;
    }
    target = parent.next;
    target.value = value;
  }

  public int get(int key) {
    Node parent = getParent(key);
    if(parent == null) {
      return -1;
    }
    Node target = parent.next;
    return target.value;
  }

  public void remove(int key) {
    Node parent = getParent(key);
    if(parent == null) {
      return;
    }
    Node target = parent.next;
    parent.next = target.next;
    target.next = null;
  }
}
