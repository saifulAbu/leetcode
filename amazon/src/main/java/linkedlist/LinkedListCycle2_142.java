package linkedlist;

public class LinkedListCycle2_142 {
  public ListNode detectCycle(ListNode head) {
    if(head == null) {
      return null;
    }

    ListNode f = head, s = head;
    do {
      s = s.next;
      f = f.next;
      if (f == null) {
        break;
      }
      f = f.next;
    } while (s != null && f != null && f != s);
    if (s == null || f == null) {
      return null;
    }

    ListNode s2 = head;
    while (s != s2) {
      s = s.next;
      s2 = s2.next;
    }
    return s;
  }
}
