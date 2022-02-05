package linkedlist;

public class ReverseNodesKGroup_25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    return reverseGrpHelper(head, k);
  }

  private ListNode reverseGrpHelper(ListNode head, int k) {
    ListNode cur = head;
    int i = k;
    while (cur != null && i > 1) {
      cur = cur.next;
      i--;
    }
    if(i > 1 || cur == null) return head;
    ListNode nextHead = cur.next;
    cur.next = null;
    reverse(head);
    //head node becomes tail
    head.next = reverseKGroup(nextHead, k);
    //tail becomes head
    return cur;
  }

  private ListNode reverse(ListNode head) {
    ListNode lh = new ListNode();
    while (head != null) {
      ListNode cur = head;
      head = head.next;
      cur.next = lh.next;
      lh.next = cur;
    }
    return lh.next;
  }

  private void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
  }

  public static void main(String args[]) {
    ReverseNodesKGroup_25 r = new ReverseNodesKGroup_25();
   // ListNode l9 = new ListNode(9);
    ListNode l8 = new ListNode(8);
    ListNode l7 = new ListNode(7, l8);
    ListNode l6 = new ListNode(6, l7);
    ListNode l5 = new ListNode(5, l6);
    ListNode l4 = new ListNode(4, l5);
    ListNode l3 = new ListNode(3, l4);
    ListNode l2 = new ListNode(2, l3);
    ListNode l1 = new ListNode(1, l2);

    //r.reverse(l1);
    //r.print(r.reverse(l1));
    r.print(r.reverseKGroup(l1, 3));
  }
}
