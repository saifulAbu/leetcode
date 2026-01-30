package linkedlist;

public class SumList {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(Integer.MIN_VALUE);
    ListNode tail = result;
    int carry = 0;

    while(l1 != null && l2 != null) {
      int curSum = l1.val + l2.val + carry;
      int curBit = curSum % 10;
      carry = curSum / 10;

      tail.next = new ListNode(curBit);
      tail = tail.next;

      l1 = l1.next;
      l2 = l2.next;
    }

    result = result.next;

    if(l1 == null && l2 == null) {
      if(carry != 0) {
        tail.next = new ListNode(carry);
      }
      return result;
    }

    ListNode remaining = l1;
    if(remaining == null) {
      remaining = l2;
    }

    while(remaining != null) {
      int curSum = remaining.val + carry;
      carry = curSum / 10;
      tail.next = new ListNode(curSum % 10);
      tail = tail.next;
      remaining = remaining.next;
    }

    if(carry != 0) {
      tail.next = new ListNode(carry);
    }

    return result;
  }

  public static void main(String args[]) {
    ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
    ListNode l2 = new ListNode(0);

    SumList sl = new SumList();
    ListNode r = sl.addTwoNumbers(l1, l2);

    while(r != null) {
      System.out.print(r.val + " ");
      r = r.next;
    }
    System.out.println();
  }
}
