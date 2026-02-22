package alpha_rep;

class DesignLinkedList_2_18 {

  class Node {
    Node prev, next;
    int val;

    Node(int val) {
      this.val = val;
    }
  }

  int size = 0;
  Node head = new Node(-1), tail = head;

  //public MyLinkedList() {
  public DesignLinkedList_2_18(){

  }

  public int get(int index) {
    if(index < 0 || index >= size) {
      return -1;
    }
    Node curPrev = head;
    for(int i = 0; i < index; i++) {
      curPrev = curPrev.next;
    }
    Node node = curPrev.next;
    return node.val;
  }

  public void addAtHead(int val) {
    if(size == 0) {
      addAtTail(val);
      return;
    }
    Node node = new Node(val);
    Node curFront = head.next;
    curFront.prev = node;
    node.next = curFront;

    node.prev = head;
    head.next = node;
    size++;
  }

  public void addAtTail(int val) {
    Node node = new Node(val);
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }

  public void addAtIndex(int index, int val) {
    if(index > size) {
      return;
    } else if(index == 0) {
      addAtHead(val);
      return;
    } else if (index == size) {
      addAtTail(val);
      return;
    }
    Node node = new Node(val);
    Node curPrev = head;

    for(int i = 0; i < index; i++) {
      curPrev = curPrev.next;
    }

    Node next = curPrev.next;

    node.next = next;
    next.prev = node;

    curPrev.next = node;
    node.prev = curPrev;
    size++;
  }

  public void deleteAtIndex(int index) {
    if(index >= size) {
      return;
    }
    if(index == size - 1) {
      tail = tail.prev;
      tail.next = null;
      size--;
      return;
    }

    Node curPrev = head;
    for(int i = 0; i < index; i++) {
      curPrev = curPrev.next;
    }

    Node toDelete = curPrev.next;
    Node nextNode = toDelete.next;
    curPrev.next = nextNode;
    nextNode.prev = curPrev;
    size--;
  }
}
