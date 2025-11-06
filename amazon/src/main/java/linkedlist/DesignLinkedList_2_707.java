package linkedlist;

// implementation of a linkedList using doubly linked lists
//class MyLinkedList {
public class DesignLinkedList_2_707 {
  class Node {
    int val;
    Node prev, next;
    Node (int val, Node prev, Node next) {
      this.val = val;
      this.prev = prev;
      this.next = next;
    }

    Node(int val) {
      this(val, null, null);
    }
  }

  Node head, tail;
  int size;

  //public MyLinkedList() {
  public DesignLinkedList_2_707() {
    head = new Node(Integer.MIN_VALUE);
    tail = head;
    size = 0;
  }

  public void addAtHead(int val) {
    head.next = new Node(val, head, head.next);
    if(size == 0) {
      tail = head.next;
    }
    size++;
  }

  public void addAtTail(int val) {
    tail.next = new Node(val, tail, null);
    tail = tail.next;
    size++;
  }

  public int get(int index) {
    if(!isValidIndex(index)) {
      return -1;
    }
    Node parent = getParentOf(index);
    Node target = parent.next;
    return target.val;
  }

  public void addAtIndex(int index, int val) {
    if(index == size) {
      addAtTail(val);
      return;
    }

    if(!isValidIndex(index)) {
      return;
    }

    Node prev = getParentOf(index);
    Node next = prev.next;
    Node middle = new Node(val, prev, next);
    prev.next = middle;
    next.prev = middle;
    size++;
  }

  public void deleteAtIndex(int index) {
    if(!isValidIndex(index)) {
      return;
    }

    Node parent = getParentOf(index);
    Node oldNext = parent.next;
    Node newNext = oldNext.next;

    //remove all pointers coming from oldNext node
    oldNext.prev = null;
    oldNext.next = null;

    //if it is the last node we are deleting update tail
    if(size == index - 1 || oldNext == tail) {
      parent.next = null;
      tail = parent;
    } else {
      parent.next = newNext;
      newNext.prev = parent;
    }
    size--;
  }



  private boolean isValidIndex(int index) {
    if(index < 0 || index >= size) {
      return false;
    }
    return true;
  }

  //caller need to make sure of sending proper index
  private Node getParentOf(int index) {
    Node h = head;
    for(int i = 0; i < index; i++) {
      h = h.next;
    }
    return h;
  }

  //test methods
  private void print() {
    System.out.println("size: " + size);
    Node h = head;
    StringBuilder sb = new StringBuilder(100);
    for (int i = 0; i < size; i++) {
      sb.append(h.next.val);
      if (i != size - 1) {
        sb.append(" -> ");
      }
      h = h.next;
    }
    System.out.println(sb.toString());
  }

  void print(int index, int val) {
    System.out.println("index: " + index + " val: " + val);
  }

  public void testAddHead() {
    System.out.println("testing add at HEAD");
    DesignLinkedList_2_707 list = new DesignLinkedList_2_707();
    list.addAtHead(3);
    list.addAtHead(2);
    list.addAtHead(1);
    list.addAtHead(0);
    list.print();
    System.out.println();
  }

  public void testAddTail() {
    System.out.println("testing add at TAIL");
    DesignLinkedList_2_707 list = new DesignLinkedList_2_707();
    list.addAtTail(3);
    list.addAtTail(2);
    list.addAtTail(1);
    list.addAtTail(0);
    list.print();
    System.out.println();
  }

  public void testGet() {
    System.out.println("testing GET");
    DesignLinkedList_2_707 list = new DesignLinkedList_2_707();
    list.addAtTail(1);
    list.addAtTail(2);
    list.addAtTail(3);
    list.addAtTail(4);
    list.addAtTail(5);
    list.print();
    for(int i = 0; i < 10; i++) {
      list.print(i, list.get(i));
    }
  }

  public void testAddAtIndex() {
    System.out.println("test at ADDatINDEX");
    DesignLinkedList_2_707 list = new DesignLinkedList_2_707();
    list.addAtHead(3);
    list.addAtHead(2);
    list.addAtHead(1);
    list.addAtHead(0);
    list.print();
    list.addAtIndex(0, 100);
    list.print();
    list.addAtIndex(3, 200);
    list.print();
    list.addAtIndex(6, 700);
    list.print();
    list.addAtIndex(10, 1000);
    list.print();
  }

  public void testDeleteAtIndex() {
    System.out.println("test DELETEATINDEX");
    DesignLinkedList_2_707 list = new DesignLinkedList_2_707();
    list.addAtHead(3);
    list.addAtHead(2);
    list.addAtHead(1);
    list.addAtHead(0);
    list.print();
    list.addAtIndex(0, 100);
    list.print();
    list.addAtIndex(3, 200);
    list.print();
    list.addAtIndex(6, 700);
    list.print();
    list.addAtIndex(10, 1000);
    list.print();
    list.deleteAtIndex(6);
    list.deleteAtIndex(3);
    list.deleteAtIndex(0);
    list.print();

    for(int i = 0; i < 5; i++) {
      print(i, list.get(i));
    }
  }
}
