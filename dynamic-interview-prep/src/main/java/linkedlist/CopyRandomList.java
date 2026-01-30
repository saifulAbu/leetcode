package linkedlist;

public class CopyRandomList {
  private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }

    private void print() {
      String randVal = (random == null ? "null" : Integer.toString(random.val));
      System.out.print("[" + val + ", " + randVal + "] ");
    }
  }

  public Node copyRandomList(Node head) {
    if(head == null) return null;
    Node curHead = head;

    while(curHead != null) {
      Node nextHead = curHead.next;
      Node copy = new Node(curHead.val);
      copy.next = curHead.next;
      curHead.next = copy;
      curHead = nextHead;
    }

    Node res = head.next;
    curHead = head;

    //fix random pointer
    while(curHead != null) {
      Node copy = curHead.next;
      Node nextHead = copy.next;

      if(curHead.random != null) {
        copy.random = curHead.random.next;
      }
      curHead = nextHead;
    }

    curHead = head;
    //fix next pointer
    while(curHead != null) {
      Node copy = curHead.next;
      Node nextHead = copy.next;

      if(nextHead != null) {
        copy.next = nextHead.next;
      }

      curHead.next = nextHead;
      curHead = nextHead;
    }
    return res;
  }

  public static void main(String args[]) {
//    Node n7 = new Node(7);
//    Node n13 = new Node(13);
//    Node n11 = new Node(11);
//    Node n10 = new Node(10);
//    Node n1 = new Node(1);
//
//    n7.next = n13;
//    n13.next = n11;
//    n11.next = n10;
//    n10.next = n1;
//
//    n7.random = null;
//    n13.random = n7;
//    n11.random = n1;
//    n10.random = n11;
//    n1.random = n7;
    Node n0 = new Node(0);
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);

    n1.next = n2;
    n2.next = n3;

    n2.random = n1;
    n3.random = n2;
    CopyRandomList c = new CopyRandomList();
    Node r = c.copyRandomList(n1);


     c.printList(n1);
     System.out.println();
     c.printList(r);
    return;
  }

  void printList(Node head) {
    while(head != null) {
      head.print();
      head = head.next;
    }
  }

}
