package linkedlist;

public class LinkedListCycle_141 {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow, fast;
    slow = head;
    fast = head.next;

    while (slow != null && fast != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next;
      if (fast!=null) {
        fast = fast.next;
      }
    }

    return false;
  }
}
