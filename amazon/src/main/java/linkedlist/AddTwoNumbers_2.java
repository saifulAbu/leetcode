package linkedlist;

public class AddTwoNumbers_2 {
  ListNode head = new ListNode(Integer.MIN_VALUE), tail = head;

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    while(l1 != null || l2!= null) {
      int d1 = 0, d2 = 0;

      if(l1 != null) {
        d1 = l1.val;
        l1 = l1.next;
      }

      if(l2 != null) {
        d2 = l2.val;
        l2 = l2.next;
      }

      int curSum = d1 + d2 + carry;
      int curDigit = curSum % 10;
      carry = curSum / 10;

      addToTail(curDigit);
    }

    if(carry != 0) {
      addToTail(carry);
    }

    return head.next;
  }

  private void addToTail(int val) {
    ListNode node = new ListNode(val);
    tail.next = node;
    tail = node;
  }

  public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
    ListNode dh = new ListNode(0);
    int carry = 0;
    ListNode res = dh;

    while (l1 != null || l2 != null) {
      int d0 = 0, d1 = 0;
      if (l1 != null) {
        d0 = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        d1 = l2.val;
        l2 = l2.next;
      }
      int s = d0 + d1 + carry;
      carry = s / 10;
      ListNode n = new ListNode(s % 10);
      res.next = n;
      res = n;
    }

    if (carry == 1) {
      res.next = new ListNode(1);
    }

    return dh.next;
  }
}
