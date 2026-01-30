package hash;

//class MyHashSet {
public class DesignHashSet_1_705 {

  class Node {
    int key;
    Node next;

    Node(int key, Node next) {
      this.key = key;
      this.next = next;
    }

    Node(int key) {
      this(key, null);
    }

    Node() {
      this(Integer.MIN_VALUE);
    }
  }

  private final int SIZE = 29;
  Node[] arr;

  public DesignHashSet_1_705() {
  //public MyHashSet() {

    //initialize array with a dummy head
    arr = new Node[SIZE];
    for(int i = 0; i < SIZE; i++) {
      arr[i] = new Node();
    }
  }

  public boolean contains(int key) {
     Node h = arr[getHashFor(key)].next;
     while(h != null) {
       if(h.key == key) {
         return true;
       }
       h = h.next;
     }
     return false;
  }

  public void add(int key) {
    if(contains(key)) {
      return;
    }

    // add to the head of the proper map
    Node h = arr[getHashFor(key)];
    h.next = new Node(key, h.next);
  }

  private int getHashFor(int key) {
    return key % SIZE;
  }

  public void remove(int key) {
    if(!contains(key)) {
      return;
    }

    //find the parent of target key
    Node h = arr[getHashFor(key)];
    while(h.next != null) {
      if(h.next.key == key) {
        break;
      }
      h = h.next;
    }

    Node deleteNode = h.next;
    h.next = deleteNode.next;
    deleteNode.next = null;
  }
}
