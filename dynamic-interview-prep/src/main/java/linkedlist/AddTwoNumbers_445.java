package linkedlist;

public class AddTwoNumbers_445 {
  static public ListNode addTwoNumbers(ListNode l0, ListNode l1) {
    //get size
    int n0 = size(l0), n1 = size(l1);
    if (n0 < n1) {
      ListNode tl = l0;
      l0 = l1;
      l1 = tl;

      int t = n0;
      n0 = n1;
      n1 = t;
    }
    ListNode dummyRes = new ListNode(0);
    for (int i = 0; i < n0 - n1; i++) {
      dummyRes.next = new ListNode(l0.val, dummyRes.next);
      l0 = l0.next;
    }

    for (int i = 0; i < n1; i++) {
      dummyRes.next = new ListNode(l0.val + l1.val, dummyRes.next);
      l0 = l0.next;
      l1 = l1.next;
    }

    //take care of carry
    int c = 0;
    ListNode curH = dummyRes;
    while (curH.next != null) {
      int v = curH.next.val + c;
      curH.next.val = v % 10;
      c = v / 10;
      curH = curH.next;
    }

    if (c == 1) {
      curH.next = new ListNode(1);
    }

    //print(reverse(dummyRes.next));
    return reverse(dummyRes.next);
  }

  static private ListNode reverse(ListNode l) {
    ListNode dummyHead = new ListNode(0);
    while (l != null) {
      ListNode cur = l;
      l = l.next;
      cur.next = dummyHead.next;
      dummyHead.next = cur;
    }
    return dummyHead.next;
  }

  static private int size(ListNode l) {
    int size = 0;
    while (l != null) {
      size++;
      l = l.next;
    }
    return size;
  }

  public static void main(String[] s) {
    ListNode l0, l1;
    l0 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    l1 =  new ListNode(0, new ListNode(0, new ListNode(1)));

    //System.out.println(size(l0));
    //print(l0);
    //print(reverse(l0));
    addTwoNumbers(l0, l1);
  }

  static private void print(ListNode l) {
    while (l != null) {
      System.out.print(l.val + " ");
      l = l.next;
    }
    System.out.println();
  }

}
