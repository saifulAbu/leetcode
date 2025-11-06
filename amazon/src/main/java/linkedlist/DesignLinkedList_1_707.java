package linkedlist;

public class DesignLinkedList_1_707 {
  Node head;
  Node tail;
  int size;

  public DesignLinkedList_1_707() {
    head = new Node(Integer.MIN_VALUE, null);
    tail = head;
    size = 0;
  }

  public void addAtHead(int val) {
    Node node = new Node(val, head.next);
    head.next = node;
    if(size == 0) {
      tail = node;
    }
    size++;
  }

  public void addAtTail(int val) {
    if(size == 0) {
      addAtHead(val);
      tail = head.next;
    } else {
      Node node = new Node(val);
      tail.next = node;
      tail = node;
      size++;
    }
  }

  private class Node {
    int val;
    Node next;
    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }

    Node(int val) {
      this(val, null);
    }

    Node() {
      this(0);
    }
  }

  public int get(int index) {
    if(index < 0 || index >= size) {
      return -1;
    }

    Node h = head.next;
    for(int i = 0; i < index; i++) {
      h = h.next;
    }

    return h.val;
  }

  public void addAtIndex(int index, int val) {
    if(index < 0 || index > size) {
      return;
    }
    if(index == size) {
      addAtTail(val);
    } else {
      Node parent = getParentOfIndex(index);
      Node node = new Node(val, parent.next);
      parent.next = node;
      size++;
    }
  }

  public void deleteAtIndex(int index) {
    if(index < 0 || index >= size) {
      return;
    }

    Node parent = getParentOfIndex(index);
    Node node = parent.next;
    parent.next = node.next;
    if(index == size - 1) {
      tail = parent;
    }

    size--;
  }

  private Node getParentOfIndex(int index) {
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

  public void testAddHead() {
    System.out.println("testing add at HEAD");
    DesignLinkedList_1_707 list = new DesignLinkedList_1_707();
    list.addAtHead(3);
    list.addAtHead(2);
    list.addAtHead(1);
    list.addAtHead(0);
    list.print();
  }

  public void testAddTail() {
    System.out.println("testing add at TAIL");
    DesignLinkedList_1_707 list = new DesignLinkedList_1_707();
    list.addAtTail(1);
    list.addAtTail(2);
    list.addAtTail(3);
    list.addAtTail(4);
    list.addAtTail(5);
    list.print();
  }

  public void testGet() {
    DesignLinkedList_1_707 list = new DesignLinkedList_1_707();
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
      DesignLinkedList_1_707 list = new DesignLinkedList_1_707();
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
    DesignLinkedList_1_707 list = new DesignLinkedList_1_707();
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

  void print(int index, int val) {
    System.out.println("index: " + index + " val: " + val);
  }
}
