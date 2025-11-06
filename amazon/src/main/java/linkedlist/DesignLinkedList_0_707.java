package linkedlist;

public class DesignLinkedList_0_707 {
  private static class MyLLNode {
    int val;
    MyLLNode prev;
    MyLLNode next;

    MyLLNode (int val) {
      this.val = val;
    }
  }

  private MyLLNode head;
  private MyLLNode tail;
  int size;

  public DesignLinkedList_0_707() {
    head = new MyLLNode(Integer.MIN_VALUE);
    tail = null;
    size = 0;
  }

  public void addAtHead(int val) {
    MyLLNode n = new MyLLNode(val);
    n.next = head.next;
    n.prev = head;
    head.next = n;
    if (size == 0) {
      tail = n;
    } else {
      n.next.prev = n;
    }
    size++;
  }

  public void addAtTail(int val) {
    if (size == 0) {
      addAtHead(val);
    } else {
      MyLLNode n = new MyLLNode(val);
      n.prev = tail;
      tail.next = n;
      tail = n;
      size++;
    }
  }

  private void deleteAtHead() {
    if (size == 0) {
      return;
    } else if (size == 1) {
      head.next = null;
      tail = null;
    } else {
      MyLLNode newFirstNode = head.next.next;
      head.next = newFirstNode;
      newFirstNode.prev = head;
    }
    size--;
  }

  private  void deleteAtTail() {
    if (size == 0) {
      return;
    } else if (size == 1) {
      deleteAtHead();
    } else {
      tail = tail.prev;
      tail.next = null;
      size--;
    }
  }

  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      return;
    }
    else if (index == 0) {
      addAtHead(val);
    } else if (index == size) {
      addAtTail(val);
    } else {
      MyLLNode prev = head;
      for (int i = 0; i < index; i++) {
        prev = prev.next;
      }
      MyLLNode n = new MyLLNode(val);
      n.prev = prev;
      n.next = prev.next;
      n.next.prev = n;
      prev.next = n;
      size++;
    }
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index > size - 1) {
      return;
    } else if (index == 0) {
      deleteAtHead();
    } else if (index == size - 1) {
      deleteAtTail();
    } else {
      MyLLNode prev = head;
      for (int i = 0; i < index; i++) {
        prev = prev.next;
      }
      MyLLNode delNOde = prev.next;
      delNOde.next.prev = prev;
      prev.next = delNOde.next;
      size--;
    }
  }

  public int get(int index) {
    if (index < 0 || index > size - 1) {
      return - 1;
    }

    MyLLNode prev = head;
    for (int i = 0; i < index; i++) {
      prev = prev.next;
    }
    return prev.next.val;
  }

  public void print() {
    System.out.println("size: " + size);
    MyLLNode h = head;
    StringBuilder sb = new StringBuilder(100);
    for (int i = 0; i < size; i++) {
        sb.append(h.next.val);
        if (i != size - 1) {
          sb.append(" -> ");
        }
        h = h.next;
    }
    System.out.println(sb.toString());
    sb = new StringBuilder(100);
    MyLLNode t = tail;
    while (t != head && t != null) {
      sb.append(t.val);
      if (t.prev != head) {
        sb.append(" -> ");
      }
      t = t.prev;
    }
    System.out.println(sb.toString());
  }

  static void testAddHead() {
    DesignLinkedList_0_707 l = new DesignLinkedList_0_707();
    l.print();
    l.addAtHead(1);
    l.addAtHead(2);
    l.addAtHead(3);
    l.deleteAtHead();
    l.print();
    l.deleteAtHead();
    l.print();
    l.deleteAtHead();
    l.print();
  }

  static void testAddAtIndex() {
    DesignLinkedList_0_707 l = new DesignLinkedList_0_707();
    l.addAtTail(55);
    l.addAtTail(66);
    l.addAtTail(77);
    l.print();
    l.addAtIndex(0, 0);
    l.print();
    l.addAtIndex(1, 1);
    l.print();
    l.addAtIndex(2, 2);
    l.print();
    l.addAtIndex(6, 6);
    l.print();

    l.deleteAtIndex(6);
    l.print();
    l.deleteAtIndex(3);
    l.print();
    l.deleteAtIndex(0);
    l.print();

    System.out.println(l.get(0));
    System.out.println(l.get(10));
    System.out.println(l.get(2));

  }

  static void testAddTail() {
    DesignLinkedList_0_707 l = new DesignLinkedList_0_707();
    l.addAtTail(1);
    l.addAtTail(2);
    l.addAtTail(3);
    l.print();
    l.deleteAtTail();
    l.print();
    l.deleteAtTail();
    l.print();
    l.deleteAtTail();
    l.print();


  }

  public static void main(String args[]) {
    //testAddHead();
    //testAddTail();
    testAddAtIndex();
  }
}
