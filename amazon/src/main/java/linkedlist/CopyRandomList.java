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

    while(curHead != null) {
      Node nextHead = curHead.next.next;
      Node copy = curHead.next;
      Node nextAfterCopy = copy.next;
      if(copy.next != null) {
        copy.next = copy.next.next;
      }
      if(curHead.random != null) {
        copy.random = curHead.random.next;
      }
      curHead.next = nextHead;
      curHead = nextHead;
    }
    return res;
  }

  public static void main(String args[]) {
    Node n7 = new Node(7);
    Node n13 = new Node(13);
    Node n11 = new Node(11);
    Node n10 = new Node(10);
    Node n1 = new Node(1);

    n7.next = n13;
    n13.next = n11;
    n11.next = n10;
    n10.next = n1;

    n7.random = null;
    n13.random = n7;
    n11.random = n1;
    n10.random = n11;
    n1.random = n7;

    CopyRandomList c = new CopyRandomList();
    Node r = c.copyRandomList(n7);
    return;
  }

}
